package port;

import domain.Rute;
import exeption.RuteException;

import java.util.ArrayList;

public interface RuterPort {
    ArrayList<Rute> hentAlleRuter() throws RuteException;
}

