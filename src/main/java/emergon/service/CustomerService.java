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
    
    public List<Customer> findAll() {
        return cdao.findAll();
    }

    public int create(Customer customer) {
        int id = (Integer)cdao.addCustomer(customer);
        return id;
    }

    public void edit(Customer customer) {
        cdao.updateCustomer(customer);
    }

    public String delete(int id) {
        return cdao.removeCustomer(id);
    }

    public Customer findById(int id) {
        Customer customer = cdao.findById(id);
        return customer;
    }
}
