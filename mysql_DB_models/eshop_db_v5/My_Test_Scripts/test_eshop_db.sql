DROP DATABASE eshop_db;

SET GLOBAL local_infile = true;
USE eshop_db;
/*----------------------------------------------*/

DELETE FROM customer;
DELETE FROM address;
DELETE FROM phone;
DELETE FROM orders;
DELETE FROM category;
DELETE FROM order_components;
DELETE FROM units;
DELETE FROM package;
DELETE FROM resistor;
DELETE FROM transistor;
DELETE FROM ics;
DELETE FROM diode;
DELETE FROM capacitor;

/*----------------------------------------------*/

DELETE FROM customer WHERE id=4;
DELETE FROM orders WHERE customer=3;
DELETE FROM category WHERE category_id = 77;

/*----------------------------------------------*/

UPDATE customer SET name = 'Jim' WHERE id=1;
UPDATE customer SET id = 88 WHERE id=3;
UPDATE orders SET order_id = 55 WHERE price=196;
UPDATE category SET category_id = 77 WHERE category_id = 2;

/*----------------------------------------------*/

SELECT * FROM customer;
SELECT * FROM address;
SELECT * FROM phone;
SELECT * FROM orders;
SELECT * FROM category;
SELECT * FROM order_components;
SELECT * FROM units;
SELECT * FROM package;
SELECT * FROM resistor;
SELECT * FROM transistor;
SELECT * FROM ics;
SELECT * FROM diode;
SELECT * FROM capacitor;

/*----------------------------------------------*/

LOAD DATA LOCAL INFILE '/home/mihail/programs/mysql_models/eshop_db_v3/DataFiles/customers.txt' INTO TABLE customer;
LOAD DATA LOCAL INFILE '/home/mihail/programs/mysql_models/eshop_db_v3/DataFiles/address.txt' INTO TABLE address;
LOAD DATA LOCAL INFILE '/home/mihail/programs/mysql_models/eshop_db_v3/DataFiles/phone.txt' INTO TABLE phone;
LOAD DATA LOCAL INFILE '/home/mihail/programs/mysql_models/eshop_db_v3/DataFiles/order.txt' INTO TABLE orders;
LOAD DATA LOCAL INFILE '/home/mihail/programs/mysql_models/eshop_db_v3/DataFiles/category.txt' INTO TABLE category;
LOAD DATA LOCAL INFILE '/home/mihail/programs/mysql_models/eshop_db_v3/DataFiles/order_components.txt' INTO TABLE order_components;
LOAD DATA LOCAL INFILE '/home/mihail/programs/mysql_models/eshop_db_v3/DataFiles/units.txt' INTO TABLE units;
LOAD DATA LOCAL INFILE '/home/mihail/programs/mysql_models/eshop_db_v3/DataFiles/package.txt' INTO TABLE package;
LOAD DATA LOCAL INFILE '/home/mihail/programs/mysql_models/eshop_db_v3/DataFiles/resistor.txt' INTO TABLE resistor;
LOAD DATA LOCAL INFILE '/home/mihail/programs/mysql_models/eshop_db_v3/DataFiles/transistor.txt' INTO TABLE transistor;
LOAD DATA LOCAL INFILE '/home/mihail/programs/mysql_models/eshop_db_v3/DataFiles/ics.txt' INTO TABLE ics;
LOAD DATA LOCAL INFILE '/home/mihail/programs/mysql_models/eshop_db_v3/DataFiles/diode.txt' INTO TABLE diode;
LOAD DATA LOCAL INFILE '/home/mihail/programs/mysql_models/eshop_db_v3/DataFiles/capacitor.txt' INTO TABLE capacitor;

/*----------------------------------------------*/