package library.services;

import java.util.List;
import java.util.Scanner;
import library.entities.Publisher;
import library.entities.Book;
import library.persistence.PublisherDAO;

public class PublisherService {

    private final PublisherDAO pdao;
    private final Scanner scanner;
    private final BookService bs;

    public PublisherService() {
        pdao = new PublisherDAO();
        scanner = new Scanner(System.in).useDelimiter("\n");
        bs = new BookService();
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
        List<Book> books = publisher.getBooks();
        for (int i = 0; i < amount; i++) {
            Book book = bs.createBook();
            if (!books.contains(book)) {
                books.add(book);
            }
        }
        publisher.setBooks(books);
        try {
            pdao.updatePublisher(publisher);
            System.out.println("Se han cargado exitosamente los libros a la editorial " + publisher.getName());
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
    
//    public void update(Integer id, Publisher updatedPublisher) {
//        try {
//            if (getById(id) == null) {
//                throw new Exception("No se encontró editorial con ese id");
//            }
//            Publisher publisher = getById(id);
//            if (!updatedPublisher.getName().equals(publisher.getName()) && !updatedPublisher.getName().trim().isEmpty()) {
//                publisher.setName(updatedPublisher.getName());
//            }
//            if (!updatedPublisher.getBooks().isEmpty()) {
//                publisher.setBooks(updatedPublisher.getBooks());
//            }
//            pdao.updatePublisher(publisher);
//            System.out.println("Editorial actualizada con éxito");
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }

}
