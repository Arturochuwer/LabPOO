import java.util.Scanner;

import aereo.Avion;
import aereo.Helicoptero;
import maritimos.Barco;
import terrestre.Automovil;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Sistema de Transporte Multimodal ===");

        System.out.println("\n-- Automovil --");
        String marcaAutomovil = leerTexto(scanner, "Marca: ");
        String modeloAutomovil = leerTexto(scanner, "Modelo: ");
        int anioAutomovil = leerEntero(scanner, "Anio: ");
        double velocidadAutomovil = leerDecimal(scanner, "Velocidad maxima: ");
        int numPuertas = leerEntero(scanner, "Numero de puertas: ");
        boolean esElectrico = leerBooleano(scanner, "Es electrico (si/no): ");
        Automovil automovil = new Automovil(marcaAutomovil, modeloAutomovil, anioAutomovil,
                velocidadAutomovil, numPuertas, esElectrico);
        System.out.println(automovil.toString());

        System.out.println("\n-- Avion --");
        String marcaAvion = leerTexto(scanner, "Marca: ");
        String modeloAvion = leerTexto(scanner, "Modelo: ");
        int anioAvion = leerEntero(scanner, "Anio: ");
        double velocidadAvion = leerDecimal(scanner, "Velocidad maxima: ");
        int numMotores = leerEntero(scanner, "Numero de motores: ");
        double altitudAvion = leerDecimal(scanner, "Altitud maxima: ");
        Avion avion = new Avion(marcaAvion, modeloAvion, anioAvion, velocidadAvion,
                numMotores, altitudAvion);
        System.out.println(avion.toString());

        System.out.println("\n-- Helicoptero --");
        String marcaHelicoptero = leerTexto(scanner, "Marca: ");
        String modeloHelicoptero = leerTexto(scanner, "Modelo: ");
        int anioHelicoptero = leerEntero(scanner, "Anio: ");
        double velocidadHelicoptero = leerDecimal(scanner, "Velocidad maxima: ");
        int numHelices = leerEntero(scanner, "Numero de helices: ");
        double altitudHelicoptero = leerDecimal(scanner, "Altitud maxima: ");
        Helicoptero helicoptero = new Helicoptero(marcaHelicoptero, modeloHelicoptero,
                anioHelicoptero, velocidadHelicoptero, numHelices, altitudHelicoptero);
        System.out.println(helicoptero.toString());

        System.out.println("\n-- Barco --");
        String marcaBarco = leerTexto(scanner, "Marca: ");
        String modeloBarco = leerTexto(scanner, "Modelo: ");
        int anioBarco = leerEntero(scanner, "Anio: ");
        double velocidadBarco = leerDecimal(scanner, "Velocidad maxima: ");
        String tipoCasco = leerTexto(scanner, "Tipo de casco: ");
        double tonelajeMaximo = leerDecimal(scanner, "Tonelaje maximo: ");
        Barco barco = new Barco(marcaBarco, modeloBarco, anioBarco, velocidadBarco,
                tipoCasco, tonelajeMaximo);
        System.out.println(barco.toString());

        scanner.close();
    }

    private static String leerTexto(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine();
    }

    private static int leerEntero(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return Integer.parseInt(scanner.nextLine());
    }

    private static double leerDecimal(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return Double.parseDouble(scanner.nextLine());
    }

    private static boolean leerBooleano(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return scanner.nextLine().equalsIgnoreCase("si");
    }
}
