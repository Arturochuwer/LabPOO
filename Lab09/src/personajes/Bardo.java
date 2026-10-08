package personajes;

import skills.Sanador;

public class Bardo extends Personaje implements Sanador {

	private int poderCuracion;
	private String instrumento;
	private int carisma;

	public Bardo(String nombre, int nivel, int puntosVida, int poderCuracion,
			String instrumento) {
		this(nombre, nivel, puntosVida, poderCuracion, instrumento, 5);
	}

	public Bardo(String nombre, int nivel, int puntosVida, int poderCuracion,
			String instrumento, int carisma) {
		super(nombre, nivel, puntosVida);
		this.poderCuracion = poderCuracion;
		this.instrumento = instrumento;
		this.carisma = carisma;
	}

	@Override
	public void atacar() {
		System.out.println("El bardo " + getNombre()
				+ " aturde con su música y usa el " + instrumento + " como arma");
	}

	@Override
	public int calcularDanio() {
		return carisma + nivel;
	}

	@Override
	public void curarAliado(Personaje aliado) {
		aliado.puntosVida += poderCuracion;
		aliado.estaVivo = true;
		System.out.println("El bardo " + getNombre() + " toca una melodía curativa para "
				+ aliado.getNombre() + ". Vida: " + aliado.puntosVida);
	}

	@Override
	public int getPoderCuracion() {
		return poderCuracion;
	}
}
