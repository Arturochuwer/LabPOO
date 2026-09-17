package personajes;

import skills.Hechicero;

public class Mago extends Personaje implements Hechicero {
	private int mana;
	private String escuelaMagia;

	public Mago(String nombre, int nivel, int puntosVida, boolean estaVivo, int mana, String escuelaMagia) {
		super(nombre, nivel, puntosVida);
		this.estaVivo = estaVivo;
		this.mana = mana;
		this.escuelaMagia = escuelaMagia;
	}

	public Mago(String nombre, int nivel, int puntosVida, int mana, String escuelaMagia) {
		this(nombre, nivel, puntosVida, true, mana, escuelaMagia);
	}

	public int getMana() {
		return mana;
	}

	public String getEscuelaMagia() {
		return escuelaMagia;
	}

	@Override
	public void atacar() {
		System.out.println("El mago " + getNombre() + " está lanzando un hechizo de la escuela " + escuelaMagia);
	}

	@Override
	public void lanzarHechizo() {
		System.out.println("El mago " + getNombre() + " lanza un hechizo de la escuela " + escuelaMagia);
	}

	@Override
	public int calcularDanio() {
		return mana * getNivel();
	}

	public String defender() {
		return "El mago " + getNombre() + " está usando un escudo mágico";
	}

	@Override
	public String toString() {
		return "Mago{" +
				"personaje=" + super.toString() +
				", mana=" + mana +
				", escuelaMagia='" + escuelaMagia + '\'' +
				'}';
	}

}
