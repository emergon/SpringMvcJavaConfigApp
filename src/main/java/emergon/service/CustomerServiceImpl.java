package emergon.service;

import emergon.dao.CrudInterfaceDao;
import emergon.entity.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CrudInterfaceDao<Customer> cdao;
    
    @Override
    public List<Customer> findAll() {
        return cdao.findAll();
    }
    @Override
    public int create(Customer customer) {
        int id = (Integer)cdao.add(customer);
        return id;
    }
    @Override
    public void edit(Customer customer) {
        cdao.update(customer);
    }
    @Override
    public String delete(int id) {
        return cdao.remove(id);
    }
    @Override
    public Customer findById(int id) {
        Customer customer = cdao.findById(id);
        return customer;
    }
}
