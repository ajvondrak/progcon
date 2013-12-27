# I've gotta brush up on Ruby & SQL, so I'm challenging myself to write a
# programming contest solution in nearly-pure SQL, with some Ruby plumbing for
# I/O.

require 'sqlite3'

SQLite3::Database.new(':memory:') do |db|
  db.execute('CREATE TABLE object (id INTEGER PRIMARY KEY, name TEXT);')
  db.execute("INSERT INTO object(name) VALUES ('Object');")

  puts '=== Table'

  db.execute('SELECT id, name FROM object') do |row|
    p row
  end

  hierarchy, declarations, invocations = $stdin.read.split(/\n\n/)

  puts '=== Class Hierarchy'
  puts hierarchy

  puts '=== Method Declarations'
  puts declarations

  puts '=== Method Invocations'
  puts invocations
end
