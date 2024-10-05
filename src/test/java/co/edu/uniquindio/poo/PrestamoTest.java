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
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class PrestamoTest {
    private static final Logger LOG = Logger.getLogger(PrestamoTest.class.getName());

    /**
     * Rigorous Test :-)
     */    
    
     @Test
    public void testPrecioNegativo() {
        LOG.info("Iniciado test precio negativo");
        Estudiante estudiante= new Estudiante("Joab", "1107849207", "3245844293", "Sergio@gmail");
        Bibliotecario bibliotecario = new Bibliotecario("Pedro", "123184923", "3258393839", "poersns@gmail.com", LocalDate.of(2014, 10, 3));
        assertThrows(Throwable.class , () -> new Prestamo(-200, LocalDate.of(2023, 10, 9), LocalDate.of(2023, 10, 10), estudiante, bibliotecario));
        LOG.info("Finalizando test precio negativo");
    }

    @Test
    public void testDiasNegativos() {
        LOG.info("Iniciado test días negativos");
        Estudiante estudiante= new Estudiante("Joab", "1107849207", "3245844293", "Sergio@gmail");
        Bibliotecario bibliotecario = new Bibliotecario("Pedro", "123184923", "3258393839", "poersns@gmail.com", LocalDate.of(2014, 10, 3));
        assertThrows(Throwable.class , () -> new Prestamo(200, LocalDate.of(2023, 10, 19), LocalDate.of(2023, 10, 10), estudiante, bibliotecario));
        LOG.info("Finalizando test días negativos");
    }

    @Test
    public void testAgregarDetalle() {
        LOG.info("Iniciado test agregar detalle");
        Estudiante estudiante= new Estudiante("Joab", "1107849207", "3245844293", "Sergio@gmail");
        Bibliotecario bibliotecario = new Bibliotecario("Pedro", "123184923", "3258393839", "poersns@gmail.com", LocalDate.of(2014, 10, 3));
        Autor autor= new Autor("Oscar", "234141", "3413423521", "oscar@gmail.com", "Ensayos", "muchos", LocalDate.of(2024, 10, 10));
        Editorial editorial = new Editorial("Norma", LocalDate.of(2021, 10, 10), "Aqui", "2352453463", "Sitioweb.html");
        Libro libro = new Libro("1371367132", "23kjni53wb", autor, "La iliada", editorial, LocalDate.of(2009, 10, 4), 15);
        Libro libro2 = new Libro("52435", "gdf34", autor, "El diario de Ana Frank", editorial, LocalDate.of(2009, 10, 4), 15);
        Detalle detalle1 = new Detalle(libro, 4);
        Detalle detalle2 = new Detalle(libro2, 11);

        Prestamo prestamo = new Prestamo(1000, LocalDate.of(2023, 10, 9), LocalDate.of(2023, 10, 10), estudiante, bibliotecario);
        prestamo.agregarDetalle(detalle1);
        prestamo.agregarDetalle(detalle2);

        var listaEsperada = List.of(detalle1, detalle2);

        assertIterableEquals(prestamo.getDetalles(), listaEsperada);
        LOG.info("Finalizando test agregar detalle");
    }

    @Test
    public void testAgregarDetalleMismoLibro() {
        LOG.info("Iniciado test agregar detalle con el mismo libro");
        Estudiante estudiante= new Estudiante("Joab", "1107849207", "3245844293", "Sergio@gmail");
        Bibliotecario bibliotecario = new Bibliotecario("Pedro", "123184923", "3258393839", "poersns@gmail.com", LocalDate.of(2014, 10, 3));
        Autor autor= new Autor("Oscar", "234141", "3413423521", "oscar@gmail.com", "Ensayos", "muchos", LocalDate.of(2024, 10, 10));
        Editorial editorial = new Editorial("Norma", LocalDate.of(2021, 10, 10), "Aqui", "2352453463", "Sitioweb.html");
        Libro libro = new Libro("1371367132", "23kjni53wb", autor, "La iliada", editorial, LocalDate.of(2009, 10, 4), 15);
        Detalle detalle1 = new Detalle(libro, 4);
        Detalle detalle2 = new Detalle(libro, 11);

        Prestamo prestamo = new Prestamo(1000, LocalDate.of(2023, 10, 9), LocalDate.of(2023, 10, 10), estudiante, bibliotecario);
        prestamo.agregarDetalle(detalle1);
        prestamo.agregarDetalle(detalle2);

        var listaEsperada = List.of(detalle2);

        assertIterableEquals(prestamo.getDetalles(), listaEsperada);
        LOG.info("Finalizando test agregar detalle con el mismo libro");
    }

    @Test
    public void testReducirUnidadesDisponibles() {
        LOG.info("Iniciado test reducir unidades disponibles");
        Estudiante estudiante= new Estudiante("Joab", "1107849207", "3245844293", "Sergio@gmail");
        Bibliotecario bibliotecario = new Bibliotecario("Pedro", "123184923", "3258393839", "poersns@gmail.com", LocalDate.of(2014, 10, 3));
        Autor autor= new Autor("Oscar", "234141", "3413423521", "oscar@gmail.com", "Ensayos", "muchos", LocalDate.of(2024, 10, 10));
        Editorial editorial = new Editorial("Norma", LocalDate.of(2021, 10, 10), "Aqui", "2352453463", "Sitioweb.html");
        Libro libro = new Libro("1371367132", "23kjni53wb", autor, "La iliada", editorial, LocalDate.of(2009, 10, 4), 15);
        Detalle detalle1 = new Detalle(libro, 4);
        Detalle detalle2 = new Detalle(libro, 6);
        Detalle detalle3 = new Detalle(libro, 2);

        Prestamo prestamo = new Prestamo(1000, LocalDate.of(2023, 10, 9), LocalDate.of(2023, 10, 10), estudiante, bibliotecario);
        prestamo.agregarDetalle(detalle1);
        prestamo.agregarDetalle(detalle2);
        prestamo.agregarDetalle(detalle3);


        assertEquals(detalle3.getLibro().getUnidadesDisponibles(), 3);
        LOG.info("Finalizando test reducir unidades disponibles");
    }




}
