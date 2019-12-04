DROP DATABASE eshop_db;

SET GLOBAL local_infile = true;
USE eshop_db;
/*----------------------------------------------*/

DELETE FROM customer;
DELETE FROM address;
DELETE FROM phone;
DELETE FROM orders;
DELETE FROM order_items;
DELETE FROM units;
DELETE FROM package;
DELETE FROM resistor_parameters;
DELETE FROM component;

/*----------------------------------------------*/

DELETE FROM customer WHERE id=1;
DELETE FROM orders WHERE customer=3;

/*----------------------------------------------*/

UPDATE customer SET name = 'Jim' WHERE id=1;
UPDATE customer SET id = 88 WHERE id=4;

/*----------------------------------------------*/

SELECT * FROM customer;
SELECT * FROM address;
SELECT * FROM phone;
SELECT * FROM orders;
SELECT * FROM order_items;
SELECT * FROM units;
SELECT * FROM package;
SELECT * FROM resistor_parameters;
SELECT * FROM component;

/*----------------------------------------------*/

LOAD DATA LOCAL INFILE '/home/mihail/programs/mysql_models/eshop_db_v2/DataFiles/customers.txt' INTO TABLE customer;
LOAD DATA LOCAL INFILE '/home/mihail/programs/mysql_models/eshop_db_v2/DataFiles/address.txt' INTO TABLE address;
LOAD DATA LOCAL INFILE '/home/mihail/programs/mysql_models/eshop_db_v2/DataFiles/phone.txt' INTO TABLE phone;
LOAD DATA LOCAL INFILE '/home/mihail/programs/mysql_models/eshop_db_v2/DataFiles/order.txt' INTO TABLE orders;
LOAD DATA LOCAL INFILE '/home/mihail/programs/mysql_models/eshop_db_v2/DataFiles/order.txt' INTO TABLE order_items;
LOAD DATA LOCAL INFILE '/home/mihail/programs/mysql_models/eshop_db_v2/DataFiles/units.txt' INTO TABLE units;
LOAD DATA LOCAL INFILE '/home/mihail/programs/mysql_models/eshop_db_v2/DataFiles/package.txt' INTO TABLE package;
LOAD DATA LOCAL INFILE '/home/mihail/programs/mysql_models/eshop_db_v2/DataFiles/resistor_parameters.txt' INTO TABLE resistor_parameters;
LOAD DATA LOCAL INFILE '/home/mihail/programs/mysql_models/eshop_db_v2/DataFiles/component.txt' INTO TABLE component;

/*----------------------------------------------*/