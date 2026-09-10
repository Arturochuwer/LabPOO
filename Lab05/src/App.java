import personajes.Arquero;
import personajes.GestorBatalla;
import personajes.Mago;
import personajes.Personaje;
import personajes.Warrior;

public class App {
    public static void main(String[] args) {
        System.out.println("=== RPG - Demostración de Polimorfismo ===");

        Personaje p1 = new Warrior("Thorin", 5, 200, 85, "Cota de Malla");
        Personaje p2 = new Mago("Gandalf", 8, 120, 150, "Fuego");
        Personaje p3 = new Arquero("Legolas", 6, 150, "Arco Largo", 30, 95);

        System.out.println("\n-- calcularDanio() por tipo --");
        System.out.println(p1.getNombre() + " (Guerrero) daño: " + p1.calcularDanio());
        System.out.println(p2.getNombre() + " (Mago)     daño: " + p2.calcularDanio());
        System.out.println(p3.getNombre() + " (Arquero)  daño: " + p3.calcularDanio());

        Personaje[] equipo = { p1, p2, p3 };
        System.out.println("\n-- Arreglo polimórfico --");
        for (Personaje personaje : equipo) {
            System.out.println(personaje.getNombre() + " daño: " + personaje.calcularDanio());
        }

        System.out.println("\n-- GestorBatalla --");
        GestorBatalla gestor = new GestorBatalla();
        gestor.ejecutarAtaque(p1);
        gestor.ejecutarAtaque(p2, p3);
        gestor.ejecutarAtaque(equipo);

        System.out.println("\n-- Historial --");
        gestor.mostrarHistorial();

        System.out.println("\n-- instanceof --");
        for (Personaje personaje : equipo) {
            if (personaje instanceof Warrior) {
                System.out.println(personaje.getNombre() + " es un Guerrero.");
            } else if (personaje instanceof Mago) {
                System.out.println(personaje.getNombre() + " es un Mago.");
            } else if (personaje instanceof Arquero) {
                System.out.println(personaje.getNombre() + " es un Arquero.");
            }
        }

        System.out.println("\n-- Sobrecarga adicional --");
        p1.mostrarEstado();
        p2.mostrarEstado(true);
        p3.mostrarEstado("Estado del arquero");
    }
}
