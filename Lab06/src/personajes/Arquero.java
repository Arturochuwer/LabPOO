package personajes;

public class Arquero extends Personaje {
	private String tipoArco;
	private int flechasDisponibles;
	private int precision;

	public Arquero(String nombre, int nivel, int puntosVida, boolean estaVivo, String tipoArco,
			int flechasDisponibles) {
		super(nombre, nivel, puntosVida);
		this.estaVivo = estaVivo;
		this.tipoArco = tipoArco;
		this.flechasDisponibles = flechasDisponibles;
		this.precision = 10;
	}

	public Arquero(String nombre, int nivel, int puntosVida, String tipoArco,
			int flechasDisponibles, int precision) {
		this(nombre, nivel, puntosVida, true, tipoArco, flechasDisponibles);
		this.precision = precision;
	}

	public String getTipoArco() {
		return tipoArco;
	}

	public int getFlechasDisponibles() {
		return flechasDisponibles;
	}

	public int getPrecision() {
		return precision;
	}

	@Override
	public void atacar() {
		System.out.println("El arquero " + getNombre() + " dispara flechas a distancia con un " + tipoArco);
	}

	@Override
	public int calcularDanio() {
		return precision * flechasDisponibles;
	}

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
