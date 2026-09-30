package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        LibroDAO libroDAO = new LibroDAOImpl();

        libroDAO.agregar(new Libro(1, "Trono de Cristal", "Sarah J. Maas", 2012));
        libroDAO.agregar(new Libro(2, "Rose in Chains", "Julie Soto", 2025));
        libroDAO.agregar(new Libro(3, "Una Corte de Rosas y Espinas", "Sarah J. Maas", 2015));


        System.out.println("Todos los libros:");
        mostrarLibros(libroDAO.obtenerTodos());

        System.out.println();
        System.out.println("Libro con ID 1:");
        System.out.println(libroDAO.obtenerPorId(1));

        System.out.println();
        System.out.println("Actualizando libro con ID 1...");
        Libro libroActualizado = libroDAO.obtenerPorId(1);
        libroActualizado.setAnioPublicacion(2016);
        libroDAO.actualizar(libroActualizado);
        System.out.println("Libro actualizado con éxito.");

        System.out.println();
        System.out.println("Todos los libros después de actualizar:");
        mostrarLibros(libroDAO.obtenerTodos());

        System.out.println();
        System.out.println("Eliminando libro con ID 2...");
        libroDAO.eliminar(2);
        System.out.println("Libro eliminado con éxito.");

        System.out.println();
        System.out.println("Todos los libros después de eliminar:");
        mostrarLibros(libroDAO.obtenerTodos());

        System.out.println();
        System.out.println("Obteniendo un libro que no existe...");
        try {
            libroDAO.obtenerPorId(4);
        } catch (LibroNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println();
        System.out.println("Eliminando un libro que no existe...");
        try {
            libroDAO.eliminar(4);
        } catch (LibroNoEncontradoException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void mostrarLibros(List<Libro> libros) {
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados.");
            return;
        }

        for (Libro libro : libros) {
            System.out.println(libro);
        }
    }
}