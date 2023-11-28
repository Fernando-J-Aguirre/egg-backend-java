package libreria.services;

import libreria.entities.Author;
import libreria.entities.Book;
import libreria.persistence.AuthorDAO;
import libreria.utils.BookManagerUtil;

import java.util.List;
import java.util.Scanner;

public class AuthorService {

    private final AuthorDAO adao;
    private final Scanner scanner;
    private final BookService bookService;
    private final BookManagerUtil<Author> bookManagerUtil;

    public AuthorService() {
        this.adao = new AuthorDAO();
        this.scanner = new Scanner(System.in).useDelimiter("\n");
        this.bookService = new BookService();
        this.bookManagerUtil = new BookManagerUtil<>();
    }

    public Author createAuthor() {
        Author author = new Author();
        try {
            System.out.println("Ingrese nombre del autor");
            author.setName(scanner.next());
            adao.saveAuthor(author);
            System.out.println("¿Desea cargarle ahora libros al autor? S/N");
            if (scanner.next().equalsIgnoreCase("s")) {
                System.out.println("Ingrese la cantidad de libros que quiere cargarle al autor: " + author.getName());
                int amount = scanner.nextInt();
                loadBooksToAuthor(author, amount);
            }
            System.out.println("Autor guardado con éxito");
            return author;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void loadBooksToAuthor(Author author, int amount) {
        try {
            List<Book> books = bookManagerUtil.loadBooksToList(author, author.getBooks(), amount);
            if (!books.isEmpty()) {
                author.setBooks(books);
                adao.updateAuthor(author);
                System.out.println("Se han cargado exitosamente los libros al autor " + author.getName());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeBookFromAuthor(Author author) {
        try {
            int size = author.getBooks().size();
            List<Book> books = bookManagerUtil.removeBookFrom(author, author.getBooks());
            if (books != null && books.size() < size) {
                author.setBooks(books);
                adao.updateAuthor(author);
                System.out.println("Libro removido exitosamente");
            } else {
                System.out.println("No se pudo remover el/los libro/s");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Author getAuthorById(Integer id) {
        try {
            Author author = adao.getById(id);
            return author;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Author> getAllAuthors() {
        try {
            List<Author> authors = adao.getAllAuthors();
            return authors;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void updateAuthor(Author updatedAuthor) {
        try {
            if (getAuthorById(updatedAuthor.getId()) == null) {
                throw new Exception("No se encontró autor para actualizar");
            }
            adao.updateAuthor(updatedAuthor);
            System.out.println("Autor actualizado con éxito");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
