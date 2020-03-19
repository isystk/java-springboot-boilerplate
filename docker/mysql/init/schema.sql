
CREATE DATABASE IF NOT EXIST sample DEFAULT CHARACTER SET utf8mb4;

USE sample;

CREATE TABLE IF NOT EXISTS item (
  id bigint(20) NOT NULL AUTO_INCREMENT,
  name varchar(255),
  price real,
  vendor varchar(255),
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
