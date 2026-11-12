package com.gremio.controller;

import com.gremio.model.Libro;
import com.gremio.service.LibroService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Controller
public class LibroController {

    private final LibroService service;

    public LibroController(LibroService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String inicio() {
        return "redirect:/libros";
    }

    @GetMapping("/libros")
    public String listar(Model model) {
        model.addAttribute("libros", service.listarTodos());
        return "libros";
    }

    @GetMapping("/nuevo")
    public String formulario(Model model) {
        model.addAttribute("libro", new Libro());
        return "formulario";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("libro", buscarLibro(id));
        return "formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Libro libro) {
        libro.setId(null); // siempre crea un registro nuevo
        service.guardar(libro);
        return "redirect:/libros";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable Long id, @ModelAttribute Libro datos) {
        Libro libro = buscarLibro(id);
        libro.setTitulo(datos.getTitulo());
        libro.setAutor(datos.getAutor());
        libro.setGenero(datos.getGenero());
        libro.setAnio(datos.getAnio());
        libro.setDisponible(datos.isDisponible());
        service.guardar(libro);
        return "redirect:/libros";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        buscarLibro(id);
        service.eliminar(id);
        return "redirect:/libros";
    }

    private Libro buscarLibro(Long id) {
        return service.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Libro no encontrado"));
    }
}
