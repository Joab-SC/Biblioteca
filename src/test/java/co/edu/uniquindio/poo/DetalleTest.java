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
public class DetalleTest {
    private static final Logger LOG = Logger.getLogger(DetalleTest.class.getName());

    /**
     * Rigorous Test :-)
     */    
    
    @Test
    public void tesLibro() {
        LOG.info("Iniciado test de libro");
        Autor autor = new Autor("Oscar", "234141", "3413423521", "oscar@gmail.com", "Ensayos", "muchos", LocalDate.of(2024, 10, 10));
        Editorial editorial = new Editorial("Norma", LocalDate.of(2021, 10, 10), "Aqui", "2352453463", "Sitioweb.html");
        Libro libro = new Libro("1371367132", "23kjni53wb", autor, "El principito", editorial, LocalDate.of(2021, 10, 10), 30);

        Detalle detalle = new Detalle(libro, 10);
        assertTrue(detalle.getLibro().equals(libro));
        LOG.info("Finalizando test de libro");
    }

    @Test
    public void testCantidadNegativa() {
        LOG.info("Iniciado test de cantidad negativa");
        Autor autor = new Autor("Oscar", "234141", "3413423521", "oscar@gmail.com", "Ensayos", "muchos", LocalDate.of(2024, 10, 10));
        Editorial editorial = new Editorial("Norma", LocalDate.of(2021, 10, 10), "Aqui", "2352453463", "Sitioweb.html");
        Libro libro = new Libro("1371367132", "23kjni53wb", autor, "El principito", editorial, LocalDate.of(2021, 10, 10), 30);

        assertThrows(Throwable.class , () -> new Detalle(libro, -10));


        LOG.info("Finalizando test de cantidad negativa");
    }


}
