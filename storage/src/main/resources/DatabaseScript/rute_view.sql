USE se;
DROP VIEW rute_view;
CREATE VIEW rute_view AS
select r.rute_navn, r.rute_id, sr.rekkefolge, s.stoppested_id, s.sted_navn
From rute r 
Join stoppested_has_rute sr on r.rute_id = sr.rute_id
Join stoppested s on sr.stoppested_id = s.stoppested_id
ORDER BY r.rute_navn, sr.rekkefolge
