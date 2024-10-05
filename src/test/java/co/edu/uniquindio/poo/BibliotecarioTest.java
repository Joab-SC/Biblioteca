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
public class BibliotecarioTest {
    private static final Logger LOG = Logger.getLogger(BibliotecarioTest.class.getName());

    /**
     * Rigorous Test :-)
     */
    @Test
    public void testDatosVacios() {
        LOG.info("Iniciando test datos vacíos");

        assertThrows(Throwable.class, () -> new Bibliotecario(" ", " ", " ", " ", LocalDate.of(0, 0, 0)));

        LOG.info("Finalizando test datos vacíos");
    }

    @Test
    public void testFechaContrato(){
        LOG.info("Iniciando test de fecha contrato");
        Bibliotecario bibliotecario = new Bibliotecario("Esteban", "4980", "31090", "estaban@gmail.com", LocalDate.of(2018, 9, 20));
        assertEquals(bibliotecario.getFechaContrato(), LocalDate.of(2018, 9, 20));   
    }

    @Test
    public void testCorreoValido() {
        LOG.info("Iniciado test de correo valido");
        
        assertThrows(Throwable.class , () -> new Bibliotecario("Esteban", "4980", "31090", "estabangmail.com", LocalDate.of(2018, 9, 20)));
        LOG.info("Finalizando test de correo válido");
    }

    @Test
    public void testTelefonoValido() {
        LOG.info("Iniciado test de teléfono válido");
    
        assertThrows(Throwable.class , () -> new Bibliotecario("Esteban", "4980", "310as90", "estaban@gmail.com", LocalDate.of(2018, 9, 20)));
        LOG.info("Finalizando test de teléfono válido");
    }

    @Test
    public void testAgregarPrestamosBibliotecario() {
        LOG.info("Iniciado test de agregar préstamo a bibliotecario");
        Estudiante estudiante= new Estudiante("Joab", "1107849207", "3245844293", "Sergio@gmail");
        Bibliotecario bibliotecario = new Bibliotecario("Pedro", "123184923", "3258393839", "poersns@gmail.com", LocalDate.of(2014, 10, 3));
        Prestamo prestamo = new Prestamo(1000, LocalDate.of(2023, 10, 9), LocalDate.of(2023, 10, 10), estudiante, bibliotecario);
        Prestamo prestamo2 = new Prestamo(1000, LocalDate.of(2023, 10, 9), LocalDate.of(2023, 10, 10), estudiante, bibliotecario);

        bibliotecario.agregarPrestamo(prestamo);
        bibliotecario.agregarPrestamo(prestamo2);

        var listaEsperada = List.of(prestamo, prestamo2);

        assertIterableEquals(bibliotecario.getPrestamosBibliotecario(), listaEsperada);
        LOG.info("Finalizando test de agregar préstamo a bibliotecario");
    }

    @Test
    public void testFechaContratoValida() {
        LOG.info("Iniciado test de fecha de contrato válida");
        assertThrows(Throwable.class , () -> new Bibliotecario("Esteban", "4980", "31090", "estaban@gmail.com", LocalDate.of(2029, 9, 20)));
        LOG.info("Finalizando test de fecha de contrato válida");
        
    }

    @Test
    public void testCalcularTiempoTrabajo() {
        LOG.info("Iniciado test de calcular tiempo de trabajo");
        Bibliotecario bibliotecario = new Bibliotecario("Pedro", "123184923", "3258393839", "poersns@gmail.com", LocalDate.of(2014, 10, 3));
        assertEquals(bibliotecario.getTiempoTrabajo(), 10);
        LOG.info("Finalizando test de asegurar tiempo de trabajo");
        
    }

    @Test
    public void testCalcularSalario() {
        LOG.info("Iniciado test de calcular salario");
        Estudiante estudiante= new Estudiante("Joab", "1107849207", "3245844293", "Sergio@gmail");
        Autor autor = new Autor("Daniel", "1092", "310", "daniel@gmail.com", "Novela", "Nobel", LocalDate.of(2003, 10, 10));
        Editorial editorial = new Editorial("Norma", LocalDate.of(2021, 10, 10), "Aqui", "2352453463", "Sitioweb.html");
        Libro libro = new Libro("091", "lk92", autor, "El principito", editorial , LocalDate.of(2009, 10, 9), 10);
        Detalle detalle = new Detalle(libro, 8);
        Bibliotecario bibliotecario = new Bibliotecario("Pedro", "123184923", "3258393839", "poersns@gmail.com", LocalDate.of(2017, 10, 3));
        Prestamo prestamo = new Prestamo(3000, LocalDate.of(2023, 10, 9), LocalDate.of(2023, 10, 10), estudiante, bibliotecario);
        prestamo.agregarDetalle(detalle);

        bibliotecario.agregarPrestamo(prestamo);

        assertEquals(bibliotecario.calcularSalario(), 684);
        LOG.info("Finalizando test de calcular salario");
        
    }



}


