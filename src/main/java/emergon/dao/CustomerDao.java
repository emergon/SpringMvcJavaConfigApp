package emergon.dao;

import emergon.entity.Customer;
import java.io.Serializable;
import java.util.List;
import javax.persistence.PersistenceException;
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
    
    public Serializable addCustomer(Customer customer){
        Session session = getSession();//This is equivalent to EntityManager
        Serializable identifier = session.save(customer);
        System.out.println("identifier:"+identifier);
        return identifier;
    }
    
    public String removeCustomer(int kwdikos){
        //boolean deleted = false;
        Session session = getSession();
        Query q = session.createQuery("Delete from Customer c where c.ccode = :id");
        q.setParameter("id", kwdikos);
        String message = "Customer deleted successfully!!";
        try{
            int result = q.executeUpdate();
            //deleted = true;
        }catch(PersistenceException e){
            System.out.println("Customer cannot be deleted..............");
            message = "Customer cannot be deleted";
        }
        return message;
    }
    
    public void updateCustomer(Customer customer){
        Session session = getSession();
        session.saveOrUpdate(customer);
        System.out.println("Customer updated ----------------------------");
    }

    public Customer findById(int id) {
        Session session = getSession();
        String queryString = "SELECT c FROM Customer c WHERE c.ccode = :id";
        Query q = session.createQuery(queryString, Customer.class);
        q.setParameter("id", id);
        Customer c = (Customer)q.getSingleResult();
        return c;
    }
    
    
}
