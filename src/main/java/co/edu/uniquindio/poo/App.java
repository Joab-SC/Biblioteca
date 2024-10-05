package co.edu.uniquindio.poo;

import java.time.LocalDate;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        // Crear la biblioteca
        Biblioteca biblioteca = new Biblioteca("Euclides Jaramillo Arango");

        // Crear estudiante y bibliotecario
        Estudiante estudiante = new Estudiante("Luis", "1107849207", "3245844293", "Sergio@gmail");
        Bibliotecario bibliotecario = new Bibliotecario("Pedro", "123184923", "3258393839", "poersns@gmail.com",
                LocalDate.of(2014, 10, 3));

        Biblioteca.mostrarMensaje("\n\nMostrando la biblioteca vacía\n" + biblioteca.toString());
        Biblioteca.mostrarMensaje("\n\nMostrando el estudiante sin prestamos\n" + estudiante.toString());
        Biblioteca.mostrarMensaje("\n\nMostrando el bibliotecario sin prestamos\n" + bibliotecario.toString());

        // Crear Autor y Editorial
        Autor autor = new Autor("Oscar", "234141", "3413423521", "oscar@gmail.com", "Ensayos", "muchos",
                LocalDate.of(2024, 10, 10));
        Editorial editorial = new Editorial("Norma", LocalDate.of(2021, 10, 10), "Aqui", "2352453463", "Sitioweb.html");
        Biblioteca.mostrarMensaje("\n\nMostranto el autor sin libros\n" + autor.toString());
        Biblioteca.mostrarMensaje("\n\nMostrando la edutorial sin libros\n" + editorial.toString());

        // Crear Libro
        Libro libro = new Libro("1371367132", "23kjni53wb", autor, "El principito", editorial,
                LocalDate.of(2021, 10, 10), 30);
        Libro libro2 = new Libro("13713673452", "2ew4i53wb", autor, "La odisea", editorial, LocalDate.of(2021, 10, 10),
                20);

        Biblioteca.mostrarMensaje("\n\nMostrando el libro1\n" + libro.toString());
        Biblioteca.mostrarMensaje("\n\nMostrando el libro2\n" + libro2.toString());

        // Agregar Libros
        autor.agregarLibro(libro);
        editorial.agregarLibro(libro);
        Biblioteca.mostrarMensaje("\n\nMostrando el autor con un libro\n" + autor.toString());
        Biblioteca.mostrarMensaje("\n\nMostrando la editorial con un libro\n" + editorial.toString());

        // Crear Detalle
        Detalle detalle1 = new Detalle(libro, 4);
        Detalle detalle2 = new Detalle(libro2, 2);
        Detalle detalle3 = new Detalle(libro2, 409);

        // Crear Prestamo
        Prestamo prestamo = new Prestamo(1000, LocalDate.of(2023, 10, 8), LocalDate.of(2023, 10, 10), estudiante,
                bibliotecario);
        prestamo.agregarDetalle(detalle2);
        prestamo.agregarDetalle(detalle1);
        prestamo.agregarDetalle(detalle3); // Se muestra mensaje de error porque no hay suficientes libros

        Biblioteca.mostrarMensaje("\n\nMostrando el libro tras haber hecho un préstamo\n" + libro.toString());
        Biblioteca.mostrarMensaje("\n\nMostrando el libro2 tras haber hecho un préstamo\n" + libro2.toString());
        Biblioteca.mostrarMensaje("\n\nMostrando el prestamo con los 2 libros\n" + prestamo.toString());

        estudiante.agregarPrestamo(prestamo);
        Biblioteca.mostrarMensaje("\n\nMostrando el estudiante con un préstamo\n" + estudiante.toString());

        // Agregar Bibliotecario y Estudiante y libro a Biblioteca
        biblioteca.agregarBibliotecario(bibliotecario);
        biblioteca.agregarEstudiante(estudiante);
        biblioteca.agregarLibro(libro);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarPrestamo(prestamo);
        bibliotecario.agregarPrestamo(prestamo);
        Biblioteca.mostrarMensaje("\n\nMostrando la biblioteca con todo\n" + biblioteca.toString());
        Biblioteca.mostrarMensaje("\n\n" + //
                "Mostrando la cantidad de préstamos de cada bibliotecario\n"
                + biblioteca.obtenerCantidadPrestamosBibliotecarios());
        Biblioteca.mostrarMensaje("\n\n" + //
                "Mostrando los salarios de todos los bibliotecarios\n" + biblioteca.obtenerSalariosBibliotecarios());
        Biblioteca.mostrarMensaje("\n\nMostrando el estudiante con más préstamos\n"
                + biblioteca.obtenerEstudianteMasPrestamos().toString());
        Biblioteca.mostrarMensaje("\n\nMostrando la cantidad de préstamos en que está el libro1\nEl principito: "
                + biblioteca.obtenerCantidadPrestamosLibro("El principito"));

    }

}
