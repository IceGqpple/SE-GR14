package model.core.port;



import model.core.exception.BrukerRepositoryException;
import model.core.model.User;

import java.util.List;

public interface BrukerRepositoryPort {
    void lagreUser(User bruker) throws BrukerRepositoryException;
    List<User> finnByNavn(String navn) throws BrukerRepositoryException;
}
