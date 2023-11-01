package library.persistence;

import java.util.List;
import library.entities.Publisher;

public class PublisherDAO extends DAO<Publisher> {
    
    public void savePublisher(Publisher publisher) {
        super.insert(publisher);
    }
    
    public void updatePublisher(Publisher publisher) {
        super.update(publisher);
    }
    
    public Publisher getById(Integer id) {
        super.connect();
        Publisher publisher = em.find(Publisher.class, id);
        super.disconnect();
        return publisher;
    }
    
    public List<Publisher> getAllPublishers() {
        super.connect();
        List<Publisher> publishers = em.createQuery("SELECT a FROM Publisher a").getResultList();
        super.disconnect();
        return publishers;
    }
    
}
