package emergon.dao;

import emergon.entity.Customer;
import java.util.List;
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
