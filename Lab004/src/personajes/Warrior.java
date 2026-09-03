package personajes;

public class Warrior extends Personaje{
    private int fuerza;
    private int resistencia;
    private String tipoArma;
    private String armadura;

    public String getTipoArma() {
        return tipoArma;
    }

    public String getArmadura() {
        return armadura;
    }

    public Warrior(String nombre, int nivel, int puntosVida, boolean estaVivo, int fuerza, int resistencia) {
        super(nombre, nivel, puntosVida, estaVivo);
        this.fuerza = fuerza;
        this.resistencia = resistencia;
    }

    public Warrior(String nombre, int nivel, int puntosVida, boolean estaVivo, String tipoArma) {
        super(nombre, nivel, puntosVida, estaVivo);
        this.fuerza = 10; // Valor predeterminado para fuerza
        this.resistencia = 5; // Valor predeterminado para resistencia
        this.tipoArma = tipoArma;
    }

    public int getFuerza() {
        return fuerza;
    }

    public int getResistencia() {
        return resistencia;
    }

    @Override
    public void atacar() {
        System.out.println("El guerrero " + getNombre() + " está atacando con fuerza " + fuerza);
    }

    public void atacar(int fuerza, String tipoArma) {
        System.out.println("El guerrero " + getNombre() + " está atacando con fuerza " + fuerza + " y usando un " + tipoArma);
    }

    @Override
    public String defender() {
        return "El guerrero " + getNombre() + " está defendiendo con resistencia " + resistencia;
    }

    @Override
    public String toString() {
        return "Warrior{" +
                "personaje=" + super.toString() +
                ", fuerza=" + fuerza +
                ", resistencia=" + resistencia +
                ", tipoArma='" + tipoArma + '\'' +
                '}';
    }
}
