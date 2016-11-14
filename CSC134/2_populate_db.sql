/* Test data used to test queries from section 3 */
/* Create and show the data of each table        */

INSERT INTO CUSTOMER(SSN, Customer_Name, Street, City, State, Zip, Phone)
VALUES
/******************************************************************************************************************
 SSN        Customer Name             Street                City               State            Zip    Phone     */
(734629815, 'Taylor Andrews',         'Merchant Avenue',    'Fresno',          'New Jersey',    84319, 4378649123),
(764892315, 'Savanah Paige',          'Robin Coach Avenue', 'Concord',         'New Hampshire', 84319, 5774573168),
(789456123, 'Myong Nevers',           'Pied Embers Jetty',  'Oklahoma City',   'New Mexico',    53562, 5718874771),
(123456789, 'Leonora Mcmenamin',      'Blue Robin Avenue',  'Fresno',          'Hawaii',        27834, 3284924410),
(987654321, 'Vernell Frisina',        'Coach Route',        'St. Louis',       'Rhode Island',  60107, 1639756552),
(147258369, 'Francisco Rothenberger', 'Dawn Avenue',        'Raleigh',         'Iowa',          73052, 1382025053),
(963852741, 'Julienne Alexandra',     'Boulder Lane',       'Greensboro',      'Indiana',       74424, 3391609432),
(852963147, 'Roy Derby',              'River Avenue',       'Cincinnati',      'Alabama',       27302, 6529390676),
(624589317, 'Jene Halladay',          'Merchant Row',       'Cleveland',       'Minnesota',     70115, 3196980042),
(432156987, 'Albertine Geiger',       'Kings Route',        'North Hempstead', 'Wisconsin',     72039, 3976505091),
(195378624, 'Minerva Pellegrini',     'Paradise Street',    'Dallas',          'Illinois',      55316, 8015898390),
(156324789, 'Corrina Mauney',         'Farmer Avenue',      'Jersey City',     'Minnesota',     26301, 5742288505),
(675489312, 'Rosaria Hartline',       'Medieval Avenue',    'Denver',          'Hawaii',        93306, 5317297466),
(163428597, 'Eddy Munday',            'Fair Way',           'Montgomery',      'Maine',         11418, 7264904065),
(987123654, 'Glynis Turley',          'Chapel Lane',        'Cleveland',       'Wisconsin',     11438, 5971508328),
(753914826, 'Carmen Shugart',         'Windmill Lane',      'Milwaukee',       'Wyoming',       60004, 7294249217),
(246853179, 'Cherry Penna',           'Noble Avenue',       'Honolulu',        'New York',      53066, 8054257159),
(753214689, 'Monroe Mcnichols',       'Victory Street',     'Norfolk',         'Vermont',       19454, 1582961836),
(764312598, 'Refugio Hoggan',         'Cave Route',         'North Hempstead', 'Ohio',          30134, 3897285420),
(946578132, 'Mary Switzer',           'Oceanview Route',    'Jersey City',     'Delaware',      71060, 8154971639),
(315624978, 'Hester Plourde',         'Bay Street',         'Denver',          'Texas',         71024, 7361857453),
(321698621, 'Marry Monroe',           'Victory Street',     'Roseville',       'California',    95764, 9164235981),
(521987217, 'Jeff Hoggan',            'Cave Route',         'Roseville',       'California',    95764, 9165348796),
(676216579, 'Hulk Hoggan',            'Oceanview Route',    'Sunrise',         'California',    95689, 9164596328),
(731579642, 'Chester McMan',          'Bay Street',         'Sunrise',         'California',    95689, 9168791235);
SELECT * FROM CUSTOMER;

INSERT INTO POLICY(PolicyNo, Policy_Rate, Policy_Details)
VALUES
/*********************************************************
 Policy   Rate     Details                              */
