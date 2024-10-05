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
public class AutorTest {
    private static final Logger LOG = Logger.getLogger(AutorTest.class.getName());

    /**
     * Rigorous Test :-)
     */    
    
     @Test
    public void testDatosVacios() {
        LOG.info("Iniciado test datos vacíos");
        assertThrows(Throwable.class , () -> new Autor(" ", " ", " ", " ", " ", "@", LocalDate.of(0, 0, 0)));
        LOG.info("Finalizando test datos vacíos");
    }

    @Test
    public void testCorreoValido() {
        LOG.info("Iniciado test de correo valido");
        
        assertThrows(Throwable.class , () -> new Autor("Daniel", "1092", "310", "danielgmail.com", "Novela", "Nobel", LocalDate.of(2003, 10, 10)));
        LOG.info("Finalizando test de correo válido");
    }

    @Test
    public void testTelefonoValido() {
        LOG.info("Iniciado test de teléfono válido");
        
        assertThrows(Throwable.class , () -> new Autor("Daniel", "1092", "]310ase", "danielgmail@.com", "Novela", "Nobel", LocalDate.of(2003, 10, 10)));
        LOG.info("Finalizando test de teléfono válido");
    }
    @Test
    public void testObtenerLibros() {
        LOG.info("Iniciado test de agregar libros");
        Autor autor = new Autor("Daniel", "1092", "310", "daniel@gmail.com", "Novela", "Nobel", LocalDate.of(2003, 10, 10));
        Editorial editorial = new Editorial("Norma", LocalDate.of(2021, 10, 10), "Aqui", "2352453463", "Sitioweb.html");

        Libro libro = new Libro("091", "lk92", autor, "El principito", editorial , LocalDate.of(2009, 10, 9), 10);
        Libro libro2 = new Libro("21", "an89", autor, "La odisea", editorial , LocalDate.of(2006, 10, 9), 10);

        autor.agregarLibro(libro);
        autor.agregarLibro(libro2);
        
        var listaEsperada = List.of(libro, libro2); 
        assertIterableEquals(autor.getLibrosEscritos(), listaEsperada);
        LOG.info("Finalizando test de agregar libros");
    }

    @Test
    public void testNombre() {
        LOG.info("Iniciado test de nombre");
        Autor autor = new Autor("Daniel", "1092", "310", "daniel@gmail.com", "Novela", "Nobel", LocalDate.of(2003, 10, 10));
        assertEquals("Daniel", autor.getNombre());
        LOG.info("Finalizando test nombre");
    }

    @Test
    public void testFecha() {
        LOG.info("Iniciado test de fecha");
        Autor autor = new Autor("Daniel", "1092", "310", "daniel@gmail.com", "Novela", "Nobel", LocalDate.of(2003, 10, 10));
        assertEquals(LocalDate.of(2003, 10, 10), autor.getFechaNacimiento());
        LOG.info("Finalizando test fecha");
    }

}
