package com.gremio.service;

import com.gremio.model.Libro;
import com.gremio.repository.LibroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    private final LibroRepository repo;

    public LibroService(LibroRepository repo) {
        this.repo = repo;
    }

    public List<Libro> listarTodos() {
        return repo.findAll();
    }

    public Libro guardar(Libro libro) {
        return repo.save(libro);
    }

    public Optional<Libro> buscarPorId(Long id) {
        return repo.findById(id);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
