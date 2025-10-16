package org.Gruppe14.core.port;

import org.Gruppe14.core.exception.BrukerRepositoryException;
import org.Gruppe14.core.model.User;

import java.util.List;

public interface BrukerRepositoryPort {
    void lagreUser(User bruker) throws BrukerRepositoryException;
    List<User> finnByNavn(String navn) throws BrukerRepositoryException;
}
