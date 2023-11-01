package library.persistence;

import java.util.List;
import library.entities.Author;

public class AuthorDAO extends DAO<Author> {

    public void saveAuthor(Author author) {
        super.insert(author);
    }

    public void updateAuthor(Author author) {
        super.update(author);
    }

    public Author getById(Integer id) {
        super.connect();
        Author author = em.find(Author.class, id);
        super.disconnect();
        return author;
    }

    public List<Author> getAllAuthors() {
        super.connect();
        List<Author> authors = em.createQuery("SELECT a FROM Author a").getResultList();
        super.disconnect();
        return authors;
    }

    
}
