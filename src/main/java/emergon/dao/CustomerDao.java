package emergon.dao;

import emergon.entity.Customer;
import java.util.List;
import org.hibernate.Session;//this is the equivalent of EntityManager
import org.hibernate.SessionFactory;//this is the equivalent of EntityManagerFactory
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {
    
    @Autowired
    private SessionFactory sessionFactory;
    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    
    public List<Customer> findAll(){
        Query<Customer> query = getSession().createQuery("SELECT c FROM Customer c", Customer.class);
        List<Customer> customers = query.getResultList();
        return customers;
    }
    
    
}
