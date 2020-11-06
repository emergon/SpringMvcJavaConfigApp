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
public class CustomerDao extends SuperDao<Customer>{
    
    @Override
    public List<Customer> findAll(){
        return super.findAll("Customer.findAll");
    }
    
    @Override
    public String remove(int kwdikos){
        return super.remove(kwdikos, "Customer.deleteById");
    }
    
    @Override
    public Customer findById(int id) {
        return super.findById(id, "Customer.findById");
    }
    
}
