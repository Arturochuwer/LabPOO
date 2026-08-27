package aereo;

import componentes.IVolar;
import vehiculos.Vehiculo;

public class Avion extends Vehiculo implements IVolar {
	private int numMotores;
	private double altitudMaxima;

	public Avion(String marca, String modelo, int anio, double velocidadMax,
				 int numMotores, double altitudMaxima) {
		super(marca, modelo, anio, velocidadMax);
		this.numMotores = numMotores;
		setAltitudMaxima(altitudMaxima);
	}

	public int getNumMotores() {
		return numMotores;
	}

	public void setNumMotores(int numMotores) {
		this.numMotores = numMotores;
	}

	public double getAltitudMaxima() {
		return altitudMaxima;
	}

	public void setAltitudMaxima(double altitudMaxima) {
		if (altitudMaxima < 0) {
			throw new IllegalArgumentException("La altitud maxima no puede ser negativa");
		}
		this.altitudMaxima = altitudMaxima;
	}

	@Override
	public String Volar() {
		return "El avion esta volando";
	}

	@Override
	public String toString() {
		return "Avion{" +
				"vehiculo=" + super.toString() +
				", numMotores=" + numMotores +
				", altitudMaxima=" + altitudMaxima +
				'}';
	}
}
