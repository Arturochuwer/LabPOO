package personajes;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class GestorBatalla {
	private final ArrayList<String> historial = new ArrayList<>();

	public void ejecutarAtaque(Personaje atacante) {
		int danio = atacante.calcularDanio();
		atacante.atacar();
		System.out.println("[BATALLA] " + atacante.getNombre() + " ataca solo -> daño: " + danio);
		historial.add(atacante.getNombre() + " atacó solo (daño: " + danio + ")");
	}

	public void ejecutarAtaque(Personaje atacante, Personaje defensor) {
		int danio = atacante.calcularDanio();
		atacante.atacar();
		System.out.println("[BATALLA] " + atacante.getNombre() + " ataca a "
				+ defensor.getNombre() + " -> daño: " + danio);
		defensor.recibirDanio(danio);
		defensor.defender();

		String evento = atacante.getNombre() + " atacó a " + defensor.getNombre()
				+ " (daño: " + danio + ")";
		if (!defensor.isEstaVivo()) {
			evento += " - " + defensor.getNombre() + " derrotado";
		}
		historial.add(evento);
	}

	public void ejecutarAtaque(Personaje[] equipo) {
		for (Personaje atacante : equipo) {
			atacante.atacar();
		}
		System.out.println("[BATALLA] Equipo completo ataca -> " + equipo.length + " personajes");

		String nombres = java.util.Arrays.stream(equipo)
				.map(Personaje::getNombre)
				.collect(Collectors.joining(", "));
		historial.add("Ataque en equipo: " + nombres);
	}

	public void mostrarHistorial() {
		for (int i = 0; i < historial.size(); i++) {
			System.out.println((i + 1) + ". " + historial.get(i));
		}
	}

	public void limpiarHistorial() {
		historial.clear();
	}

}
