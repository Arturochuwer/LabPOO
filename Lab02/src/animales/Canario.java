package animales;

public class Canario extends Animal {
	private String colorPlumaje;
	private boolean cantaEnJaula;

	public Canario(String nombre, int edad, double peso, String colorPlumaje, boolean cantaEnJaula) {
		super(nombre, edad, peso);
		this.colorPlumaje = colorPlumaje;
		this.cantaEnJaula = cantaEnJaula;
	}

	public void cantar() {
		System.out.println(getNombre() + " está cantando.");
	}

	public void volar() {
		System.out.println(getNombre() + " está volando.");
	}

    public String getCantaEnJaula() {
        return cantaEnJaula ? "Sí" : "No";
    }

	@Override
	public String toString() {
		return super.toString() +
				" | Plumaje: " + colorPlumaje +
				" | Canta en jaula: " + getCantaEnJaula();
	}
}