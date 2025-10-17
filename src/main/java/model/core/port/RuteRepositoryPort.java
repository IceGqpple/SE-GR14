package model.core.port;

import model.core.exception.RuteRepositoryException;
import model.core.model.Rute;

import java.util.List;

public interface RuteRepositoryPort {
    void lagreRute(String rute) throws RuteRepositoryException;
    List<Rute> findAll() throws RuteRepositoryException;
    Rute findById(int id) throws RuteRepositoryException;
    List<Rute> finnRuterMedStoppSted(String stoppSted) throws RuteRepositoryException;
}
