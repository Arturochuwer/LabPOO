package personajes;
import skills.ICombatiente;

public class Personaje implements ICombatiente {
    private String nombre;
    private int nivel;
    private int puntosVida;
    private boolean estaVivo;

    public Personaje(String nombre, int nivel, int puntosVida, boolean estaVivo) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntosVida = puntosVida;
        this.estaVivo = estaVivo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public int getPuntosVida() {
        return puntosVida;
    }

    public boolean isEstaVivo() {
        return estaVivo;
    }

    public void recibirDanio(int danio) {
        puntosVida -= danio;

        if (puntosVida <= 0) {
            puntosVida = 0;
            estaVivo = false;
        }

        System.out.println(nombre + " recibe " + danio + " puntos de daño. Vida restante: " + puntosVida);

        if (!estaVivo) {
            System.out.println(nombre + " ha sido derrotado.");
        }
    }

    @Override
    public void atacar() {
        System.out.println("El personaje " + nombre + " está atacando con nivel " + nivel);
    }

    public int calcularDanio() {
        return getNivel() * 10;
    }

    public void mostrarEstado() {
        System.out.println(nombre + " - nivel " + nivel + ", vida: " + puntosVida);
    }

    public void mostrarEstado(boolean detallado) {
        if (detallado) {
            System.out.println(toString());
        } else {
            mostrarEstado();
        }
    }

    public void mostrarEstado(String prefijo) {
        System.out.println(prefijo + ": " + toString());
    }

    @Override
    public String defender() {
        return "El personaje " + nombre + " está defendiendo con nivel " + nivel;
    }

    public String toString() {
        return "Personaje{" +
                "nombre='" + nombre + '\'' +
                ", nivel=" + nivel +
                ", puntosVida=" + puntosVida +
                ", estaVivo=" + estaVivo +
                '}';
    }
}
