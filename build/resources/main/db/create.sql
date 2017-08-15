SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS animals (
  id int PRIMARY KEY auto_increment,
  name VARCHAR,
  gender VARCHAR,
  type VARCHAR,
  breed VARCHAR,
  admitdate TIMESTAMP
);

CREATE TABLE IF NOT EXISTS customers (
  id int PRIMARY KEY auto_increment,
  name VARCHAR,
  phonenum INTEGER,
  animalpreference VARCHAR,
  breedpreference VARCHAR,
);
