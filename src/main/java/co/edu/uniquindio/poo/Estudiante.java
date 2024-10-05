package co.edu.uniquindio.poo;

import java.util.LinkedList;

public class Estudiante extends Persona {

    private LinkedList<Prestamo> prestamos;

    public Estudiante(String nombre, String cedula, String telefono, String correo) {
        super(nombre, cedula, telefono, correo);
        this.prestamos = new LinkedList<>();
        assert !nombre.isBlank();
        assert !cedula.isBlank();
        assert !telefono.isBlank();
        assert !correo.isBlank();
        assert correo.contains("@");
        assert telefono.matches("^[+()\\d\\s-]+$");
    }

    public LinkedList<Prestamo> getPrestamos() {
        return prestamos;
    }


    public void setPrestamos(LinkedList<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }
    

    public void agregarPrestamo(Prestamo prestamo) {
        prestamos.add(prestamo);
    }

    @Override
    public String toString() {
        String cadena = "----Estudiante---- \nNombre: " + nombre + "\nCedula: " + cedula + "\nTeléfono: " + telefono
                + "\nCorreo: " + correo;

        cadena += "\nPrestamos: ";

        for (Prestamo prestamo : prestamos) {
            cadena += "\n\t" + prestamo.toString();
        }

        return cadena;

    }


    

}
