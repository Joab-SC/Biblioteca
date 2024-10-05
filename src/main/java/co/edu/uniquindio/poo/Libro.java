package co.edu.uniquindio.poo;
import java.time.LocalDate;

public class Libro {
    private String codigo;
    private String isbn;
    private Autor autor;
    private String titulo;
    private Editorial editorial;
    private LocalDate fecha;
    private int unidadesDisponibles;


    public Libro(String codigo, String isbn, Autor autor, String titulo, Editorial editorial, LocalDate fecha,
            int unidadesDisponibles) {
        this.codigo = codigo;
        this.isbn = isbn;
        this.autor = autor;
        this.titulo = titulo;
        this.editorial = editorial;
        this.fecha = fecha;
        this.unidadesDisponibles = unidadesDisponibles;

        assert !codigo.isBlank();
        assert !isbn.isBlank();
        assert !titulo.isBlank();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getUnidadesDisponibles() {
        return unidadesDisponibles;
    }

    public void setUnidadesDisponibles(int unidadesDisponibles) {
        this.unidadesDisponibles = unidadesDisponibles;
    }


    @Override
    public String toString() {
        return "----Libro---- \nCódigo: " + codigo + "\nIsbn:" + isbn + "\nAutor: " + autor.getNombre() + "\nTítulo: " + titulo + "\nEditorial: " + editorial.getNombre() + "\nFecha: " + fecha + "\nUnidades Disponibles: " + unidadesDisponibles;
    }

}
