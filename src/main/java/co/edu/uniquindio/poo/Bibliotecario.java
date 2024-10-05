package co.edu.uniquindio.poo;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;

public class Bibliotecario extends Persona{
    
    private LinkedList<Prestamo> prestamosBibliotecario;
    private LocalDate fechaContrato;
    private int tiempoTrabajo;

    Bibliotecario(String nombre, String cedula, String telefono, String correo, LocalDate fechaContrato){
        super(nombre, cedula, telefono, correo);
        this.prestamosBibliotecario = new LinkedList<>();
        this.fechaContrato = fechaContrato;
        this.tiempoTrabajo = calcularTiempoTrabajo();

        assert !nombre.isBlank();
        assert !cedula.isBlank();
        assert !telefono.isBlank();
        assert !correo.isBlank();
        assert correo.contains("@");
        assert telefono.matches("^[+()\\d\\s-]+$");
        assert !fechaContrato.isAfter(LocalDate.now());
    
    }


    public LocalDate getFechaContrato() {
        return fechaContrato;
    }

    public void setFechaContrato(LocalDate fechaContrato) {
        this.fechaContrato = fechaContrato;
    }

    public LinkedList<Prestamo> getPrestamosBibliotecario() {
        return prestamosBibliotecario;
    }

    public void setPrestamosBibliotecario(LinkedList<Prestamo> prestamosBibliotecario) {
        this.prestamosBibliotecario = prestamosBibliotecario;
    }

    public int getTiempoTrabajo() {
		return tiempoTrabajo;
	}


	public void setTiempoTrabajo(int tiempoTrabajo) {
		this.tiempoTrabajo = tiempoTrabajo;
	}

    public void agregarPrestamo(Prestamo prestamo){
        prestamosBibliotecario.add(prestamo);
    }


    /**
     * Método para calcular el salario del biblitoecario.
    */
    public double calcularSalario(){
        double salario = 0;
        for (Prestamo prestamo: prestamosBibliotecario){
            salario += (prestamo.calcularPrecioTotal() * 0.2);
        }
        salario += (((double)tiempoTrabajo * 2)/100) * salario;
        return salario;
    }

    public String verCantidadPrestamos(){
        return "Prestamos de " + nombre + ": " + prestamosBibliotecario.size();
    }
    

    /**
     * Método para calcular los años que ha trabajado el bibliotecario.
    */
    public int calcularTiempoTrabajo(){
        return ((int)ChronoUnit.YEARS.between(fechaContrato, LocalDate.now()));
    }

    @Override
    public String toString() {

        String cadena = "----Bibliotecario----  \nNombre:" + nombre + "\nCedula: " + cedula + "\nTelefono: " + telefono + "\nCorreo: " + correo + "\nPrestamos del bibliotecario: ";
        
        for(Prestamo prestamo: prestamosBibliotecario){
            cadena += "\n\t" + prestamo.getPrecio();
        }
        
        cadena += "\nFecha Contrato: " + fechaContrato + "\nSalario: "+ calcularSalario();
        return cadena;
    }





    

    
}
