DROP TABLE IF EXISTS transfer;

CREATE TABLE transfer (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  amount DECIMAL(10,2) NOT NULL,
  fee_amount DECIMAL(10,2) NOT NULL,
  created_at  DATE NOT NULL,
  transfer_at DATE NOT NULL,
  origin varchar(20) NOT NULL,
  destination varchar(20) NOT NULL,
  type VARCHAR(20) NOT NULL
);

