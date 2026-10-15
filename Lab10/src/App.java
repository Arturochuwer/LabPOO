import personajes.Arquero;
import personajes.Druida;
import personajes.Nigromante;
import personajes.Personaje;
import personajes.Warrior;

public class App {

    public static void main(String[] args) {
        System.out.println("=== Gran Torneo del Gremio ===\n");

        TablaResultados tabla = new TablaResultados();

        Personaje s1 = new Druida("Sylva", 10, 300, 100, 100, "raíces");
        Personaje m1 = new Nigromante("Malachar", 8, 150, 120, 40);
        Personaje l1 = new Arquero("Legolas", 6, 200, "Arco", 10, 95);
        Personaje t1 = new Warrior("Thorin", 9, 400, 80, "Hacha");
        Personaje b1 = new Druida("Brego", 7, 250, 80, 80, "lobo");
        Personaje k1 = new Nigromante("Kael", 5, 180, 90, 30);

        Thread h1 = new Thread(new CombateConcurrente("Campo-1", s1, m1, tabla));
        Thread h2 = new Thread(new CombateConcurrente("Campo-2", l1, t1, tabla));
        Thread h3 = new Thread(new CombateConcurrente("Campo-3", b1, k1, tabla));

        h1.start();
        h2.start();
        h3.start();

        MonitorTorneo monitor = new MonitorTorneo("Torneo Principal", 3);
        monitor.start();

        if (esperarHilos(h1, h2, h3, monitor)) {
            System.out.println("Espera interrumpida.");
        }

        System.out.println("\nTodos los combates han terminado.");
        tabla.mostrarResultados();

        System.out.println("\n=== Demostración de race condition ===");
        ContadorCompartido contador = new ContadorCompartido();
        Thread[] hilos = new Thread[5];

        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    contador.incrementar();
                }
            });
            hilos[i].start();
        }
        if (esperarHilos(hilos)) {
            System.out.println("Espera interrumpida.");
        }
        System.out.println("Sin sync  — esperado: 5000 | real: " + contador.getContador());

        contador.resetear();
        for (int i = 0; i < hilos.length; i++) {
            hilos[i] = new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    contador.incrementarSeguro();
                }
            });
            hilos[i].start();
        }
        if (esperarHilos(hilos)) {
            System.out.println("Espera interrumpida.");
        }
        System.out.println("Con sync  — esperado: 5000 | real: " + contador.getContador());
    }

    private static boolean esperarHilos(Thread... hilos) {
        boolean interrumpido = false;
        for (Thread hilo : hilos) {
            while (hilo.isAlive()) {
                try {
                    hilo.join();
                } catch (InterruptedException e) {
                    interrumpido = true;
                }
            }
        }
        if (interrumpido) {
            Thread.currentThread().interrupt();
        }
        return interrumpido;
    }
}