(3219687, 10.50,  "Insurance for the sake of insurance."),
(5219879, 1.99,   "Good luck..."                        ),
(5462197, 654.23, "This better cover everything."       ),
(5687621, 78.12,  "We got you covered!"                 ),
(6519874, 65.12,  "Will save you in time of need"       ),
(6784503, 777.07, "You're lucky you can afford this."   ),
(7531264, 99.99,  "Will cover 99.99% of damages"        ),
(7846206, 420.05, "Blazing insurance!"                  ),
(8976235, 411.64, "Batteries not included."             ),
(0000012, 90.00,  "You'd best be avoiding this policy." ),
(9846251, 100.99, "Head injury covered!"                );
SELECT * FROM POLICY;

INSERT INTO CAR(License, Model, Year, PolicyNo_Ref)
VALUES
/***********************************************************
  License            Model                   Year  Policy */
('2A9291758153786', 'Honda Accord',          2004, 9846251),
('2365984K6917018', 'Honda Odyssey',         2016, 7846206),
('1276406J5769096', 'Chevrolet Camaro',      2015, 6519874),
('671963LH8156012', 'Toyota Camry',          2013, 6519874),
('15350570Q650541', 'Kia Optima',            2003, 9846251),
('91769Z81G830625', 'Honda Accord',          2004, 6784503),
('17212490947B686', 'Toyota Prius',          2013, 6784503),
('4182X4R03F9E045', 'Chevrolet Corvette',    2006, 5687621),
('670396902356824', 'Tesla',                 2015, 7531264),
('247C1E3176D7521', 'Chevrolet Impala',      2013, 9846251),
('848V27W97T15180', 'Honda Accord',          2004, 7531264),
('5675RB9C471S937', 'Volkswagen Golf',       1998, 7531264),
('58962N1E97R463X', 'Toyota Prius',          2013, 5219879),
('861T981M2907A03', 'Toyota Highlander',     2010, 7531264),
('3972696I5272480', 'Hyundai Sonata',        2011, 9846251),
('865358946050EP5', 'Yotoya Speed',          2020, 8976235),
('90Y52U08H5O0581', 'Honda Accord',          2004, 8976235),
('984621D6GW50687', 'Mustang',               2016, 5462197),
('705264329328606', 'Accura',                2007, 8976235),
('938IGF9823Q4689', 'Honda Civic',           2008, 8976235),
('987463206E46258', 'Subaru Impreza',        2016, 3219687),
('09D462049651687', 'Toyota Corolla',        2012, 9846251),
('63S5P4A87I52168', 'Honda Accord',          2004, 3219687),
('8282105F6423026', 'Porsche',               2010, 3219687),
('632A4987O169876', 'Mercedes-Benz E-Class', 2014, 9846251);
SELECT * FROM CAR;

INSERT INTO OWNS(SSN, License)
VALUES
/*****************************
 SSN         License        */
(734629815, '2A9291758153786'),
(764892315, '2365984K6917018'),
(789456123, '1276406J5769096'),
(123456789, '671963LH8156012'),
(987654321, '15350570Q650541'),
(147258369, '91769Z81G830625'),
(963852741, '17212490947B686'),
(852963147, '4182X4R03F9E045'),
(624589317, '670396902356824'),
(432156987, '247C1E3176D7521'),
(195378624, '848V27W97T15180'),
(156324789, '5675RB9C471S937'),
(675489312, '58962N1E97R463X'),
(163428597, '861T981M2907A03'),
(987123654, '3972696I5272480'),
(753914826, '865358946050EP5'),
(246853179, '90Y52U08H5O0581'),
(753214689, '984621D6GW50687'),
(753214689, '09D462049651687'),
(764312598, '705264329328606'),
(764312598, '63S5P4A87I52168'),
(946578132, '8282105F6423026'),
(946578132, '938IGF9823Q4689'),
(315624978, '987463206E46258'),
(315624978, '632A4987O169876');
SELECT * FROM OWNS;

INSERT INTO ACCIDENT(Accident_no, Driver_Name, Accident_Date, Amount_of_Damage, Accident_Details)
VALUES
/*******************************************************************************************************************************
 Accident Driver_Name           yyyy-mm-dd                             Damage   Details                                       */ 
