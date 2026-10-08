package skills;

import personajes.Personaje;
import personajes.RpgException;

public interface Sanador {
    void curarAliado(Personaje aliado) throws RpgException;
    int getPoderCuracion();
}
