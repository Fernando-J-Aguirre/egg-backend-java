package libreria.services;

import libreria.entities.Book;
import libreria.entities.Publisher;
import libreria.persistence.PublisherDAO;
import libreria.utils.BookManagerUtil;

import java.util.List;
import java.util.Scanner;

public class PublisherService {

    private final PublisherDAO pdao;
    private final Scanner scanner;
    private final BookService bs;
    private final BookManagerUtil<Publisher> bookManagerUtil;

    public PublisherService() {
        pdao = new PublisherDAO();
        scanner = new Scanner(System.in).useDelimiter("\n");
        bs = new BookService();
        bookManagerUtil = new BookManagerUtil<>();
    }

    public Publisher createPublisher() {
        Publisher publisher = new Publisher();
        try {
            System.out.println("Ingrese nombre de la editorial");
            publisher.setName(scanner.next());
            pdao.savePublisher(publisher);
            System.out.println("¿Desea cargarle ahora libros a la editorial? S/N");
            if (scanner.next().equalsIgnoreCase("s")) {
                System.out.println("Ingrese la cantidad de libros que quiere cargarle a la editorial: " + publisher.getName());
                int amount = scanner.nextInt();
                loadBooksToPublisher(publisher, amount);
            }
            System.out.println("Editorial guardada con éxito");
            return publisher;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void loadBooksToPublisher(Publisher publisher, int amount) {
        try {
            List<Book> books = bookManagerUtil.loadBooksToList(publisher, publisher.getBooks(), amount);
            if (!books.isEmpty()) {
                publisher.setBooks(books);
                pdao.updatePublisher(publisher);
                System.out.println("Se han cargado exitosamente los libros a la editorial: " + publisher.getName());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void removeBookFromAuthor(Publisher publisher) {
        try {
            int size = publisher.getBooks().size();
            List<Book> books = bookManagerUtil.removeBookFrom(publisher, publisher.getBooks());
            if (books != null && books.size() < size) {
                publisher.setBooks(books);
                pdao.updatePublisher(publisher);
                System.out.println("Libro removido exitosamente");
            } else {
                System.out.println("No se pudo remover el/los libro/s");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Publisher getById(Integer id) {
        try {
            Publisher publisher = pdao.getById(id);
            return publisher;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Publisher> getAllPublishers() {
        try {
            List<Publisher> publishers = pdao.getAllPublishers();
            return publishers;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void update(Publisher updatedPublisher) {
        try {
            if (getById(updatedPublisher.getId()) == null) {
                throw new Exception("No se encontró editorial para actualizar");
            }
            pdao.updatePublisher(updatedPublisher);
            System.out.println("Editorial actualizada con éxito");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
