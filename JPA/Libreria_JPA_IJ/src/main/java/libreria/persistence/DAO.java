package libreria.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class DAO<T> {

    protected final EntityManagerFactory emf;
    protected EntityManager em;
    public DAO() {
        emf = Persistence.createEntityManagerFactory("libreria");
        em = emf.createEntityManager();
    }

    public void connect() {
        if(!em.isOpen()) {
            em = emf.createEntityManager();
        }
    }

    public void disconnect() {
        if(em.isOpen()) {
            em.close();
        }
    }

    public void insert(T obj) {
        connect();
        em.getTransaction().begin();
        em.persist(obj);
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
