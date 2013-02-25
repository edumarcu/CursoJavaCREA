CREATE TABLE books (
  id          INT UNSIGNED      AUTO_INCREMENT NOT NULL PRIMARY KEY,
  isbn        VARCHAR(20)       NOT NULL,
  title       VARCHAR(255)      NOT NULL,
  year        SMALLINT,
  author_id   INT UNSIGNED,
  UNIQUE KEY (isbn)
);

CREATE TABLE authors (
  id          INT UNSIGNED      AUTO_INCREMENT NOT NULL PRIMARY KEY,
  name        VARCHAR(50)       NOT NULL,
  birthday    DATE,
  country     VARCHAR(50)
);