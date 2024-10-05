package co.edu.uniquindio.poo;

public class Detalle {
    private Libro libro;
    private int cantidad;

    public Detalle(Libro libro, int cantidad) {
        this.libro = libro;
        this.cantidad = cantidad;
        assert cantidad >= 0;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public int getCantidad() {
        return cantidad;
    }


    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "----Detalle---- \nLibro: " + libro.getTitulo() + "\nCantidad: " + cantidad ;
    }

    
}
