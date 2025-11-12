package port;

import domain.StoppeSted;
import exeption.RuteException;

import java.util.ArrayList;

public interface StoppeStedPort {
    ArrayList<StoppeSted> hentAlleStoppeSteder() throws RuteException;
}
