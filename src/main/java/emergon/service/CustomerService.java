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

    public int create(Customer customer) {
        int id = (Integer)cdao.addCustomer(customer);
        return id;
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

    public String delete(int id) {
        return cdao.removeCustomer(id);
    }
}
