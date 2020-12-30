DROP DATABASE IF EXISTS robotichoover;
CREATE DATABASE robotichoover;

CREATE TABLE robotichoover.history (
  id INT NOT NULL AUTO_INCREMENT,
  input JSON NOT NULL,
  output JSON NOT NULL,
  PRIMARY KEY (id)
);
