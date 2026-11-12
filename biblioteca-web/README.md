# Biblioteca Web (CRUD de libros)

Proyecto nuevo basado en las dos prácticas de la agenda: Spring Boot + JPA + Thymeleaf + SQL Server Express.

- Práctica 1: entidad, repositorio, controlador y plantillas con estilo oscuro.
- Práctica 2: capa de servicio, formulario compartido para crear/editar, variables de entorno para la BD y H2 en pruebas.

## Ejecutar
1. Crear la base de datos `biblioteca` en SQL Server Express (las tablas se crean solas).
2. Definir `DB_PASSWORD` (opcionales: `DB_URL`, `DB_USERNAME`).
3. `./mvnw spring-boot:run` y abrir http://localhost:8080

## Rutas
| Método | Ruta | Acción |
|---|---|---|
| GET | /libros | Listar |
| GET | /nuevo | Formulario nuevo |
| POST | /guardar | Crear |
| GET | /editar/{id} | Formulario de edición |
| POST | /actualizar/{id} | Actualizar |
| POST | /eliminar/{id} | Eliminar |

Pruebas: `./mvnw test` (usa H2 en memoria).
