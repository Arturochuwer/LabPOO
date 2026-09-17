import personajes.Bardo;
import personajes.Druida;
import personajes.Nigromante;
import personajes.Personaje;
import skills.Hechicero;
import skills.Sanador;

public class App {

    public static void main(String[] args) {
        System.out.println("=== RPG - Expansion: Nuevas Clases ===");
        System.out.println();

        System.out.println("-- Error esperado (linea comentada) --");
        // Personaje personaje = new Personaje("Generico", 1, 100);
        System.out.println("// new Personaje(...) -> no se puede instanciar una clase abstracta");
        System.out.println();

        Druida druida = new Druida("Sylva", 7, 200, 233, 120, "raices");
        Nigromante nigromante = new Nigromante("Malachar", 6, 350, 220, 30, 60);
        Bardo bardo = new Bardo("Finnian", 5, 150, 60, "laud", 80);

        Personaje[] equipo = { druida, nigromante, bardo };

        System.out.println("-- Ataques y dano --");
        for (Personaje p : equipo) {
            p.atacar();
            System.out.println("Dano: " + p.calcularDanio());
        }
        System.out.println();

        System.out.println("-- Curacion y hechizos segun la interfaz --");
        nigromante.recibirDanio(300);
        for (Personaje p : equipo) {
            if (p instanceof Hechicero) {
                Hechicero hechicero = (Hechicero) p;
                hechicero.lanzarHechizo();
            }
            if (p instanceof Sanador) {
                Sanador sanador = (Sanador) p;
                sanador.curarAliado(nigromante);
            }
        }
        System.out.println();

        System.out.println("-- Estado final --");
        for (Personaje p : equipo) {
            System.out.println(p);
        }
    }
}
