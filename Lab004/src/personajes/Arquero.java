package personajes;

public class Arquero extends Personaje {
	private String tipoArco;
	private int flechasDisponibles;

	public Arquero(String nombre, int nivel, int puntosVida, boolean estaVivo, String tipoArco,
			int flechasDisponibles) {
		super(nombre, nivel, puntosVida, estaVivo);
		this.tipoArco = tipoArco;
		this.flechasDisponibles = flechasDisponibles;
	}

	public String getTipoArco() {
		return tipoArco;
	}

	public int getFlechasDisponibles() {
		return flechasDisponibles;
	}

	@Override
	public void atacar() {
		System.out.println("El arquero " + getNombre() + " dispara flechas a distancia con un " + tipoArco);
	}

	@Override
	public String defender() {
		return "El arquero " + getNombre() + " esquiva el ataque y se repliega";
	}

	@Override
	public String toString() {
		return "Arquero{" +
				"personaje=" + super.toString() +
				", tipoArco='" + tipoArco + '\'' +
				", flechasDisponibles=" + flechasDisponibles +
				'}';
	}

}
