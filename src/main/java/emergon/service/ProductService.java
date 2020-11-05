package emergon.service;

import emergon.dao.ProductDao;
import emergon.entity.Product;
import emergon.entity.Product;
import emergon.entity.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductService {

    @Autowired
    private ProductDao pdao;
    
    public List<Product> findAll() {
        return pdao.findAll();
    }
    
    public int create(Product product) {
        int id = (Integer)pdao.add(product);
        return id;
    }
    
    public void edit(Product product) {
        pdao.update(product);
    }

    public String delete(int id) {
        return pdao.remove(id);
    }

    public Product findById(int id) {
        Product product = pdao.findById(id);
        return product;
    }
}
