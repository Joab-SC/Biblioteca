package co.edu.uniquindio.poo;
import java.time.LocalDate;
import java.util.LinkedList;

public class Autor extends Persona
{
    private String genero;
    private String premios;
    private LocalDate fechaNacimiento;
    private LinkedList<Libro> librosEscritos;

    public Autor(String nombre, String cedula, String telefono, String correo, String genero, String premios, LocalDate fechaNacimento){
        super(nombre, cedula, telefono, correo);
        this.genero = genero;
        this.premios = premios;
        this.fechaNacimiento = fechaNacimento;
        this.librosEscritos = new LinkedList<>();
        assert !nombre.isBlank();
        assert !cedula.isBlank();
        assert !telefono.isBlank();
        assert !correo.isBlank();
        assert !genero.isBlank();
        assert !premios.isBlank();
        assert correo.contains("@");
        assert telefono.matches("^[+()\\d\\s-]+$");
    }


    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPremios() {
        return premios;
    }

    public void setPremios(String premios) {
        this.premios = premios;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LinkedList<Libro> getLibrosEscritos() {
        return librosEscritos;
    }

    public void setLibrosEscritos(LinkedList<Libro> librosEscritos) {
        this.librosEscritos = librosEscritos;
    }

    public void agregarLibro(Libro libro){
        librosEscritos.add(libro);
    }



    @Override
    public String toString() {
        String cadena =  "----Autor----\nNombre: " + nombre + "\nCedula: " + cedula + "\nTeléfono: " + telefono + "\nCorreo: " + correo + "\nGenero: " + genero + "\nPremios:" + premios + "\nFechaNacimiento: " + fechaNacimiento + "\nLibros:";

        for (Libro libro: librosEscritos){
            cadena += "\n\t" + libro.getTitulo();
        }
        return cadena;
    }

    


}
