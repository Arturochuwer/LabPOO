import personajes.AccionInvalidaException;
import personajes.Arquero;
import personajes.Druida;
import personajes.MotorCombate;
import personajes.Nigromante;
import personajes.Personaje;
import personajes.RpgException;

public class App {

    public static void main(String[] args) throws RpgException {
        System.out.println("=== RPG - Sistema con Manejo de Excepciones ===");

        MotorCombate motor = new MotorCombate();
        Druida druida = new Druida("Sylva", 7, 200, 233, 120, "raices");
        Nigromante nigromante = new Nigromante("Malachar", 6, 350, 220, 30, 60);

        System.out.println("\n-- Escenario 1: turno normal --");
        motor.ejecutarTurno(druida, nigromante);

        System.out.println("\n-- Escenario 2: personaje derrotado --");
        druida.recibirDanio(9999);
        motor.ejecutarTurno(druida, nigromante);

        System.out.println("\n-- Escenario 3: arquero sin flechas --");
        Arquero sinFlechas = new Arquero("Legolas", 6, 150, "Arco Largo", 0, 95);
        motor.ejecutarTurno(sinFlechas, nigromante);

        System.out.println("\n-- Escenario 4: curar aliado derrotado --");
        Druida druida2 = new Druida("Lunara", 5, 180, 50, 80, "roble");
        Personaje personajeDerrotado = new Arquero("Caido", 1, 1, "Arco", 2, 10);
        personajeDerrotado.recibirDanio(10);
        try {
            druida2.curarAliado(personajeDerrotado);
        } catch (RpgException e) {
            System.out.println("No se pudo curar: " + e.getMessage());
        }

        System.out.println("\n-- Escenario 5: daño negativo con finally --");
        try {
            nigromante.recibirDanio(-50);
        } catch (AccionInvalidaException e) {
            System.out.println("Capturado: " + e.getMessage());
        } finally {
            System.out.println("El bloque finally siempre se ejecuta.");
        }

        System.out.println("\n-- Escenario 6: bitácora completa --");
        motor.mostrarBitacora();
    }
}
