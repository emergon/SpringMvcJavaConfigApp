package emergon.service;

import emergon.entity.Customer;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    
    private List<Customer> customers = new ArrayList();
    
    public List<Customer> findAll(){
        //customers = new ArrayList();
        customers.add(new Customer(1, "Jack"));
        customers.add(new Customer(2, "Peter"));
        customers.add(new Customer(3, "Mary"));
        customers.add(new Customer(4, "Andrew"));
        return customers;
    }

    public void create(Customer customer) {
        customers.add(customer);
    }
}
