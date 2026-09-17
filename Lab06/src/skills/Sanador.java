package skills;

import personajes.Personaje;

public interface Sanador {
    void curarAliado(Personaje aliado);
    int getPoderCuracion();
}
