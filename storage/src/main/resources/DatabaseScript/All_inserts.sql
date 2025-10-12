USE se; 
INSERT INTO kjoretoy(kjoretoy_navn, kjoretoy_id) VALUES
("Tog", 1),
("Buss", 2);

INSERT INTO Rute (rute_navn, kjoretoy_id) VALUES
('Moss-Halden', 1),
('Halden-Moss', 1),
('Moss-Sarpsborg-Halden', 2),
('Halden-Sarpsborg-Moss', 2),
('Moss-Fredrikstad-Halden', 2),
('Halden-Fredrikstad-Moss', 2),
('Sarpsborg-Fredrikstad', 2),
('Fredrikstad-Sarpsborg', 2),
('Sarpsborg-Rakkestad', 2),
('Rakkestad-Sarpsborg', 2),
('Halden-Kornsjø', 2),
('Kornsjø-Halden', 2);

INSERT INTO stoppested (stedNavn) VALUES
('Moss'),
('Halden'),
('Sarpsborg'),
('Fredrikstad'),
('Rakkestad'),
('Kornsjø'),
('Rygge'),
('Remmen'),
('Greåker'),
('Østfoldhallen'),
('Borgenhaugen'),
('Rudsskogen'),
('Festningen'),
('Prestebakke'),
('Råde'),
('Svinesundparken'),
('Saltnes'),
('Ise'),
('Solli'),
('Viksletta'),
('Gressvik'),
('Kalnes'),
('Skjeberg'),
('Sandbakken'),
('Begby'),
('Skjærviken');


