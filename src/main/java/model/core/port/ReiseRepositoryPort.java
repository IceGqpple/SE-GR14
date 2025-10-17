package model.core.port;


import model.core.exception.ReiseRepositoryException;
import model.core.model.Reise;

import java.util.List;

public interface ReiseRepositoryPort {
    void saveReise (Reise reise) throws ReiseRepositoryException;// lager ny reise
    List<Reise> hentAllReiser() throws ReiseRepositoryException; // henter alle reiser
    List<Reise> finnReiserMedRute() throws ReiseRepositoryException; // finn flere rieser mellom to steder
}
