package org.example;

import java.util.List;

public interface LibroDAO {
    List<Libro> obtenerTodos();

    Libro obtenerPorId(int id);

    void agregar(Libro libro);

    void actualizar(Libro libro);

    void eliminar(int id);
}
