
package emergon.service;

import emergon.entity.Product;
import java.util.List;


public interface ProductService {
    
    List<Product> findAll();
    int create(Product product);
    void edit(Product product);
    String delete(int id);
    Product findById(int id);
    
}
