package co.edu.uniquindio.poo;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;

public class Prestamo {
    private double precio;
    private LocalDate fechaPrestamo;
    private LocalDate fechaDevolucion;
    private LinkedList<Detalle> detalles;
    private double precioDia;
    private Estudiante estudiante;
    private Bibliotecario bibliotecario;
    private int diasPrestamo;
    

    
    public Prestamo(double precio, LocalDate fechaPrestamo, LocalDate fechaDevolucion, Estudiante estudiante, Bibliotecario bibliotecario) {
        this.precio = precio;
        this.fechaPrestamo = fechaPrestamo;
        this.fechaDevolucion = fechaDevolucion;
        this.detalles = new LinkedList<>();
        this.estudiante = estudiante;
        this.bibliotecario = bibliotecario;
        this.diasPrestamo = calcularDiasPrestamo();
        this.precioDia = 0;
        assert precio >= 0;
        assert diasPrestamo >= 0;
    }

    public int getDiasPrestamo() {
        return diasPrestamo;
    }



    public void setDiasPrestamo(int diasPrestamo) {
        this.diasPrestamo = diasPrestamo;
    }
    
    

    public Estudiante getEstudiante() {
        return estudiante;
    }



    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }



    public Bibliotecario getBibliotecario() {
        return bibliotecario;
    }



    public void setBibliotecario(Bibliotecario bibliotecario) {
        this.bibliotecario = bibliotecario;
    }



    public double getPrecio() {
        return precio;
    }



    public void setPrecio(double precio) {
        this.precio = precio;
    }



    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }



    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }



    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }



    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }



    public LinkedList<Detalle> getDetalles() {
        return detalles;
    }



    public void setDetalles(LinkedList<Detalle> detalles) {
        this.detalles = detalles;
    }



    public double getPrecioDia() {
        return precioDia;
    }



    public void setPrecioDia(double precioDia) {
        this.precioDia = precioDia;
    }


    /**
     * Método para agregar un detalle al préstamo y actualizar la tarifa del día.
     * 
     * Si el libro ya existe en los detalles, se suma la cantidad en lugar de
     * agregar un nuevo detalle. La cantidad disponible del libro se ajusta con la cantidad de libros en el detalle.
     * 
     * Si no hay suficientes unidades disponibles, se muestra un mensaje de error
     * y no se realizan cambios en el libro ni en el préstamo.
     */
    public void agregarDetalle(Detalle miDetalle){
        int cantidadDetalleRepetido = 0;
        Integer indiceDetalleRepetido = null;
        for (Detalle detalle :detalles){
            if (detalle.getLibro().equals(miDetalle.getLibro())){
                cantidadDetalleRepetido = (detalle.getCantidad() + miDetalle.getCantidad());
                indiceDetalleRepetido = detalles.indexOf(detalle);
            }
        }

        if (miDetalle.getCantidad() <= miDetalle.getLibro().getUnidadesDisponibles()){
            miDetalle.getLibro().setUnidadesDisponibles(miDetalle.getLibro().getUnidadesDisponibles() - miDetalle.getCantidad());
            if (indiceDetalleRepetido != null){
                miDetalle.setCantidad(cantidadDetalleRepetido);
                detalles.set(indiceDetalleRepetido, miDetalle);
            }

            else{
                detalles.add(miDetalle);
                precioDia += precio;
            }
        }

        else{
            Biblioteca.mostrarMensaje("Error, no hay suficiente unidades disponibles del libro " + miDetalle.getLibro().getTitulo());
        }
    }

    /**
     * Método para calcular el precio total del préstamo.
    */
    public double calcularPrecioTotal(){
        return diasPrestamo * precioDia;
    }
    
    /**
     * Método para calcular los días que durará el prestamo.
    */
    public int calcularDiasPrestamo(){
        return (int)ChronoUnit.DAYS.between(fechaPrestamo, fechaDevolucion);
    }

    @Override
    public String toString() {
        return "----Prestamo---- \nPrecio: " + precio + "\nFecha Prestamo: " + fechaPrestamo + "\nFecha Devolucion: "
                + fechaDevolucion +  "\nDetalles:\n " + detalles + "\n\nPrecio Día: "
                + precioDia + "\nPrecio Total: " + calcularPrecioTotal();
    }

   
    
}
