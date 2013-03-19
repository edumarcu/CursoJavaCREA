
CREATE TABLE log_entries (
  id          INT           NOT NULL AUTO_INCREMENT PRIMARY KEY,
  ip          VARCHAR(255)  NOT NULL,
  method      CHAR(6)       NOT NULL,
  path        VARCHAR(255)  NOT NULL,
  created_at  TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)
