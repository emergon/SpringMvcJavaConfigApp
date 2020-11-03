package emergon.service;

import emergon.dao.CustomerDao;
import emergon.entity.Customer;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerService {

    @Autowired
    private CustomerDao cdao;
    
    private List<Customer> customers = new ArrayList();

    public List<Customer> findAll() {
        return cdao.findAll();
    }

    public void create(Customer customer) {
        customers.add(customer);
    }

    public Customer findByName(String name) {
        Customer customer = null;
        for(Customer c: customers){
            if(c.getCname().equals(name)){
                customer = c;
            }
        }
        return customer;
    }

    public void edit(Customer customer) {
        for(Customer c: customers){
            if(c.getCcode()==customer.getCcode()){
                c.setCname(customer.getCname());
            }
        }
    }

    public void delete(int id) {
        Customer customerToDelete = null;
        for(Customer c: customers){//Is this correct
            if(c.getCcode()==id){
                customerToDelete = c;
            }
        }
        if(customerToDelete!=null){
            customers.remove(customerToDelete);
        }
    }
}
