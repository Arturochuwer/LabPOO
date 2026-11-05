package com.gremio.controller;

import com.gremio.model.Contacto;
import com.gremio.service.ContactoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Controller
public class ContactoController {

    private final ContactoService service;

    public ContactoController(ContactoService service) {
        this.service = service;
    }

    @GetMapping("/contactos")
    public String listar(Model model) {
        model.addAttribute("contactos", service.listarTodos());
        return "contactos";
    }

    @GetMapping("/nuevo")
    public String formulario(Model model) {
        model.addAttribute("contacto", new Contacto());
        return "formulario";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("contacto", buscarContacto(id));
        return "formulario";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Contacto contacto) {
        service.guardar(contacto);
        return "redirect:/contactos";
    }

    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable Long id, @ModelAttribute Contacto datosContacto) {
        Contacto contacto = buscarContacto(id);
        contacto.setNombre(datosContacto.getNombre());
        contacto.setApellido(datosContacto.getApellido());
        contacto.setEmail(datosContacto.getEmail());
        contacto.setTelefono(datosContacto.getTelefono());
        service.guardar(contacto);
        return "redirect:/contactos";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        buscarContacto(id);
        service.eliminar(id);
        return "redirect:/contactos";
    }

    private Contacto buscarContacto(Long id) {
        return service.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Contacto no encontrado"));
    }
}
