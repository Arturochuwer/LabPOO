package com.gremio.biblioteca_web;

import com.gremio.BibliotecaWebApplication;
import com.gremio.model.Libro;
import com.gremio.service.LibroService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(classes = BibliotecaWebApplication.class)
@AutoConfigureMockMvc
class LibroCrudTests {

    @Autowired MockMvc mvc;
    @Autowired LibroService service;

    @Test
    void crudCompleto() throws Exception {
        mvc.perform(post("/guardar").param("titulo", "Dune").param("autor", "Frank Herbert")
                        .param("genero", "Ciencia ficción").param("anio", "1965").param("disponible", "true"))
                .andExpect(status().is3xxRedirection());

        Libro libro = service.listarTodos().stream()
                .filter(l -> l.getTitulo().equals("Dune")).findFirst().orElseThrow();
        assertEquals("Frank Herbert", libro.getAutor());

        mvc.perform(get("/libros")).andExpect(status().isOk()).andExpect(content().string(org.hamcrest.Matchers.containsString("Dune")));
        mvc.perform(get("/editar/" + libro.getId())).andExpect(status().isOk());

        mvc.perform(post("/actualizar/" + libro.getId()).param("titulo", "Dune").param("autor", "F. Herbert")
                        .param("anio", "1965"))   // checkbox sin marcar => prestado
                .andExpect(status().is3xxRedirection());
        Libro act = service.buscarPorId(libro.getId()).orElseThrow();
        assertEquals("F. Herbert", act.getAutor());
        assertFalse(act.isDisponible());

        mvc.perform(post("/eliminar/" + libro.getId())).andExpect(status().is3xxRedirection());
        assertTrue(service.buscarPorId(libro.getId()).isEmpty());
        mvc.perform(get("/editar/" + libro.getId())).andExpect(status().isNotFound());
    }
}
