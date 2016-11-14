/* CREATE DATABASE cs134230; */
USE cs134230;

/* Create and then show the column schema of each the tables */
CREATE TABLE CUSTOMER(
    SSN             VARCHAR(9)      NOT NULL,
    Customer_Name   VARCHAR(30)     NOT NULL,
    Street          VARCHAR(20),
    City            VARCHAR(10),
    State           VARCHAR(10),
    Zip             CHAR(5),
    Phone           CHAR(10),

    PRIMARY KEY(SSN)
)ENGINE=InnoDB;
SHOW COLUMNS FROM CUSTOMER;

CREATE TABLE POLICY(
    PolicyNo        INT,
    Policy_Rate     DECIMAL(15, 2)  NOT NULL,
    Policy_Details  VARCHAR(100),

    PRIMARY KEY(PolicyNo)
)ENGINE=InnoDB;
SHOW COLUMNS FROM POLICY;

CREATE TABLE CAR(
    License         VARCHAR(15),
    Model           VARCHAR(15),
    Year            INT,
    PolicyNo_Ref    INT,

    PRIMARY KEY(License),
    FOREIGN KEY(PolicyNo_Ref) REFERENCES POLICY(PolicyNo)
)ENGINE=InnoDB;
SHOW COLUMNS FROM CAR;

CREATE TABLE OWNS(
    SSN     CHAR(9),
    License VARCHAR(15),

    PRIMARY KEY(SSN, License),
    FOREIGN KEY(SSN)     REFERENCES CUSTOMER(SSN),
    FOREIGN KEY(License) REFERENCES CAR(License)
)ENGINE=InnoDB;
SHOW COLUMNS FROM OWNS;

CREATE TABLE ACCIDENT(
    Accident_no         INT,
    Driver_Name         VARCHAR(30),
    /**
     *  Planned on using: DEFAULT GETDATE()
     *  However, DEFAULT value must be a constant
     *  @see: http://stackoverflow.com/a/21054122/2104168
     */
    Accident_Date       DATE, /*yyyy-mm-dd*/
    Amount_of_Damage    DECIMAL(15, 2),
    Accident_Details    VARCHAR(100),

    PRIMARY KEY(Accident_no)
)ENGINE=InnoDB;
SHOW COLUMNS FROM ACCIDENT;

CREATE TABLE HAD(
    License     VARCHAR(15),
    AccidentNo  INT,

    PRIMARY KEY(License, AccidentNo),
    FOREIGN KEY(License)    REFERENCES CAR(License),
    FOREIGN KEY(AccidentNo) REFERENCES ACCIDENT(Accident_No)
)ENGINE=InnoDB;
SHOW COLUMNS FROM HAD;