(9846219, 'Taylor Andrews',     STR_TO_DATE('2006-09-12', '%Y-%m-%d'), 10.10,  'Rear bump.'                                   ),
(2169846, 'Myong Nevers',       STR_TO_DATE('2008-07-25', '%Y-%m-%d'), 94.12,  'Smashed from the side.'                       ),
(9876216, 'Vernell Frisina',    STR_TO_DATE('2016-05-16', '%Y-%m-%d'), 77.81,  'Hit a love interest. She was hitting on them.'),
(9386216, 'Julienne Alexandra', STR_TO_DATE('2011-03-10', '%Y-%m-%d'), 41.44,  'Hit a pole.'                                  ),
(9851657, 'Jene Halladay',      STR_TO_DATE('2010-06-13', '%Y-%m-%d'), 26.81,  'Hit park bench while parking.'                ),
(3219687, 'Minerva Pellegrini', STR_TO_DATE('2001-04-17', '%Y-%m-%d'), 84.09,  'Crashed while backing up.'                    ),
(3498765, 'Rosaria Hartline',   STR_TO_DATE('2013-08-24', '%Y-%m-%d'), 0.01,   'Ran over a bug. Sentenced to death penalty.'  ),
(9651687, 'Glynis Turley',      STR_TO_DATE('2014-02-28', '%Y-%m-%d'), 87.41,  'Ran over a deer. Car totaled.'                ),
(9846216, 'Cherry Penna',       STR_TO_DATE('2010-08-07', '%Y-%m-%d'), 29.23,  'Side bump. Back door broken.'                 ),
(3216587, 'Refugio Hoggan',     STR_TO_DATE('2007-01-30', '%Y-%m-%d'), 51.83,  'Crashed into other car at 50mph.'             ),
(4987951, 'Hester Plourde',     STR_TO_DATE('2004-12-05', '%Y-%m-%d'), 100.00, 'Car totaled.'                                 ),
(3987974, 'Hester Plourde',     STR_TO_DATE('2002-08-04', '%Y-%m-%d'), 89.95,  'Car almost totaled.'                          ),
(1648975, 'Hester Plourde',     STR_TO_DATE('2008-09-03', '%Y-%m-%d'), 43.69,  'Car slightly totaled.'                        ),
(8762137, 'Jeff Hoggan',        STR_TO_DATE('2001-05-07', '%Y-%m-%d'), 56.50,  'Killed the guy.'                              ),
(2645789, 'Jeff Hoggan',        STR_TO_DATE('2006-06-09', '%Y-%m-%d'), 56.50,  'Almost killed the guy.'                       ),
(9846547, 'Jeff Hoggan',        STR_TO_DATE('2007-08-03', '%Y-%m-%d'), 56.50,  'Did not kill the guy.'                      ),
(6218759, 'Marry Monroe',       STR_TO_DATE('2012-11-12', '%Y-%m-%d'), 09.50, 'Is this how Marry Monroe felt?'                      ),
(6324979, 'Chester McMan',      STR_TO_DATE('2001-11-27', '%Y-%m-%d'), 59.87,  'Injury induced.'                              ),
(7523941, 'Chester McMan',      STR_TO_DATE('2001-11-27', '%Y-%m-%d'), 59.87,  'Some Injury induced.'                         ),
(1324579, 'Savanah Paige',      STR_TO_DATE('2000-10-21', '%Y-%m-%d'), 59.87,  'No injury induced.'                           );
SELECT * FROM ACCIDENT;

INSERT INTO HAD(License, AccidentNo)
VALUES
/******************************
 License            Accident */
('2A9291758153786', 9846219),
('1276406J5769096', 2169846),
('15350570Q650541', 9876216),
('17212490947B686', 9386216),
('670396902356824', 9851657),
('848V27W97T15180', 3219687),
('58962N1E97R463X', 3498765),
('3972696I5272480', 9651687),
('90Y52U08H5O0581', 9846216),
('09D462049651687', 3216587),
('63S5P4A87I52168', 4987951),
('63S5P4A87I52168', 3987974),
('63S5P4A87I52168', 1648975),
('938IGF9823Q4689', 8762137),
('938IGF9823Q4689', 2645789),
('938IGF9823Q4689', 9846547),
('938IGF9823Q4689', 6218759),
('632A4987O169876', 6324979),
('671963LH8156012', 7523941),
('2365984K6917018', 1324579);
SELECT * FROM HAD;
