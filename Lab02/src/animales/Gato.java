package animales;

public class Gato extends Animal {
	private String color;
	private boolean esInterior;

	public Gato(String nombre, int edad, double peso, String color, boolean esInterior) {
		super(nombre, edad, peso);
		this.color = color;
		this.esInterior = esInterior;
	}

	public void maullar() {
		System.out.println(getNombre() + " dice: ¡Miau!");
	}

	public void arañar() {
		System.out.println(getNombre() + " está arañando.");
	}

    public String getInterior() {
        return esInterior ? "Sí" : "No";
    }

	@Override
	public String toString() {
		return super.toString() +
				" | Color: " + color +
				" | Interior: " + getInterior();
	}
}