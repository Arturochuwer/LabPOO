import animales.Canario;
import animales.Gato;
import animales.Perro;

public class Main {
    public static void main(String[] args) throws Exception {
        Perro perro = new Perro("Max", 4, 18.5, "Labrador", true);
        Gato gato = new Gato("Luna", 2, 4.2, "Gris", true);
        Canario canario = new Canario("Piolin", 1, 0.03, "Amarillo", true);

        System.out.println("=== Clínica Veterinaria ===");

        System.out.println("\n-- Perro --");
        System.out.println(perro.toString());
        perro.comer();
        perro.ladrar();
        perro.buscarPelota();

        System.out.println("\n-- Gato --");
        System.out.println(gato.toString());
        gato.dormir();
        gato.maullar();
        gato.arañar();

        System.out.println("\n-- Canario --");
        System.out.println(canario.toString());
        canario.cantar();
        canario.volar();
        canario.comer();
    }
}
