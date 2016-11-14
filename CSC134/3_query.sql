/*******************************************************************************
 * Query 1:
 * List the cars (license, model and year, Amount_of_Damage)
 * that have been involved in any accidents.
 * Order the result by license in descending order.
 ******************************************************************************/
SELECT   c.License, c.Model, c.Year, a.Amount_of_Damage
FROM     CAR AS c, HAD AS h, ACCIDENT AS a
WHERE    c.License = h.License AND h.AccidentNo = a.Accident_No
ORDER BY c.License DESC;

/*******************************************************************************
 * Query 2:
 * List the cars that have more than two accidents.
 * List license and number of accidents.
 * *****************************************************************************
 * Original Attempt:
 * SELECT DISTINCT c.License, NumberOfAccidents
 * FROM   CAR AS c, HAD AS h, ACCIDENT AS a
 * WHERE  c.License = h.License AND h.AccidentNo = a.Accident_No
 * AND    (SELECT COUNT(*)
 *         FROM   CAR AS c, HAD AS h, ACCIDENT AS a
 *         WHERE  c.License = h.License
 *         AND    h.AccidentNo = a.Accident_No) AS NumberOfAccidents > 2;
 * 
 * Incorrect: This will not group licenses.
 *            This will include all licenses together.
 * Solution:  Group by license to get seperate
 *            results for each license seperatly.                             
 ******************************************************************************/
SELECT   c.License, COUNT(*) AS NumberOfAccidents
FROM     CAR AS c, HAD AS h, ACCIDENT AS a
WHERE    c.License = h.License AND h.AccidentNo = a.Accident_No
GROUP BY c.License
HAVING   NumberOfAccidents > 2;

/*******************************************************************************
 * Query 3:
 * List information (driver name, amount of damage, license, model and SSN)
 * about the accidents in which the owner of the car are involved
 * i.e., the Driver_Name and Customer_Name are the same.
 ******************************************************************************/
SELECT a.Driver_Name, a.Amount_of_Damage, cr.License, cr.Model, cm.SSN
FROM   CUSTOMER AS cm, CAR AS cr, ACCIDENT AS a, HAD AS h, OWNS AS o
WHERE  cm.SSN = o.SSN
       AND o.License = cr.License
       AND cr.License = h.License
       AND h.AccidentNo = a.Accident_No
       AND cm.Customer_Name = a.Driver_Name;

/*******************************************************************************
 * Query 4
 * Obtain the information of any policy
 * (policy number, policy rate and policy details)
 * whose policy rate is higher than the rate of policy number 12.
 ******************************************************************************/
SELECT   p.PolicyNo, p.Policy_Rate, p.Policy_Details
FROM     POLICY AS p
GROUP BY p.Policy_Rate
HAVING   p.Policy_Rate > (SELECT DISTINCT Policy_Rate
                          FROM   POLICY
                          WHERE  PolicyNo = 12);
 
/*******************************************************************************
 * Query 5:
 * Consider all policies, list the lowest rate, highest rate, and average rate.
 ******************************************************************************/ 
SELECT MIN(Policy_Rate), MAX(Policy_Rate), AVG(Policy_Rate)
FROM   POLICY;

/*******************************************************************************
 * Query 6:
 * Get information (accident number, driver name, accident date and damage)
 * of the accident which has the highest amount of damage among all accidents.
 *******************************************************************************
 * Original Attempt:
 * SELECT Accident_No, Driver_Name, Accident_Date, Amount_of_Damage
 * FROM   ACCIDENT
 * WHERE  Amount_of_Damage = MAX(Amount_of_Damage);
 * 
 * Error:    Invalid use of grouping function:
 *           Max can't be applied to WHERE clause.
 * Solution: Use a subquery to get the max amount.
 * Note:     Amount_of_Damage is not the same as a.Amount_of_Damage.
 *           They are seperate references to the same table.
 ******************************************************************************/
SELECT Accident_No, Driver_Name, Accident_Date, Amount_of_Damage
FROM   ACCIDENT
WHERE  Amount_of_Damage = (SELECT MAX(Amount_of_Damage) FROM ACCIDENT);


/*******************************************************************************
 * Query 7:
 * Get the information (customer name, city and state)
 * about the customers who own cars with the model of 'Honda Accord'.
 * Also get those cars' licenses and year made.
 ******************************************************************************/
SELECT cm.Customer_Name, cm.City, cm.State, cr.License, cr.Year
FROM   CUSTOMER AS cm, CAR AS cr, OWNS AS o
WHERE  cm.SSN = o.SSN AND o.License = cr.License AND cr.Model = 'Honda Accord';

/*******************************************************************************
 * Query 8:
 * Retrieve customers' information (SSN, name, street, city, state, zip)
 * who live either in the cities 'Roseville' or 'Sunrise'.
 ******************************************************************************/
SELECT SSN, Customer_Name, Street, City, Zip
FROM   CUSTOMER
WHERE  City = 'Roseville' OR City = 'Sunrise';
/* OR */
SELECT SSN, Customer_Name, Street, City, Zip
FROM   CUSTOMER
WHERE  City IN ('Roseville', 'Sunrise');

/*******************************************************************************
 * Query 9:
 * Retrieve policies that cover more than 2 cars.
 * List policy number and number of cars covered.
 ******************************************************************************/
SELECT   p.PolicyNo, COUNT(*) AS CarsCovered
FROM     POLICY AS p, CAR AS c
WHERE    c.PolicyNo_Ref = p.PolicyNo
GROUP BY p.PolicyNo
HAVING   CarsCovered > 2;
