package personajes;

public class Mago extends Personaje {
	private int mana;
	private String escuelaMagia;

	public Mago(String nombre, int nivel, int puntosVida, boolean estaVivo, int mana, String escuelaMagia) {
		super(nombre, nivel, puntosVida, estaVivo);
		this.mana = mana;
		this.escuelaMagia = escuelaMagia;
	}

	public int getMana() {
		return mana;
	}

	public String getEscuelaMagia() {
		return escuelaMagia;
	}

	@Override
	public void atacar() {
		super.atacar();
		System.out.println("El mago " + getNombre() + " está lanzando un hechizo de la escuela " + escuelaMagia);
	}

	@Override
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
