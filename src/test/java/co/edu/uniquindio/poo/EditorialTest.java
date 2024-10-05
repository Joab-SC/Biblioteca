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
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class EditorialTest {
    private static final Logger LOG = Logger.getLogger(EditorialTest.class.getName());

    /**
     * Rigorous Test :-)
     */
    @Test
    public void testDatosVacios() {
        LOG.info("Iniciado test de datos vacíos");
        assertThrows(Throwable.class, () ->  new Editorial(" ", LocalDate.of(0, 0, 0), " ", " ", " "));
        LOG.info("Finalizando test de datos vacíos");
    }

    @Test
    public void testTelefonoValido() {
        LOG.info("Iniciado test de correo valido");
        assertThrows(Throwable.class , () -> new Editorial("Norma", LocalDate.of(2021, 10, 10), "Alemania", "312as09", "Sitioweb.html"));
        LOG.info("Finalizando test de correo válido");
    }

    @Test
    public void testNombre() {
        LOG.info("Iniciado test de nombre");
        Editorial editorial = new Editorial("Norma", LocalDate.of(2021, 10, 10), "Aqui", "2352453463", "Sitioweb.html");
        assertEquals(editorial.getNombre(), "Norma");
        LOG.info("Finalizando test de nombre");
    }

    @Test
    public void testSitioWeb() {
        LOG.info("Iniciado test de sitio web");
        Editorial editorial = new Editorial("Norma", LocalDate.of(2021, 10, 10), "Aqui", "2352453463", "Sitioweb.html");
        assertEquals(editorial.getSitioWeb(), "Sitioweb.html");
        LOG.info("Finalizando test de sitio web");
    }

    @Test
    public void testAgregarLibro(){
        LOG.info("Inciando test de agregar libro");
        Editorial editorial = new Editorial("Norma", LocalDate.of(2021, 10, 10), "Aqui", "2352453463", "Sitioweb.html");
        Autor autor= new Autor("Oscar", "234141", "3413423521", "oscar@gmail.com", "Ensayos", "muchos", LocalDate.of(2024, 10, 10));
        Libro libro=new Libro("1371367132", "23kjni53wb", autor, "El principito", editorial, LocalDate.of(2021, 10, 10), 30);

        editorial.agregarLibro(libro);

        assertTrue(editorial.getLibrosEditorial().contains(libro));

    }

}