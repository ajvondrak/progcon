# encoding: utf-8

# I've gotta brush up on Ruby & SQL, so I'm challenging myself to write a
# programming contest solution in as close to pure SQL as I can, with some Ruby
# plumbing as necessary.

require 'sqlite3'

def extends(db, sub, sup)
  exists = 'SELECT 1 FROM hierarchy WHERE subclass = ?1 AND superclass = ?2'
  return unless db.execute(exists, [sub, sup]).empty?
  insert = 'INSERT INTO hierarchy(subclass, superclass) VALUES (?1, ?2);'
  db.execute(insert, [sub, sup])
  expand = 'SELECT DISTINCT ?1, superclass FROM hierarchy WHERE subclass = ?2;'
  db.execute(expand, [sub, sup]) { |row| extends(db, *row) }
  extends(db, sub, sub)
  extends(db, sup, sup)
end

def declare(db, return_type, method_name, formals)
  insert = 'INSERT INTO method(return, name) VALUES (?1, ?2);'
  db.execute(insert, [return_type, method_name])
  method_id = db.last_insert_row_id
  insert = 'INSERT INTO formal(method_id, type, offset) VALUES (?1, ?2, ?3);'
  formals.each.with_index do |formal, offset|
    db.execute(insert, [method_id, formal, offset])
  end
end

def declaration_parts(line)
  parts = line.chomp.split(/[ ,()]+/)
  [parts[0], parts[1], parts[2..-1]]
end

def declaration(db, method_id)
  method = 'SELECT return, name FROM method WHERE id = ?'
  decl = db.execute(method, [method_id]).join(' ')
  formals = 'SELECT type FROM formal WHERE method_id = ? ORDER BY offset'
  decl + "(#{db.execute(formals, [method_id]).join(', ')})"
end

def matching_methods(db, context_type, method_name)
  method_ids = <<SQL
SELECT method.id
FROM method, hierarchy
WHERE method.name = ?2 AND
      method.return = hierarchy.subclass AND
      ?1 = hierarchy.superclass;
SQL
  db.execute(method_ids, [context_type, method_name]).flatten
end

def matches_formals(db, method_id, actuals)
  matches_formal = <<SQL
SELECT 1 FROM formal, hierarchy
WHERE formal.method_id = ?1 AND
      formal.offset = ?3 AND
      formal.type = hierarchy.superclass AND
      ?2 = hierarchy.subclass;
SQL
  actuals.to_enum.with_index.all? do |actual, offset|
    !db.execute(matches_formal, [method_id, actual, offset]).empty?
  end
end

def matches_arg_count(db, method_id, actuals)
  count_formals = 'SELECT COUNT(offset) FROM formal WHERE method_id = ?'
  db.get_first_value(count_formals, method_id) == actuals.length
end

def matches(db, context_type, method_name, actuals)
  matching_methods(db, context_type, method_name).select do |id|
    matches_arg_count(db, id, actuals) && matches_formals(db, id, actuals)
  end
end

SQLite3::Database.new(':memory:') do |db|
  db.execute_batch(<<SQL)
CREATE TABLE hierarchy (
  subclass TEXT,
  superclass TEXT
);

INSERT INTO hierarchy VALUES ('Object', 'Object');
INSERT INTO hierarchy VALUES ('void', 'void'); /* ? */

CREATE TABLE method (
  id INTEGER PRIMARY KEY,
  return TEXT,
  name TEXT
);

CREATE TABLE formal (
  method_id INTEGER,
  type TEXT,
  offset INTEGER,
  FOREIGN KEY(method_id) REFERENCES method(id)
);
SQL

  hierarchy, declarations, invocations = $stdin.read.split(/\n\n/)
  hierarchy.each_line { |line| extends(db, *line.chomp.split(/ extends /)) }
  declarations.each_line { |line| declare(db, *declaration_parts(line)) }
  invocations.each_line do |line|
    puts "actual: #{line}"
    matches(db, *declaration_parts(line)).each do |id|
      puts "formal: #{declaration(db, id)}"
    end
    puts
  end
end
