package biblioteca;

public class Libro {

    private String isbn;
    private String titulo;
    private String autor;
    private int cantPags;

    public Libro() {
    }
    
    public Libro(String isbn, String titulo, String autor, int cantPags) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.autor = autor;
        this.cantPags = cantPags;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCantPags() {
        return cantPags;
    }

    public void setCantPags(int cantPags) {
        this.cantPags = cantPags;
    }

    @Override
    public String toString() {
        return "Libro { " + " isbn = " + isbn + ", titulo = " + titulo + ", autor = " + autor + ", cantPags = " + cantPags + '}';
    }

    
}
