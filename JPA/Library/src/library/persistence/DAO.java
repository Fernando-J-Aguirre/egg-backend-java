package library.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DAO<T> {

    protected final EntityManagerFactory emf = Persistence.createEntityManagerFactory("LibraryPU");
    protected EntityManager em = emf.createEntityManager();

    protected void connect() {
        if (!em.isOpen()) {
            em = emf.createEntityManager();
        }
    }

    protected void disconnect() {
        if (em.isOpen()) {
            em.close();
        }
    }

    protected void insert(T object) {
        connect();
        em.getTransaction().begin();
        em.persist(object);
        em.getTransaction().commit();
        disconnect();
    }

    protected void update(T object) {
        connect();
        em.getTransaction().begin();
        em.merge(object);
        em.getTransaction().commit();
        disconnect();
    }

    protected void delete(T object) {
        connect();
        em.getTransaction().begin();
        em.remove(object);
        em.getTransaction().commit();
        disconnect();
    }
    
    

}
