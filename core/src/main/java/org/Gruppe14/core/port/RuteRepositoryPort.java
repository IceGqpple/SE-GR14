package org.Gruppe14.core.port;

import org.Gruppe14.core.exception.RuteRepositoryException;
import org.Gruppe14.core.model.Rute;

import java.util.List;

public interface RuteRepositoryPort {
    void lagreRute(String rute) throws RuteRepositoryException;
    List<Rute> findAll() throws RuteRepositoryException;
    Rute findById(int id) throws RuteRepositoryException;
    List<Rute> finnRuterMedStoppSted(String stoppSted) throws RuteRepositoryException;
}
