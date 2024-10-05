package co.edu.uniquindio.poo;

import java.util.LinkedList;

public class Biblioteca {
    private String nombre;
    private LinkedList<Bibliotecario> bibliotecarios;
    private LinkedList<Estudiante> estudiantes;
    private LinkedList<Prestamo> prestamos;
    private LinkedList<Libro> libros;

    public Biblioteca(String nombre) {
        this.nombre = nombre;
        this.bibliotecarios = new LinkedList<>();
        this.estudiantes = new LinkedList<>();
        this.prestamos = new LinkedList<>();
        this.libros = new LinkedList<>();

        assert !nombre.isBlank();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LinkedList<Bibliotecario> getBibliotecarios() {
        return bibliotecarios;
    }

    public void setBibliotecarios(LinkedList<Bibliotecario> bibliotecarios) {
        this.bibliotecarios = bibliotecarios;
    }

    public LinkedList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(LinkedList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public LinkedList<Prestamo> getPrestamos() {
        return prestamos;
    }

    public void setPrestamos(LinkedList<Prestamo> prestamos) {
        this.prestamos = prestamos;
    }

    public LinkedList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(LinkedList<Libro> libros) {
        this.libros = libros;
    }

    public void agregarBibliotecario(Bibliotecario bibliotecario){
        bibliotecarios.add(bibliotecario);
    }


    public void agregarEstudiante(Estudiante estudiante){
        estudiantes.add(estudiante);
    }

    
    public void agregarLibro(Libro libro){
        libros.add(libro);
    }


    public void agregarPrestamo(Prestamo prestamo){
        prestamos.add(prestamo);
    }

    /**
     * Método para obtener la cantidad de préstamos a que pertenece un libro dado su nombre.
    */
    public int obtenerCantidadPrestamosLibro(String titulo){
        int cantidadPrestamosLibro = 0;

        for (Prestamo prestamo: prestamos){
            for(Detalle detalle: prestamo.getDetalles()){
                if(detalle.getLibro().getTitulo().equals(titulo)){
                    cantidadPrestamosLibro += 1;
                    break;
                }
            }
        }
        return cantidadPrestamosLibro;
    }


    /**
     * Método para obtener el estudiante con más préstamos.
    */
    public Estudiante obtenerEstudianteMasPrestamos(){
        Estudiante estudianteMasPrestamos = estudiantes.get(0);
        int cantidadPrestamosEstudianteMasPrestamos = estudiantes.get(0).getPrestamos().size();

        for(Estudiante estudiante: estudiantes){
            if (estudiante.getPrestamos().size() > cantidadPrestamosEstudianteMasPrestamos){
                estudianteMasPrestamos = estudiante;
                cantidadPrestamosEstudianteMasPrestamos = estudiante.getPrestamos().size();
            }
        }
        return estudianteMasPrestamos;
    }


    /**
     * Método obtener la cantidad de préstamos de todos los bibliotecarios.
    */
    public String obtenerCantidadPrestamosBibliotecarios(){
        String cadena = "--Cantidad de prestamos por cada bibliotecario--";
        for (Bibliotecario bibliotecario: bibliotecarios){
            cadena += "\n" + bibliotecario.verCantidadPrestamos();
        }
        return cadena;
    }


    /**
     * Método obtener todos los salarios de los bibliotecarios.
    */
    public String obtenerSalariosBibliotecarios(){
        String cadena = "--Salarios de los bibliotecarios--";
        for(Bibliotecario bibliotecario: bibliotecarios){
            cadena += "\n" + bibliotecario.getNombre() + ": " + bibliotecario.calcularSalario();
        }
        return cadena;
    }


    public static  void mostrarMensaje(String mensaje){
        System.out.println(mensaje);
    }



    @Override
    public String toString() {
        String cadena = "----Biblioteca---- \nNombre: " + nombre + "\nBibliotecarios: ";

        for(Bibliotecario bibliotecario: bibliotecarios){
            cadena += "\n\t" + bibliotecario.getNombre();
        }

        cadena += "\nEstudiantes: ";

        for(Estudiante estudiante: estudiantes){
            cadena += "\n\t" + estudiante.getNombre();
        }

        cadena += "\nPrestamos: ";
 
        for(Prestamo prestamo: prestamos){
            cadena += "\n\t" + prestamo.getPrecioDia() + " por " + prestamo.getDiasPrestamo() + " días";
        }

        cadena += "\nLibros: ";

        for(Libro libro: libros){
            cadena += "\n\t" + libro.getTitulo();
        }

        return cadena;
    }

    
}
