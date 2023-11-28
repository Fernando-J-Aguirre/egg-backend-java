package libreria.persistence;

import libreria.entities.Book;

import java.util.List;

public class BookDAO extends DAO<Book> {

    public void saveBook(Book book) {
        super.insert(book);
    }
    public void updateBook(Book book) {
        super.update(book);
    }
    public Book getByISBN(Long isbn) {
        super.connect();
        Book book = em.find(Book.class, isbn);
        super.disconnect();
        return book;
    }
    public List<Book> getAllBooks() {
        super.connect();
        List<Book> books = em.createQuery("SELECT a FROM Book a").getResultList();
        super.disconnect();
        return books;
    }
    public void deleteBook(Long isbn) {
        Book book = getByISBN(isbn);
        super.delete(book);
    }
    public List<Book> getByTitle(String title) {
        super.connect();
        List<Book> books = em.createQuery("SELECT a FROM Book a WHERE a.title LIKE :title AND a.alta = true").setParameter("title", "%" + title + "%").getResultList();
        super.disconnect();
        return books;
    }
    public List<Book> getByAuthorName(String name) {
        super.connect();
        List<Book> books = em.createQuery("SELECT a FROM Author a WHERE a.name LIKE :name AND a.books.alta = true").setParameter("name", "%" + name + "%").getResultList();
        super.disconnect();
        return books;
    }
    public List<Book> getByPublisherName(String name) {
        super.connect();
        List<Book> books = em.createQuery("SELECT a FROM Publisher a WHERE a.name LIKE :name AND a.books.alta = true").setParameter("name", "%" + name + "%").getResultList();
        super.disconnect();
        return books;
    }
}
