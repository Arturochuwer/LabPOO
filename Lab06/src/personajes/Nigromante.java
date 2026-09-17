package personajes;

import skills.Hechicero;

public class Nigromante extends Personaje implements Hechicero {

	private int mana;
	private int almasAbsorbidas;
	private int nivelOscuridad;

	public Nigromante(String nombre, int nivel, int puntosVida, int mana,
			int almasAbsorbidas) {
		this(nombre, nivel, puntosVida, mana, almasAbsorbidas, 1);
	}

	public Nigromante(String nombre, int nivel, int puntosVida, int mana,
			int almasAbsorbidas, int nivelOscuridad) {
		super(nombre, nivel, puntosVida);
		this.mana = mana;
		this.almasAbsorbidas = almasAbsorbidas;
		this.nivelOscuridad = nivelOscuridad;
	}

	@Override
	public void atacar() {
		System.out.println("El nigromante " + getNombre()
				+ " drena vida e invoca a los no-muertos");
	}

	@Override
	public int calcularDanio() {
		return (nivel * nivelOscuridad) + almasAbsorbidas;
	}

	@Override
	public void lanzarHechizo() {
		System.out.println("El nigromante " + getNombre()
				+ " lanza una maldición oscura");
	}

	@Override
	public int getMana() {
		return mana;
	}
}
