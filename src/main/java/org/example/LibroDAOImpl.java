package org.example;

import java.util.ArrayList;
import java.util.List;

public class LibroDAOImpl implements LibroDAO {
    private final List<Libro> libros = new ArrayList<>();

    @Override
    public List<Libro> obtenerTodos() {
        return new ArrayList<>(libros);
    }

    @Override
    public Libro obtenerPorId(int id) {
        return libros.stream()
                .filter(libro -> libro.getId() == id)
                .findFirst()
                .orElseThrow(() -> new LibroNoEncontradoException("No existe un libro con el ID " + id + "."));
    }

    @Override
    public void agregar(Libro libro) {
        if (libro == null) {
            throw new IllegalArgumentException("El libro no puede ser nulo.");
        }

        if (libro.getId() <= 0) {
            throw new IllegalArgumentException("El ID del libro debe ser mayor que cero.");
        }

        if (libros.stream().anyMatch(libroActual -> libroActual.getId() == libro.getId())) {
            throw new IllegalArgumentException("Ya existe un libro con el ID " + libro.getId() + ".");
        }

        libros.add(libro);
    }

    @Override
    public void actualizar(Libro libro) {
        if (libro == null) {
            throw new IllegalArgumentException("El libro no puede ser nulo.");
        }

        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getId() == libro.getId()) {
                libros.set(i, libro);
                return;
            }
        }

        throw new LibroNoEncontradoException("No se puede actualizar porque no existe un libro con el ID " + libro.getId() + ".");
    }

    @Override
    public void eliminar(int id) {
        boolean eliminado = libros.removeIf(libro -> libro.getId() == id);

        if (!eliminado) {
            throw new LibroNoEncontradoException("No se puede eliminar porque no existe un libro con el ID " + id + ".");
        }
    }
}
