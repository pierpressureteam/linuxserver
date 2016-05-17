use pier_pressure_database;


INSERT INTO shiptype (typename,typebignaam,shiplength,shipwith,shipdepth,capacity,weight) VALUES ("I","Spits",38.5,5.05,2.20,350.0,NULL);
INSERT INTO shiptype (typename,typebignaam,shiplength,shipwith,shipdepth,capacity,weight) VALUES ("II","Kempenaar",55.0,6.6,2.59,655.0,NULL);
INSERT INTO shiptype (typename,typebignaam,shiplength,shipwith,shipdepth,capacity,weight) VALUES ("III","Neokemp",63.0,7.0,2.5,840.0,NULL);
INSERT INTO shiptype (typename,typebignaam,shiplength,shipwith,shipdepth,capacity,weight) VALUES ("III+","Dortmunder",67.0,8.20,2.50,1000.0,NULL);
INSERT INTO shiptype (typename,typebignaam,shiplength,shipwith,shipdepth,capacity,weight) VALUES ("IV","Europaschip",85.0,9.50,3.0,1500.0,NULL);
INSERT INTO shiptype (typename,typebignaam,shiplength,shipwith,shipdepth,capacity,weight) VALUES ("IV+","Verlengd Europaschip",105,9.50,3.00,2150.0,NULL);
INSERT INTO shiptype (typename,typebignaam,shiplength,shipwith,shipdepth,capacity,weight) VALUES ("VA","Groot Rijnschip",110.0,11.40,3.00,2750.0,NULL);
INSERT INTO shiptype (typename,typebignaam,shiplength,shipwith,shipdepth,capacity,weight) VALUES ("VA+","Verlengd Groot Rijnschip",135.0,11.40,3.20,3250.0,NULL);
INSERT INTO shiptype (typename,typebignaam,shiplength,shipwith,shipdepth,capacity,weight) VALUES ("VB","Groot containerschip",135.0,14,3.5,3850.0,NULL);
INSERT INTO shiptype (typename,typebignaam,shiplength,shipwith,shipdepth,capacity,weight) VALUES ("VB+","Tweebaksduwstel",172.0,11.40,4.0,5500.0,NULL);
INSERT INTO shiptype (typename,typebignaam,shiplength,shipwith,shipdepth,capacity,weight) VALUES ("VIb","Vierbaksduwstel",193.0,22.80,4.0,11000.0,NULL);
INSERT INTO shiptype (typename,typebignaam,shiplength,shipwith,shipdepth,capacity,weight) VALUES ("VIc","Zesbaksduwstel",193.0,34.20,4,16500.0,NULL);

INSERT INTO usersaccount (username,password,email,activated) VALUES ("admin","admin","admin@admin.nl",TRUE);

INSERT INTO ships (mmsi,shiptype_typename,shipname) VALUES (244660136,"IV","Primo");
INSERT INTO ships (mmsi,shiptype_typename,shipname) VALUES (244660134,"IV","Aldeano");
INSERT INTO ships (mmsi,shiptype_typename,shipname) VALUES (244750773,"IV","Maria-Helena");

INSERT INTO usersaccount_has_ships (usersaccount_username,ships_mmsi) VALUES ("admin",244660136);
INSERT INTO usersaccount_has_ships (usersaccount_username,ships_mmsi) VALUES ("admin",244660134);
INSERT INTO usersaccount_has_ships (usersaccount_username,ships_mmsi) VALUES ("admin",244750773);
