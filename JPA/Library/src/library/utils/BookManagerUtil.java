package library.utils;

import java.util.List;
import java.util.Scanner;
import library.entities.Book;
import library.services.BookService;

public class BookManagerUtil<T> {

    private final BookService bookService;
    private final Scanner scanner;

    public BookManagerUtil() {
        bookService = new BookService();
        scanner = new Scanner(System.in).useDelimiter("\n");
    }

    public List<Book> loadBooksToList(T obj, List<Book> books, int amount) {
        try {
            for (int i = 0; i < amount; i++) {
                System.out.println("¿Desea cargar nuevos libros o buscar en la base de datos? (C)argar/(B)uscar");
                String option = scanner.next();

                if (option.equalsIgnoreCase("c")) {
                    Book book = bookService.createBook();
                    if (!isBookInList(obj, books, book)) {
                        books.add(book);
                    }
                } else if (option.equalsIgnoreCase("b")) {
                    System.out.println("¿Desea buscar por ISBN o título? (I)SBN/(T)ítulo");
                    String searchOption = scanner.next();

                    if (searchOption.equalsIgnoreCase("i")) {
                        System.out.println("Ingrese el ISBN del libro");
                        Book book = bookService.getByISBN(scanner.nextLong());
                        if (book != null && !isBookInList(obj, books, book)) {
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
                                if (!isBookInList(obj, books, book)) {
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
            return books;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private boolean isBookInList(T obj, List<Book> books, Book book) {
        for (Book book1 : books) {
            if (book.getIsbn() == book1.getIsbn()) {
                return true;
            }
        }
        return false;
    }

    public List<Book> removeBookFrom(T obj, List<Book> books) {
        try {
            if (!books.isEmpty()) {
                System.out.println("Lista de libros encontrada");
                for (int i = 0; i < books.size(); i++) {
                    System.out.println((i + 1) + "- " + books.get(i));
                }
                System.out.println("Seleccione el número del listado que quiere remover");
                int select = scanner.nextInt();

                if (select > 0 && select <= books.size()) {
                    books.remove(select - 1);
                }
                return books;
            } else {
                System.out.println("No existen libros relacionados para remover");
                return null;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    
    
    
    
    
    
    
    
    
    //    public void loadBooksToAuthor(Author author, int amount) {
//        try {
//            List<Book> books = author.getBooks();
//            for (int i = 0; i < amount; i++) {
//                System.out.println("¿Desea cargar nuevos libros o buscar en la base de datos? (C)argar/(B)uscar");
//                String option = scanner.next();
//
//                if (option.equalsIgnoreCase("c")) {
//                    Book book = bookService.createBook();
//                    if (!isBookInAuthorList(author, book)) {
//                        books.add(book);
//                    }
//                } else if (option.equalsIgnoreCase("b")) {
//                    System.out.println("¿Desea buscar por ISBN o título? (I)SBN/(T)ítulo");
//                    String searchOption = scanner.next();
//
//                    if (searchOption.equalsIgnoreCase("i")) {
//                        System.out.println("Ingrese el ISBN del libro");
//                        Book book = bookService.getByISBN(scanner.nextLong());
//                        if (book != null && !isBookInAuthorList(author, book)) {
//                            books.add(book);
//                        }
//                    } else if (searchOption.equalsIgnoreCase("t")) {
//                        System.out.println("Ingrese el título del libro");
//                        String title = scanner.next();
//
//                        List<Book> matchingBooks = bookService.getByTitle(title);
//                        if (!matchingBooks.isEmpty()) {
//                            System.out.println("Libros encontrados:");
//                            for (int j = 0; j < matchingBooks.size(); j++) {
//                                System.out.println((j + 1) + "- " + matchingBooks.get(j));
//                            }
//
//                            System.out.println("Ingrese el número del libro que quiere agregar");
//                            int select = scanner.nextInt();
//
//                            if (select > 0 && select <= matchingBooks.size()) {
//                                Book book = matchingBooks.get(select - 1);
//                                if (!isBookInAuthorList(author, book)) {
//                                    books.add(book);
//                                }
//                            }
//                        } else {
//                            System.out.println("No se encontraron libros con ese título");
//                        }
//                    } else {
//                        System.out.println("Opción inválida. Debe ingresar 'I' o 'T')");
//                    }
//                } else {
//                    System.out.println("Opción inválida. Debe ingresar 'C' o 'B')");
//                }
//            }
//            author.setBooks(books);
//            adao.updateAuthor(author);
//            System.out.println("Se han cargado exitosamente los libros al autor " + author.getName());
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
//
//    private boolean isBookInAuthorList(Author author, Book book) {
//        List<Book> books = author.getBooks();
//        for (Book book1 : books) {
//            if (book.getIsbn() == book1.getIsbn()) {
//                return true;
//            }
//        }
//        return false;
//    }
//    public void removeBookFromAuthor(Author author) {
//        List<Book> books = author.getBooks();
//        try {
//            if (!books.isEmpty()) {
//                System.out.println("Lista de libros del autor: " + author.getName());
//                for (int i = 0; i < books.size(); i++) {
//                    System.out.println((i + 1) + "- " + books.get(i));
//                }
//                System.out.println("Seleccione el número del listado que quiere remover");
//                int select = scanner.nextInt();
//
//                if (select > 0 && select <= books.size()) {
//                    books.remove(select - 1);
//                }
//                author.setBooks(books);
//                adao.updateAuthor(author);
//                System.out.println("Libro removido exitosamente");
//            } else {
//                System.out.println("El autor aún no tiene libros relacionados");
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }

}
