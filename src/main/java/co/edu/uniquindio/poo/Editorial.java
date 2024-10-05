package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.util.LinkedList;

public class Editorial {
    private String nombre;
    private LocalDate fechaFundacion;
    private String direccion;
    private String telefono;
    private String sitioWeb;
    private LinkedList<Libro> librosEditorial;

    public Editorial(String nombre, LocalDate fechaFundacion, String direccion, String telefono, String sitioWeb) {
        this.nombre = nombre;
        this.fechaFundacion = fechaFundacion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.sitioWeb = sitioWeb;
        this.librosEditorial = new LinkedList<>();
        assert telefono.matches("^[+()\\d\\s-]+$");
        assert !nombre.isBlank();
        assert !direccion.isBlank();
        assert !telefono.isBlank();
        assert !sitioWeb.isBlank();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaFundacion() {
        return fechaFundacion;
    }

    public void setFechaFundacion(LocalDate fechaFundacion) {
        this.fechaFundacion = fechaFundacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSitioWeb() {
        return sitioWeb;
    }

    public void setSitioWeb(String sitioWeb) {
        this.sitioWeb = sitioWeb;
    }

    public LinkedList<Libro> getLibrosEditorial() {
        return librosEditorial;
    }

    public void setLibrosEditorial(LinkedList<Libro> librosEditorial) {
        this.librosEditorial = librosEditorial;
    }

    public void agregarLibro(Libro libro) {
        librosEditorial.add(libro);
    }

    @Override
    public String toString() {
        String cadena = "----Editorial---- \nNombre:" + nombre + "\nFecha Fundación: " + fechaFundacion
                + "\nDirección: " + direccion
                + "\nTelefono: " + telefono + "\nSitioWeb: " + sitioWeb;

        cadena += "\nLibros: ";

        for (Libro libro : librosEditorial) {
            cadena += "\n\t" + libro.getTitulo();
        }

        return cadena;
    }

}
