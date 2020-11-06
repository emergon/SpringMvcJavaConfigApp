package emergon.service;

import emergon.entity.Customer;
import java.util.List;

public interface CustomerService {
    
    List<Customer> findAll();
    int create(Customer customer);
    void edit(Customer customer);
    String delete(int id);
    Customer findById(int id);
    
    default void hello(){
        System.out.println("");
    }
}
