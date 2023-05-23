DROP TABLE sales_transaction;
DROP TABLE transaction_item;
CREATE TABLE sales_transaction (id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                                transaction_number INT(6) unique not null,
                                description varchar(25) NOT NULL,
                                transaction_value integer(20) NOT NULL
                               );

CREATE TABLE transaction_item (id INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
                               transaction_number INT(6),
                               item_number INT(6),
                               description varchar(25) NOT NULL,
                               item_value integer(20) NOT NULL,
                               FOREIGN KEY (transaction_number) REFERENCES sales_transaction(transaction_number));

INSERT INTO sales_transaction (transaction_number, description, transaction_value) VALUES  (1,  'SalesTransaction1', 100);
INSERT INTO sales_transaction (transaction_number, description, transaction_value) VALUES  (2,  'SalesTransaction2', 200);
INSERT INTO sales_transaction (transaction_number, description, transaction_value) VALUES  (3,  'SalesTransaction2', 300);

INSERT INTO transaction_item (transaction_number, item_number, description, item_value) VALUES  (  1, 1, 'Item 1', 20);
INSERT INTO transaction_item (transaction_number, item_number, description, item_value) VALUES  (  1, 2, 'Item 2', 30);
INSERT INTO transaction_item (transaction_number, item_number, description, item_value) VALUES  (  1, 3, 'Item 3', 50);
INSERT INTO transaction_item (transaction_number, item_number, description, item_value) VALUES  (  2, 1, 'Item 4', 150);
INSERT INTO transaction_item (transaction_number, item_number, description, item_value) VALUES  (  2, 2, 'Item 5', 50);
INSERT INTO transaction_item (transaction_number, item_number, description, item_value) VALUES  (  3, 1, 'Item 6', 250);
INSERT INTO transaction_item (transaction_number, item_number, description, item_value) VALUES  (  3, 2, 'Item 7', 60);
