import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import personajes.Arquero;
import personajes.Druida;
import personajes.Personaje;
import personajes.Warrior;
import utilerias.PersistenciaGremio;

public class App {

    public static void main(String[] args) {
        try {
            PersistenciaGremio persistencia = new PersistenciaGremio();

            System.out.println("=== Bloque 1: Crear personajes y guardar roster ===");
            ArrayList<Personaje> roster = new ArrayList<>();
            roster.add(new Druida("Sylva", 10, 300, 100, 100, "raíces"));
            roster.add(new Arquero("Legolas", 6, 150, "Arco", 20, 95));
            roster.add(new Warrior("Thorin", 9, 400, 80, "Hacha"));
            persistencia.guardarRoster(roster);

            System.out.println("\n=== Bloque 2: Cargar roster desde archivo ===");
            ArrayList<String> lineasRoster = persistencia.cargarRoster();
            System.out.println("\n=== Roster cargado desde archivo ===");
            for (String linea : lineasRoster) {
                String[] partes = linea.split(",");
                System.out.println("Nombre: " + partes[0]
                        + " | Nivel: " + partes[1]
                        + " | Vida: " + partes[2]);
            }

            System.out.println("\n=== Bloque 3: Guardar y cargar inventario ===");
            HashMap<String, Integer> inventario = new HashMap<>();
            inventario.put("Poción de vida", 8);
            inventario.put("Flecha élfica", 30);
            inventario.put("Pergamino de fuego", 3);
            persistencia.guardarInventario(inventario);

            HashMap<String, Integer> inventarioCargado = persistencia.cargarInventario();
            System.out.println("\n=== Inventario cargado desde archivo ===");
            for (Map.Entry<String, Integer> entrada : inventarioCargado.entrySet()) {
                System.out.println(entrada.getKey() + " → " + entrada.getValue());
            }

            System.out.println("\n=== Bloque 4: Bitácora de batallas ===");
            persistencia.agregarEntradaBitacora("Sylva atacó a Malachar (daño: 240)");
            persistencia.agregarEntradaBitacora("Legolas sin flechas — no pudo atacar");
            persistencia.agregarEntradaBitacora("Thorin venció a Dragón de Hielo");
            persistencia.mostrarBitacora();

            System.out.println("\n=== Bloque 5: Verificar archivos creados ===");
            File carpeta = new File("datos_gremio");
            File[] archivos = carpeta.listFiles();
            if (archivos != null) {
                for (File archivo : archivos) {
                    System.out.println(archivo.getName() + " (" + archivo.length() + " bytes)");
                }
            }
        } catch (IOException e) {
            System.out.println("Error de archivo: " + e.getMessage());
        }
    }
}
