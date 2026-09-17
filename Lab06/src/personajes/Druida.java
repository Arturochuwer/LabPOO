package personajes;

import skills.Hechicero;
import skills.Sanador;

public class Druida extends Personaje implements Hechicero, Sanador {

	private int mana;
	private int poderCuracion;
	private String formaNatural;

	public Druida(String nombre, int nivel, int puntosVida, int mana,
			int poderCuracion, String formaNatural) {
		super(nombre, nivel, puntosVida);
		this.mana = mana;
		this.poderCuracion = poderCuracion;
		this.formaNatural = formaNatural;
	}

	@Override
	public void atacar() {
		System.out.println("El druida " + getNombre()
				+ " ataca con las fuerzas de la naturaleza en forma de " + formaNatural);
	}

	@Override
	public int calcularDanio() {
		return mana + nivel;
	}

	@Override
	public void lanzarHechizo() {
		System.out.println("El druida " + getNombre()
				+ " lanza un hechizo de naturaleza");
	}

	@Override
	public int getMana() {
		return mana;
	}

	@Override
	public void curarAliado(Personaje aliado) {
		aliado.puntosVida += poderCuracion;
		aliado.estaVivo = true;
		System.out.println("El druida " + getNombre() + " cura a "
				+ aliado.getNombre() + " por " + poderCuracion
				+ ". Vida: " + aliado.puntosVida);
	}

	@Override
	public int getPoderCuracion() {
		return poderCuracion;
	}
}
