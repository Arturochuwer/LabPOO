package animales;

public class Perro extends Animal {
	private String raza;
	private boolean estaVacunado;

	public Perro(String nombre, int edad, double peso, String raza, boolean estaVacunado) {
		// Si se quitara super(), Java intentaría llamar automáticamente a super()
		// sin argumentos, pero Animal no tiene un constructor vacío y la compilación fallaría.
		super(nombre, edad, peso);
		this.raza = raza;
		this.estaVacunado = estaVacunado;
	}

	public void ladrar() {
		System.out.println(getNombre() + " dice: ¡Guau guau!");
	}

	public void buscarPelota() {
		System.out.println(getNombre() + " está buscando la pelota...");
	}

    public String getVacunado() {
        return estaVacunado ? "Sí" : "No";
    }

	@Override
	public String toString() {
		return super.toString() +
				" | Raza: " + raza +
				" | Vacunado: " + getVacunado();
	}
}
