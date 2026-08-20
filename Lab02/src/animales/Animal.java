package animales;

public class Animal {
	// Se declaran como private para aplicar encapsulamiento: la clase controla el
	// acceso y evita que otras clases modifiquen directamente su estado interno.
	private String nombre;
	private int edad;
	private double peso;

	public Animal(String nombre, int edad, double peso) {
		this.nombre = nombre;
		this.edad = edad;
		this.peso = peso;
	}

	public void comer() {
		System.out.println(nombre + " está comiendo.");
	}

	public void dormir() {
		System.out.println(nombre + " está durmiendo.");
	}

	protected String getNombre() {
		return nombre;
	}

    public String getAnios(){
        return edad> 1 ? edad + " años" : edad + " año";
    }

	// Sobrescribir toString() permite que System.out.println() y otras APIs de Java
	// muestren automáticamente una representación legible del objeto, sin llamar
	// manualmente a un método adicional con un nombre personalizado.
	@Override
	public String toString() {
		return "Nombre: " + nombre + 
                " | Edad: " + getAnios() +
				" | Peso: " + peso + " kg";
	}
}
