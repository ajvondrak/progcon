# I've gotta brush up on Ruby & SQL, so I'm challenging myself to write a
# programming contest solution in as close to pure SQL as I can, with some Ruby
# plumbing as necessary.

require 'sqlite3'

def extends(db, sub, sup)
  exists = 'SELECT 1 FROM hierarchy WHERE subclass = ?1 AND superclass = ?2'
  return unless db.execute(exists, sub, sup).empty?
  insert = 'INSERT INTO hierarchy(subclass, superclass) VALUES (?1, ?2);'
  db.execute(insert, sub, sup)
  expand = 'SELECT DISTINCT ?1, superclass FROM hierarchy WHERE subclass = ?2;'
  db.execute(expand, sub, sup) do |row|
    extends(db, *row)
  end
end

def declare(db, return_type, method_name, formals)
  insert = 'INSERT INTO method(return, name) VALUES (?1, ?2);'
  db.execute(insert, return_type, method_name)
  method_id = db.last_insert_row_id
  insert = 'INSERT INTO formal(method_id, type, offset) VALUES (?1, ?2, ?3);'
  formals.each.with_index {|formal, offset|
    db.execute(insert, method_id, formal, offset)
  }
end

def matching(db, context_type, method_name, actuals)
  sql = <<SQL
SELECT method.id
FROM method
WHERE method.name = ?1 AND
      TODO;
SQL
end

SQLite3::Database.new(':memory:') do |db|

  db.execute_batch(<<SQL)
CREATE TABLE hierarchy (
  subclass TEXT,
  superclass TEXT
);

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

  extends(db, 'Object', 'Object')
  extends(db, 'void', 'void') # XXX

  extends(db, 'Number', 'Object')
  extends(db, 'Byte', 'Number')
  extends(db, 'Integer', 'Byte')
  extends(db, 'Widget', 'Object')
  extends(db, 'Shape', 'Object')
  extends(db, 'Rectangle', 'Shape')
  extends(db, 'Square', 'Rectangle')

  declare(db, 'void', 'mash', ['Number', 'Shape'])
  declare(db, 'Number', 'area', ['Shape'])
  declare(db, 'Integer', 'area', ['Shape'])
  declare(db, 'void', 'area', ['Square'])
  declare(db, 'Byte', 'area', ['Rectangle'])
  declare(db, 'Number', 'side', ['Square'])
  declare(db, 'void', 'doIt', [])

  ['hierarchy', 'method', 'formal'].each do |table|
    puts "=== #{table}"
    db.execute("SELECT * FROM #{table}") do |row|
      p row
    end
  end

  # hierarchy, declarations, invocations = $stdin.read.split(/\n\n/)
end
