package library.services;

import java.util.List;
import java.util.Scanner;
import library.entities.Author;
import library.entities.Book;
import library.persistence.AuthorDAO;

public class AuthorService {

    private final AuthorDAO adao;
    private final Scanner scanner;
    private final BookService bookService;

    public AuthorService() {
        this.adao = new AuthorDAO();
        this.scanner = new Scanner(System.in).useDelimiter("\n");
        this.bookService = new BookService();
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
            List<Book> books = author.getBooks();
            for (int i = 0; i < amount; i++) {
                System.out.println("¿Desea cargar nuevos libros o buscar en la base de datos? (C)argar/(B)uscar");
                String option = scanner.next();

                if (option.equalsIgnoreCase("c")) {
                    Book book = bookService.createBook();
                    if (!isBookInAuthorList(author, book)) {
                        books.add(book);
                    }
                } else if (option.equalsIgnoreCase("b")) {
                    System.out.println("¿Desea buscar por ISBN o título? (I)SBN/(T)ítulo");
                    String searchOption = scanner.next();

                    if (searchOption.equalsIgnoreCase("i")) {
                        System.out.println("Ingrese el ISBN del libro");
                        Book book = bookService.getByISBN(scanner.nextLong());
                        if (book != null && !isBookInAuthorList(author, book)) {
                            books.add(book);
                        }
                    } else if (searchOption.equalsIgnoreCase("t")) {
                        System.out.println("Ingrese el título del libro");
                        String title = scanner.next();

                        List<Book> matchingBooks = bookService.getByTitle(title);
                        if (!matchingBooks.isEmpty()) {
                            System.out.println("Libros encontrados:");
                            for (int j = 0; j < matchingBooks.size(); j++) {
                                System.out.println((j + 1) + "- " + matchingBooks.get(j));
                            }

                            System.out.println("Ingrese el número del libro que quiere agregar");
                            int select = scanner.nextInt();

                            if (select > 0 && select <= matchingBooks.size()) {
                                Book book = matchingBooks.get(select - 1);
                                if (!isBookInAuthorList(author, book)) {
                                    books.add(book);
                                }
                            }
                        } else {
                            System.out.println("No se encontraron libros con ese título");
                        }
                    } else {
                        System.out.println("Opción inválida. Debe ingresar 'I' o 'T')");
                    }
                } else {
                    System.out.println("Opción inválida. Debe ingresar 'C' o 'B')");
                }
            }
            author.setBooks(books);
            adao.updateAuthor(author);
            System.out.println("Se han cargado exitosamente los libros al autor " + author.getName());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean isBookInAuthorList(Author author, Book book) {
        List<Book> books = author.getBooks();
        for (Book book1 : books) {
            if (book.getIsbn() == book1.getIsbn()) {
                return true;
            }
        }
        return false;
    }

    public void removeBookFromAuthor(Author author) {
        List<Book> books = author.getBooks();
        try {
            if (!books.isEmpty()) {
                System.out.println("Lista de libros del autor: " + author.getName());
                for (int i = 0; i < books.size(); i++) {
                    System.out.println((i + 1) + "- " + books.get(i));
                }
                System.out.println("Seleccione el número del listado que quiere remover");
                int select = scanner.nextInt();

                if (select > 0 && select <= books.size()) {
                    books.remove(select - 1);
                }
                author.setBooks(books);
                adao.updateAuthor(author);
                System.out.println("Libro removido exitosamente");
            } else {
                System.out.println("El autor aún no tiene libros relacionados");
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

//    public void updateAuthor(Integer id, Author updatedAuthor) {
//        try {
//            if (getAuthorById(id) == null) {
//                throw new Exception("No se encontró autor con ese id");
//            }
//            Author author = getAuthorById(id);
//            if (!author.getName().equals(updatedAuthor.getName()) && !updatedAuthor.getName().trim().isEmpty()) {
//                author.setName(updatedAuthor.getName());
//            }
//            if (!updatedAuthor.getBooks().isEmpty()) {
//                author.setBooks(updatedAuthor.getBooks());
//            }
//            adao.updateAuthor(author);
//            System.out.println("Autor actualizado con éxito");
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
}
