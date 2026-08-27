package maritimos;

import vehiculos.Vehiculo;

public class Barco extends Vehiculo {
	private String tipoCasco;
	private double tonelajeMaximo;

	public Barco(String marca, String modelo, int anio, double velocidadMax,
				 String tipoCasco, double tonelajeMaximo) {
		super(marca, modelo, anio, velocidadMax);
		this.tipoCasco = tipoCasco;
		setTonelajeMaximo(tonelajeMaximo);
	}

	public String getTipoCasco() {
		return tipoCasco;
	}

	public void setTipoCasco(String tipoCasco) {
		this.tipoCasco = tipoCasco;
	}

	public double getTonelajeMaximo() {
		return tonelajeMaximo;
	}

	public void setTonelajeMaximo(double tonelajeMaximo) {
		if (tonelajeMaximo > 0) {
			this.tonelajeMaximo = tonelajeMaximo;
		} else {
			System.out.println("Error: el tonelaje maximo debe ser mayor que 0.");
		}
	}

	@Override
	public String toString() {
		return "Barco{" +
				"vehiculo=" + super.toString() +
				", tipoCasco='" + tipoCasco + '\'' +
				", tonelajeMaximo=" + tonelajeMaximo +
				'}';
	}
}
