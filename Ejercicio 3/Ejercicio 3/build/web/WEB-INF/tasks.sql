CREATE TABLE tasks (
  id    INT           NOT NULL AUTO_INCREMENT PRIMARY KEY,
  text  VARCHAR(255)  NOT NULL,
  done  TINYINT       NOT NULL DEFAULT 0
);
