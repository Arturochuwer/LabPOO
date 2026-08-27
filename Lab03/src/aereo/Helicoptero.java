package aereo;

import vehiculos.Vehiculo;
import componentes.IVolar;

public class Helicoptero extends Vehiculo implements IVolar {
    private int numHelices;
    private double altitudMaxima;

    public Helicoptero(String marca, String modelo, int anio, double velocidadMax,
                       int numHelices, double altitudMaxima) {
        super(marca, modelo, anio, velocidadMax);
        this.numHelices = numHelices;
        setAltitudMaxima(altitudMaxima);
    }

    public int getNumHelices() {
        return numHelices;
    }

    public void setNumHelices(int numHelices) {
        this.numHelices = numHelices;
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
        return "El helicoptero esta volando";
    }

    @Override
    public String toString() {
        return "Helicoptero{" +
                "vehiculo=" + super.toString() +
                ", numHelices=" + numHelices +
                ", altitudMaxima=" + altitudMaxima +
                '}';
    }
 
}
