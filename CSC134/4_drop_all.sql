/* Drop all tables from the db */
/* The order chosen will drop all tables without any conflicts */
/* With CASCADING used on DELETE, there shouldn't be any conflicts anyways */
DROP TABLE HAD;
DROP TABLE ACCIDENT;
DROP TABLE OWNS;
DROP TABLE CAR;
DROP TABLE POLICY;
DROP TABLE CUSTOMER;

/* Check to see that all tables were sucessfully dropped */
SHOW TABLES;