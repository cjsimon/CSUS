/* CREATE DATABASE cs134230; */
USE cs134230;

CREATE TABLE CUSTOMER(
    SSN                 VARCHAR(9)
    Customer_Name       VARCHAR(30)
    Street              VARCHAR(20)
    City                VARCHAR(10)
    State               VARCHAR(10)
    Zip                 CHAR(5)
    Phone               CHAR(10)
    
    PRIMARY KEY(SSN)
) ENGINE = InnoDB;

CREATE TABLE OWNS(
    SSN                 CHAR(9)
    License             VARCHAR(15)
    
    PRIMARY KEY(SSN, License)
    FOREIGN KEY(SSN)
    FOREIGN KEY(License)
) ENGINE = InnoDB;

CREATE TABLE CAR(
    License             VARCHAR(15)
    Model               VARCHAR(15)
    Year                INT
    PolicyNo_Ref        INT
    
    PRIMARY KEY(License)
    FOREIGN KEY(PolicyNo_Ref)
) ENGINE = InnoDB;

CREATE TABLE POLICY(
    PolicyNo            INT
    Policy_Rate         DECIMAL(15, 2)
    Policy_Details      VARCHAR(100)
    
    PRIMARY KEY(PolicyNo)
) ENGINE = InnoDB;

CREATE TABLE HAD(
    License             VARCHAR(15)
    AccidentNo          INT
    
    PRIMARY KEY(License, AccidentNo)
    FOREIGN KEY(License)
    FOREIGN KEY(AccidentNo)
) ENGINE = InnoDB;

CREATE TABLE ACCIDENT(
    Accident_no         INT
    Driver_Name         VARCHAR(30)
    Accident_Date       DATE /* 'yyyy-mm-dd' */
    Amount_of_Damage    DECIMAL(15, 2)
    Accident_Details    VARCHAR(100)
    
    PRIMARY KEY(License, AccidentNo)
) ENGINE = InnoDB;