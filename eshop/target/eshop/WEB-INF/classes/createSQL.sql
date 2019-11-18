
/* Use "No database" connection, such as "jdbc:mysql://localhost:3306/" to execute next three commands. */
SET GLOBAL local_infile = true; /* Set MySQL global variable to permit command "LOAD DATA LOCAL...". */
DROP DATABASE localeDB;
CREATE DATABASE localeDB;

/* Use database specific connection, such as "jdbc:mysql://localhost:3306/localeDB" to execute next commands. */
USE localeDB;
CREATE TABLE localetable(ID int PRIMARY KEY, locale VARCHAR(10), msgkey VARCHAR(100), message VARCHAR(250));
LOAD DATA LOCAL INFILE 'c:/sysit/project_mvn/i18n_db/src/main/resources/locale.txt' INTO TABLE localetable;

CREATE TABLE test(Name VARCHAR(5) NOT NULL);
LOAD DATA LOCAL INFILE 'c:/sysit/project_mvn/i18n_db/src/main/resources/test.txt' INTO TABLE test;