/**
 * Clase para probar el funcionamiento del código
 * @author Área de programación UQ
 * @since 2023-08
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class BibliotecaTest {
    private static final Logger LOG = Logger.getLogger(BibliotecaTest.class.getName());
    /**
     * Rigorous Test :-)
     */

     @Test
    public void testDatosVacios() {
        LOG.info("Iniciado test datos vacíos");
        assertThrows(Throwable.class , () -> new Biblioteca(" "));
        LOG.info("Finalizando test datos vacíos");
    }

    @Test
    public void testNombre() {
        LOG.info("Iniciado test de nombre");
        Biblioteca biblioteca = new Biblioteca("CRAI");
        assertEquals("CRAI", biblioteca.getNombre());
        LOG.info("Finalizando test nombre");
    }
    
    @Test
    public void testAgregarLibro() {
        LOG.info("Iniciado test de agregar libros");

        Biblioteca biblioteca= new Biblioteca("Euclides Jaramillo Arango");
        Autor autor = new Autor("Daniel", "1092", "310", "daniel@gmail.com", "Novela", "Nobel", LocalDate.of(2003, 10, 10));
        Editorial editorial = new Editorial("Norma", LocalDate.of(2021, 10, 10), "Aqui", "2352453463", "Sitioweb.html");
        Libro libro = new Libro("091", "lk92", autor, "El principito", editorial , LocalDate.of(2009, 10, 9), 10);
        Libro libro2 = new Libro("21", "an89", autor, "La odisea", editorial , LocalDate.of(2006, 10, 9), 10);

        biblioteca.agregarLibro(libro);
        biblioteca.agregarLibro(libro2);
        
        var listaEsperada = List.of(libro, libro2); 
        assertIterableEquals(biblioteca.getLibros(), listaEsperada);
        LOG.info("Finalizando test de agregar libros");
    }

    @Test
    public void testAgregarBibliotecario() {
        LOG.info("Iniciado test agregar bibliotecario");

        Biblioteca biblioteca= new Biblioteca("Euclides Jaramillo Arango");
        Bibliotecario bibliotecario = new Bibliotecario("Pedro", "123184923", "3258393839", "poersns@gmail.com", LocalDate.of(2014, 10, 3));

        biblioteca.agregarBibliotecario(bibliotecario);
    
        assertTrue(biblioteca.getBibliotecarios().contains(bibliotecario));
        LOG.info("Finalizando test agregar libros");
    }

    @Test
    public void testAgregarEstudiantes() {
        LOG.info("Iniciado test agregar estudiantes");

        Biblioteca biblioteca = new Biblioteca("Euclides Jaramillo Arango");
        Estudiante estudiante = new Estudiante("Sergio", "1107849207", "3245844293", "Sergio@gmail");
        Estudiante estudiante2 = new Estudiante("Joab", "1107849207", "3245844293", "joab@gmail");

        biblioteca.agregarEstudiante(estudiante);
        biblioteca.agregarEstudiante(estudiante2);

        var listaEsperada = List.of(estudiante, estudiante2); 
    
        assertIterableEquals(biblioteca.getEstudiantes(), listaEsperada);
        LOG.info("Finalizando test agregar estudiantes");
    }

    @Test
    public void testCantidadPrestamosLibro() {
        LOG.info("Finalizando test de cantidad de préstamos de un libro");

        Biblioteca biblioteca= new Biblioteca("Euclides Jaramillo Arango");
        Autor autor = new Autor("Daniel", "1092", "310", "daniel@gmail.com", "Novela", "Nobel", LocalDate.of(2003, 10, 10));
        Editorial editorial = new Editorial("Norma", LocalDate.of(2021, 10, 10), "Aqui", "2352453463", "Sitioweb.html");
        Libro libro = new Libro("091", "lk92", autor, "El principito", editorial , LocalDate.of(2009, 10, 9), 10);
        Estudiante estudiante = new Estudiante("Sergio", "1107849207", "3245844293", "Sergio@gmail");
        Bibliotecario bibliotecario = new Bibliotecario("Pedro", "123184923", "3258393839", "poersns@gmail.com", LocalDate.of(2014, 10, 3));

        Detalle detalle1 = new Detalle(libro, 4);
        Detalle detalle2 = new Detalle(libro, 3);

        Prestamo prestamo= new Prestamo(1000, LocalDate.of(2023, 10, 9), LocalDate.of(2023, 10, 10), estudiante, bibliotecario);
        prestamo.agregarDetalle(detalle1);

        Prestamo prestamo2= new Prestamo(2000, LocalDate.of(2023, 9, 9), LocalDate.of(2023, 10, 10), estudiante, bibliotecario);
        prestamo2.agregarDetalle(detalle2);

        biblioteca.agregarPrestamo(prestamo);
        biblioteca.agregarPrestamo(prestamo2);

        assertEquals(biblioteca.obtenerCantidadPrestamosLibro("El principito"), 2);
        LOG.info("Finalizando test de cantidad de préstamos de un libro");
    }

    @Test
    public void testEstudianteMasPrestamos() {
        LOG.info("Finalizando test de estudiante con más préstamos");

        Biblioteca biblioteca= new Biblioteca("Euclides Jaramillo Arango");
        Autor autor = new Autor("Daniel", "1092", "310", "daniel@gmail.com", "Novela", "Nobel", LocalDate.of(2003, 10, 10));
        Editorial editorial = new Editorial("Norma", LocalDate.of(2021, 10, 10), "Aqui", "2352453463", "Sitioweb.html");
        Libro libro = new Libro("091", "lk92", autor, "El principito", editorial , LocalDate.of(2009, 10, 9), 10);
        Estudiante estudiante1 = new Estudiante("Sergio", "1107849207", "3245844293", "Sergio@gmail");
        Estudiante estudiante2 = new Estudiante("Joab", "1107849207", "3245844293", "joab@gmail");
        Bibliotecario bibliotecario = new Bibliotecario("Pedro", "123184923", "3258393839", "poersns@gmail.com", LocalDate.of(2014, 10, 3));

        Detalle detalle1 = new Detalle(libro, 4);
        Detalle detalle2 = new Detalle(libro, 3);

        Prestamo prestamo= new Prestamo(1000, LocalDate.of(2023, 10, 9), LocalDate.of(2023, 10, 10), estudiante1, bibliotecario);
        prestamo.agregarDetalle(detalle1);

        Prestamo prestamo2= new Prestamo(2000, LocalDate.of(2023, 9, 9), LocalDate.of(2023, 10, 10), estudiante1, bibliotecario);
        prestamo2.agregarDetalle(detalle2);

        Prestamo prestamo3= new Prestamo(2000, LocalDate.of(2021, 9, 9), LocalDate.of(2023, 10, 10), estudiante2, bibliotecario);
        prestamo3.agregarDetalle(detalle2);

        estudiante1.agregarPrestamo(prestamo);
        estudiante1.agregarPrestamo(prestamo2);

        estudiante2.agregarPrestamo(prestamo3);

        biblioteca.agregarEstudiante(estudiante1);
        biblioteca.agregarEstudiante(estudiante2);

        

        assertTrue(biblioteca.obtenerEstudianteMasPrestamos().equals(estudiante1));
        LOG.info("Finalizando test de estudiante con más préstamos");
    }

}