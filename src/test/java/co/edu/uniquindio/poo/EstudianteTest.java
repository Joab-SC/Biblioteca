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
public class EstudianteTest {
    private static final Logger LOG = Logger.getLogger(EstudianteTest.class.getName());

    /**
     * Rigorous Test :-)
     */
    @Test
    public void testDatosVacios() {
        LOG.info("Iniciado test datos vacíos");
        assertThrows(Throwable.class , () -> new Estudiante(" ", " ", " ", " "));
        LOG.info("Finalizando test datos vacíos");
    }


    @Test
    public void testCorreoValido() {
        LOG.info("Iniciado test de correo valido");
        
        assertThrows(Throwable.class , () -> new Estudiante("Sebastian", "1096", "31090", "danielgma.com"));
        LOG.info("Finalizando test de correo válido");
    }

    @Test
    public void testTelefonoValido() {
        LOG.info("Iniciado test de teléfono válido");
        
        assertThrows(Throwable.class , () -> new Estudiante("Sebastian", "1096", "3109as0", "danielgmail@.com"));
        LOG.info("Finalizando test de teléfono válido");
    }


    @Test
    public void testAgregarPrestamo() {
        LOG.info("Iniciado test de agregar préstamo");
        
        Estudiante estudiante = new Estudiante("Sergio", "1107849207", "3245844293", "Sergio@gmail");
        Bibliotecario bibliotecario = new Bibliotecario("Pedro", "123184923", "3258393839", "poersns@gmail.com", LocalDate.of(2014, 10, 3));
        Prestamo prestamo = new Prestamo(1000, LocalDate.of(2023, 10, 9), LocalDate.of(2023, 10, 10), estudiante, bibliotecario);
        Prestamo prestamo2 = new Prestamo(3000, LocalDate.of(2022, 10, 11), LocalDate.of(2023, 10, 10), estudiante, bibliotecario);
        estudiante.agregarPrestamo(prestamo);
        estudiante.agregarPrestamo(prestamo2);

        var listaEsperada = List.of(prestamo, prestamo2);
        
        assertIterableEquals(estudiante.getPrestamos(), listaEsperada);
        LOG.info("Finalizando test de agregar préstamo");
    }

}
