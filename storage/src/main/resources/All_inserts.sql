USE se; 

INSERT INTO kjoretoy(kjoretoy_navn, kjoretoy_id) VALUES
("Tog", 1),
("Buss", 2);

INSERT INTO rute (rute_id, rute_navn, kjoretoy_id) VALUES
(1,'Moss-Halden (Tog)', 1),
(2,'Halden-Moss (Tog)', 1),
(3,'Moss-Sarpsborg-Halden', 2),
(4,'Halden-Sarpsborg-Moss', 2),
(5,'Moss-Fredrikstad-Halden', 2),
(6,'Halden-Fredrikstad-Moss', 2),
(7,'Sarpsborg-Fredrikstad', 2),
(8,'Fredrikstad-Sarpsborg', 2),
(9,'Sarpsborg-Rakkestad', 2),
(10,'Rakkestad-Sarpsborg', 2),
(11,'Halden-Kornsjø', 2),
(12,'Kornsjø-Halden', 2);


INSERT INTO stoppested (stoppested_id, sted_navn) VALUES
(1,'Moss'),
(2,'Halden'),
(3,'Sarpsborg'),
(4,'Fredrikstad'),
(5,'Rakkestad'),
(6,'Kornsjø'),
(7,'Rygge'),
(8,'Remmen'),
(9,'Greåker'),
(10,'Østfoldhallen'),
(11,'Borgenhaugen'),
(12,'Rudsskogen'),
(13,'Festningen'),
(14,'Prestebakke'),
(15,'Råde'), 
(16,'Svinesundparken'),
(17,'Saltnes'),
(18,'Ise'),
(19,'Solli'),
(20,'Viksletta'),
(21,'Gressvik'),
(22,'Kalnes'),
(23,'Skjeberg'),
(24,'Sandbakken'),
(25,'Begby'),
(26,'Skjærviken');



use se;

INSERT INTO stoppested_has_rute (rute_id, stoppested_id, rekkefolge) VALUES
-- Moss-Halden (Tog)
(1,1,1),
(1,7,2),
(1,15,3),
(1,4,4),
(1,3,5),
(1,9,6),
(1,23,7),
(1,2,8),

-- Halden-Moss (Tog)
(2,2,1),
(2,3,2),
(2,4,3),
(2,15,4),
(2,7,5),
(2,1,6),

-- Moss-Sarpsborg-Halden
(3,1,1),
(3,7,2),
(3,15,3),
(3,19,4),
(3,22,5),
(3,3,6),
(3,11,7),
(3,24,8),
(3,23,9),
(3,20,10),
(3,16,11),
(3,8,12),
(3,2,13),

-- Halden-Sarpsborg-Moss
(4,2,1),
(4,8,2),
(4,16,3),
(4,20,4),
(4,23,5),
(4,24,6),
(4,3,7),
(4,22,8),
(4,19,9),
(4,15,10),
(4,7,11),
(4,1,12),

-- Moss-Fredrikstad-Halden
(5,1,1),
(5,7,2),
(5,17,3),
(5,21,4),
(5,4,5),
(5,25,6),
(5,26,7),
(5,23,8),
(5,20,9),
(5,16,10),
(5,8,11),
(5,2,12),

-- Halden-Fredrikstad-Moss
(6,2,1),
(6,8,2),
(6,16,3),
(6,20,4),
(6,23,5),
(6,26,6),
(6,25,7),
(6,4,8),
(6,21,9),
(6,17,10),
(6,7,11),
(6,1,12),

-- Sarpsborg-Fredrikstad
(7,3,1),
(7,9,2),
(7,10,3),
(7,4,4),

-- Fredrikstad-Sarpsborg
(8,4,1),
(8,10,2),
(8,9,3),
(8,3,4),

-- Sarpsborg-Rakkestad
(9,3,1),
(9,11,2),
(9,18,3),
(9,12,4),
(9,5,5),

-- Rakkestad-Sarpsborg
(10,5,1),
(10,12,2),
(10,18,3),
(10,11,4),
(10,3,5);





