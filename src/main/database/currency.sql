
DROP DATABASE IF EXISTS currency_exchange;
CREATE DATABASE currency_exchange;

USE currency_exchange;
DROP USER IF EXISTS 'appuser'@'localhost';

CREATE USER 'appuser'@'localhost' IDENTIFIED BY 'password';

GRANT SELECT ON currency_exchange.* TO 'appuser'@'localhost';

CREATE TABLE currencies (
                            id INT AUTO_INCREMENT PRIMARY KEY,
                            abbreviation VARCHAR(10) UNIQUE NOT NULL,
                            name VARCHAR(100) NOT NULL,
                            conversion_rate DECIMAL(18, 6) NOT NULL
);

INSERT INTO currencies (abbreviation, name, conversion_rate) VALUES
                                                                 ('USD', 'United States Dollar', 1.000000),
                                                                 ('EUR', 'Euro', 0.93),
                                                                 ('GBP', 'British Pound Sterling', 0.80),
                                                                 ('JPY', 'Japanese Yen', 155.7),
                                                                 ('AUD', 'Australian Dollar', 1.51),
                                                                 ('CAD', 'Canadian Dollar', 1.37),
                                                                 ('CHF', 'Swiss Franc', 0.91),
                                                                 ('CNY', 'Chinese Yuan', 7.23);

SELECT * FROM currencies;

SELECT * FROM currencies WHERE abbreviation = 'EUR';

SELECT COUNT(*) AS num_currencies FROM currencies;

SELECT * FROM currencies ORDER BY conversion_rate DESC LIMIT 1;

