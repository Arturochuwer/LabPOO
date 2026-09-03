import personajes.Personaje;
import personajes.Warrior;
import personajes.Mago;
import personajes.Arquero;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Personaje personaje1 = new Personaje("Juan", 5, 100, true);
        System.out.println(personaje1.toString());
        Warrior warrior2 = new Warrior("Miguel", 8, 120, true, "Espada");
        System.out.println(warrior2.toString());
        System.out.println(warrior2.getTipoArma());
        warrior2.atacar(15, "Hacha");

        Warrior warrior1 = new Warrior("Carlos", 10, 150, true, 20, 15);
        System.out.println(warrior1.toString());
        System.out.println(warrior1.getTipoArma());
        warrior1.atacar();

        Scanner scanner = new Scanner(System.in);

        System.out.println("\n=== Batalla RPG ===");

        System.out.println("\n-- Crear Guerrero --");
        System.out.print("Nombre: ");
        String nombreGuerrero = scanner.nextLine();
        System.out.print("Nivel: ");
        int nivelGuerrero = scanner.nextInt();
        System.out.print("Puntos de vida: ");
        int vidaGuerrero = scanner.nextInt();
        System.out.print("Fuerza: ");
        int fuerzaGuerrero = scanner.nextInt();
        System.out.print("Resistencia: ");
        int resistenciaGuerrero = scanner.nextInt();
        scanner.nextLine();
        Warrior guerrero = new Warrior(nombreGuerrero, nivelGuerrero, vidaGuerrero, true,
            fuerzaGuerrero, resistenciaGuerrero);

        System.out.println("\n-- Crear Mago --");
        System.out.print("Nombre: ");
        String nombreMago = scanner.nextLine();
        System.out.print("Nivel: ");
        int nivelMago = scanner.nextInt();
        System.out.print("Puntos de vida: ");
        int vidaMago = scanner.nextInt();
        System.out.print("Maná: ");
        int manaMago = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Escuela de magia: ");
        String escuelaMagia = scanner.nextLine();
        Mago mago = new Mago(nombreMago, nivelMago, vidaMago, true, manaMago, escuelaMagia);

        System.out.println("\n-- Crear Arquero --");
        System.out.print("Nombre: ");
        String nombreArquero = scanner.nextLine();
        System.out.print("Nivel: ");
        int nivelArquero = scanner.nextInt();
        System.out.print("Puntos de vida: ");
        int vidaArquero = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Tipo de arco: ");
        String tipoArco = scanner.nextLine();
        System.out.print("Flechas disponibles: ");
        int flechasDisponibles = scanner.nextInt();
        Arquero arquero = new Arquero(nombreArquero, nivelArquero, vidaArquero, true, tipoArco,
            flechasDisponibles);

        System.out.println("\n-- Ronda 1: Ataques --");
        guerrero.atacar();
        mago.atacar();
        arquero.atacar();

        System.out.println("\n-- Ronda 2: Defensas --");
        System.out.println(guerrero.defender());
        System.out.println(mago.defender());
        System.out.println(arquero.defender());

        System.out.println("\n-- Daño recibido --");
        System.out.print("Daño recibido por el Guerrero: ");
        int danioGuerrero = scanner.nextInt();
        guerrero.recibirDanio(danioGuerrero);
        System.out.print("Daño recibido por el Mago (será letal): ");
        int danioMago = scanner.nextInt();
        mago.recibirDanio(Math.max(danioMago, mago.getPuntosVida()));

        System.out.println("\n-- Estado final --");
        System.out.println(guerrero.toString());
        System.out.println(mago.toString());
        System.out.println(arquero.toString());
        scanner.close();
    }
}
