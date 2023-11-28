package libreria;


import libreria.services.AuthorService;
import libreria.services.BookService;
import libreria.services.PublisherService;

public class Libreria {

    public static void main(String[] args) {
        BookService bookService = new BookService();
        AuthorService authorService = new AuthorService();
        PublisherService publisherService = new PublisherService();


        //BOOK

//        bookService.createBook();
//        Book book = bookService.getByISBN(123L);
//        bookService.borrowBook(book, 11);
//        bookService.returnBook(book, 1);
//        book.setTitle("Libro Modificado");
//        bookService.updateBook(book);
//        List<Book> books = bookService.getByTitle("libro mod");
//        System.out.println(books);


        //Author

//        authorService.createAuthor();
//        Author author = authorService.getAuthorById(1);
//        authorService.loadBooksToAuthor(author, 1);
//        System.out.println(author);
//        System.out.println();
//        authorService.removeBookFromAuthor(author);
//        System.out.println();
//        System.out.println(author);


        //Publisher

//        publisherService.createPublisher();
//        Publisher publisher = publisherService.getById(5);
//        System.out.println(publisher);
//        publisherService.loadBooksToPublisher(publisher, 1);



    }
}
