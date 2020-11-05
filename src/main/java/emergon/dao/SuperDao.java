package emergon.dao;

import emergon.entity.Product;
import java.io.Serializable;
import java.util.List;
import javax.persistence.PersistenceException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class SuperDao<E> implements CrudInterfaceDao<E>{
    
    @Autowired
    private SessionFactory sessionFactory;

    Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    
    @Override
    public List<E> findAll(String namedQuery) {
        Query query = getSession().createNamedQuery(namedQuery);
        List<E> items = query.getResultList();
        return items;
    }
    
    public E findById(int id, String namedQuery) {
        Session session = getSession();
        Query q = session.createNamedQuery(namedQuery);
        q.setParameter("id", id);
        E c = (E) q.getSingleResult();
        return c;
    }
    
    @Override
    public Serializable add(E e) {
        Session session = getSession();
        Serializable identifier = session.save(e);
        return identifier;
    }
    
    @Override
    public void update(E e) {
        Session session = getSession();
        session.saveOrUpdate(e);
    }
    
    public String remove(int kwdikos, String namedQuery) {
        Session session = getSession();
        int indexOfPeriod = namedQuery.indexOf(".");
        String entity = namedQuery.substring(0, indexOfPeriod);
        Query q = session.createNamedQuery(namedQuery);
        q.setParameter("id", kwdikos);
        String message = entity+ " deleted successfully!!";
        try {
            q.executeUpdate();
        } catch (PersistenceException e) {
            message = entity+ " cannot be deleted";
        }
        return message;
    }

}
