
SET GLOBAL local_infile = true;
USE eshop_db;
/*----------------------------------------------*/

SELECT * FROM producer;
SELECT * FROM category;
SELECT * FROM units;
SELECT * FROM package;
SELECT * FROM resistor;
SELECT * FROM transistor;
SELECT * FROM ics;
SELECT * FROM diode;
SELECT * FROM capacitor;
SELECT * FROM LED;
SELECT * FROM relay;
SELECT * FROM connector;
SELECT * FROM tumbler;
SELECT * FROM power_supply;
SELECT * FROM locale;
/*----------------------------------------------*/
/*
SHOW TABLES;
CREATE TABLE locale(ID int PRIMARY KEY, locale VARCHAR(10), msgkey VARCHAR(100), message VARCHAR(250));
*/
/*----------------------------------------------*/
/*
DROP TABLE locale;
*/
/*----------------------------------------------*/
/*
LOAD DATA LOCAL INFILE '/home/mihail/programs/mysql_models/eshop_db_v5/My_DataFiles_for_eshopDB/producer.txt' INTO TABLE producer;
LOAD DATA LOCAL INFILE '/home/mihail/programs/mysql_models/eshop_db_v5/My_DataFiles_for_eshopDB/category.txt' INTO TABLE category;
LOAD DATA LOCAL INFILE '/home/mihail/programs/mysql_models/eshop_db_v5/My_DataFiles_for_eshopDB/units.txt' INTO TABLE units;
LOAD DATA LOCAL INFILE '/home/mihail/programs/mysql_models/eshop_db_v5/My_DataFiles_for_eshopDB/package.txt' INTO TABLE package; */
LOAD DATA LOCAL INFILE '/home/mihail/programs/mysql_models/eshop_db_v6/My_DataFiles_for_eshopDB/locale.txt' INTO TABLE locale;

/*----------------------------------------------*/

/*
DELETE FROM producer WHERE (producer_id>30 AND producer_id<54);
DELETE FROM producer WHERE producer_id=59;

DELETE FROM producer;
DELETE FROM category;
DELETE FROM units;
DELETE FROM package;
DELETE FROM capacitor;
DELETE FROM LED;
DELETE FROM relay;
DELETE FROM locale;
*/
/*----------------------------------------------*/
