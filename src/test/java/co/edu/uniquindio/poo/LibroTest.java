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
public class LibroTest {
    private static final Logger LOG = Logger.getLogger(LibroTest.class.getName());

    /**
     * Rigorous Test :-)
     */    
    
     @Test
    public void testDatosVacios() {
        LOG.info("Iniciado test datos vacíos");
        Autor autor= new Autor("Oscar", "234141", "3413423521", "oscar@gmail.com", "Ensayos", "muchos", LocalDate.of(2024, 10, 10));
        Editorial editorial = new Editorial("Norma", LocalDate.of(2021, 10, 10), "Aqui", "2352453463", "Sitioweb.html");
        assertThrows(Throwable.class , () -> new Libro(" ", " ", autor, " ", editorial, LocalDate.of(0, 0, 0), 0));
        LOG.info("Finalizando test datos vacíos");
    }

    @Test
    public void testAutor() {
        LOG.info("Iniciado test de autor");
        Autor autor= new Autor("Oscar", "234141", "3413423521", "oscar@gmail.com", "Ensayos", "muchos", LocalDate.of(2024, 10, 10));
        Editorial editorial = new Editorial("Norma", LocalDate.of(2021, 10, 10), "Aqui", "2352453463", "Sitioweb.html");
        Libro libro=new Libro("1371367132", "23kjni53wb", autor, "El principito", editorial, LocalDate.of(2021, 10, 10), 30);
        assertEquals(libro.getAutor(), autor);
        LOG.info("Finalizando test de autor");
    }

    @Test
    public void testEditorial() {
        LOG.info("Iniciado test de editorial");
        Autor autor= new Autor("Oscar", "234141", "3413423521", "oscar@gmail.com", "Ensayos", "muchos", LocalDate.of(2024, 10, 10));
        Editorial editorial = new Editorial("Norma", LocalDate.of(2021, 10, 10), "Aqui", "2352453463", "Sitioweb.html");
        Libro libro=new Libro("1371367132", "23kjni53wb", autor, "El principito", editorial, LocalDate.of(2021, 10, 10), 30);
        assertEquals(libro.getEditorial(), editorial);
        LOG.info("Finalizando test de editorial");
    }

}
