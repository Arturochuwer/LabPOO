# Lab10 — Torneo concurrente

Esta práctica simula tres combates RPG que se ejecutan en paralelo. Cada combate
implementa `Runnable`; un `MonitorTorneo` independiente extiende `Thread`. Los
resultados se almacenan en una tabla compartida cuyo método de registro está
sincronizado.

La aplicación espera a que terminen los combates y el monitor mediante `join()`.
Después compara un contador incrementado por varios hilos con y sin
`synchronized` para mostrar la diferencia entre una operación insegura y una
segura frente a condiciones de carrera.

Ejecuta la clase `App` desde VS Code para iniciar la demostración. El orden de
los mensajes de los hilos puede variar; el orden de los resultados registrados
también depende de cuál combate termine primero.
