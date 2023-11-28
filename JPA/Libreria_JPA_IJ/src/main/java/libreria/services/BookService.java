package libreria.services;

import libreria.entities.Book;
import libreria.persistence.BookDAO;

import java.util.List;
import java.util.Scanner;

public class BookService {

    private final BookDAO bdao;
    private final Scanner scanner;

    public BookService() {
        this.bdao = new BookDAO();
        this.scanner = new Scanner(System.in).useDelimiter("\n");
    }

    public Book createBook() {
        Book book = new Book();
        try {
            System.out.println("Ingrese ISBN del libro"); // Lo podría generar AUTO con el random de la clase UUID
            book.setIsbn(scanner.nextLong());
            System.out.println("Ingrese el título del libro");
            book.setTitle(scanner.next());
            System.out.println("Ingrese el año");
            book.setReleaseYear(scanner.nextInt());
            System.out.println("Ingrese la cantidad total de ejemplares");
            book.setCopies(scanner.nextInt());
            book.setCopiesRemaining(book.getCopies());
            bdao.saveBook(book);
            System.out.println("Libro guardado con éxito");
            return book;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Book getByISBN(Long isbn) {
        try {
            return bdao.getByISBN(isbn);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Book> getAllBooks() {
        try {
            List<Book> books = bdao.getAllBooks();
            return books;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void updateBook(Book updatedBook) {
        try {
            if (getByISBN(updatedBook.getIsbn()) == null) {
                throw new Exception("No se encontró el libro para actualizar");
            }
            bdao.updateBook(updatedBook);
            System.out.println("Libro actualizado correctamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    //    public void updateBook(Long isbn, Book updatedBook) {
//        try {
//            if(getByISBN(isbn) == null) {
//                throw new Exception("No se encontró libro con el isbn proporcionado");
//            }
//            Book book = getByISBN(isbn);
//            if(updatedBook.getIsbn() != book.getIsbn()) {
//                book.setIsbn(updatedBook.getIsbn());
//            }
//            if(!updatedBook.getTitle().equals(book.getTitle()) && !updatedBook.getTitle().trim().isEmpty()) {
//                book.setTitle(updatedBook.getTitle());
//            }
//            if(updatedBook.getReleaseYear() != book.getReleaseYear()) {
//                book.setReleaseYear(updatedBook.getReleaseYear());
//            }
//            if(updatedBook.getCopies() != book.getCopies()) {
//                book.setCopies(updatedBook.getCopies());
//            }
//            bdao.updateBook(book);
//            System.out.println("Libro actualizado correctamente");
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
    public List<Book> getByTitle(String title) {
        try {
            List<Book> books = bdao.getByTitle(title);
            return books;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Book> getByPublisher(String name) {
        try {
            List<Book> books = bdao.getByPublisherName(name);
            return books;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Book> getByAuthor(String name) {
        try {
            List<Book> books = bdao.getByAuthorName(name);
            return books;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void borrowBook(Book book, Integer amount) {
        try {
            if (getByISBN(book.getIsbn()) == null) {
                throw new Exception("El ejemplar que requiere no existe en la base de datos");
            }
            if (amount > book.getCopiesRemaining()) {
                throw new Exception("Cantidad solicitada no disponible. Disponibilidad actual = " + book.getCopiesRemaining());
            } else if (amount <= 0) {
                throw new Exception("La cantidad no puede ser 0 o inferior");
            }
            book.setBorrowedCopies(book.getBorrowedCopies() + amount);
            book.setCopiesRemaining(book.getCopiesRemaining() - amount);
            bdao.updateBook(book);
            System.out.println("Préstamo exitoso");
            System.out.println("Copias restantes = " + book.getCopiesRemaining());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void returnBook(Book book, Integer amount) {
        try {
            if (getByISBN(book.getIsbn()) == null) {
                throw new Exception("El ejemplar que quiere devolver no existe en la base de datos");
            }
            if (amount > book.getCopies()) {
                throw new Exception("Cantidad excede la totalidad de copias.");
            } else if (amount <= 0) {
                throw new Exception("La cantidad no puede ser 0 o inferior");
            } else if (amount > book.getBorrowedCopies()) {
                throw new Exception("La cantidad excede el número de ejemplares prestados: " + book.getBorrowedCopies());
            }
            book.setBorrowedCopies(book.getBorrowedCopies() - amount);
            book.setCopiesRemaining(book.getCopiesRemaining() + amount);
            bdao.updateBook(book);
            System.out.println("Devolución exitosa");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
