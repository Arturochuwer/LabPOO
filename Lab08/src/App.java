import personajes.Arquero;
import personajes.Druida;
import personajes.GestionGremio;
import personajes.Nigromante;
import personajes.Personaje;
import personajes.Warrior;

public class App {

    public static void main(String[] args) {
        GestionGremio gremio = new GestionGremio();

        System.out.println("=== Bloque 1: Roster con ArrayList ===");
        gremio.agregarMiembro(new Druida("Sylva", 10, 300, 100, 100, "raíces"));
        gremio.agregarMiembro(new Nigromante("Malachar", 8, 250, 120, 30));
        gremio.agregarMiembro(new Arquero("Legolas", 6, 150, "Arco", 20, 95));
        gremio.agregarMiembro(new Warrior("Thorin", 9, 400, 80, "Hacha"));
        gremio.mostrarRoster();

        gremio.eliminarMiembro("Malachar");
        gremio.mostrarRoster();

        Personaje encontrado = gremio.buscarPorNombre("Legolas");
        if (encontrado != null) {
            System.out.println("Encontrado: " + encontrado.getNombre());
        }

        System.out.println("\n=== Bloque 2: Cola FIFO con LinkedList ===");
        gremio.encolarSolicitante("Gandalf");
        gremio.encolarSolicitante("Aragorn");
        gremio.encolarSolicitante("Gimli");
        gremio.mostrarCola();

        gremio.atenderSiguiente();
        gremio.mostrarCola();

        System.out.println("\n=== Bloque 3: Inventario con HashMap ===");
        gremio.agregarItem("Poción de vida", 5);
        gremio.agregarItem("Flecha élfica", 30);
        gremio.agregarItem("Poción de vida", 3);
        gremio.mostrarInventario();

        gremio.usarItem("Poción de vida");
        gremio.usarItem("Pergamino de fuego");
        gremio.mostrarInventario();

        System.out.println("\n=== Bloque 4: Habilidades únicas con HashSet ===");
        gremio.registrarHabilidad("Curación");
        gremio.registrarHabilidad("Magia oscura");
        gremio.registrarHabilidad("Curación");
        gremio.mostrarHabilidades();

        System.out.println("¿Tiene tiro con arco? " + gremio.tieneHabilidad("Tiro con arco"));
        System.out.println("¿Tiene curación? " + gremio.tieneHabilidad("Curación"));

        System.out.println("\n=== Bloque 5: Resumen del gremio ===");
        gremio.mostrarRoster();
        gremio.mostrarCola();
        gremio.mostrarInventario();
        gremio.mostrarHabilidades();
    }
}
