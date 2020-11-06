package emergon.dao;

import emergon.entity.Product;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao extends SuperDao<Product> {

    public List<Product> findAll(){
        return super.findAll("Product.findAll");
    }
    
    @Override
    public String remove(int kwdikos) {
        return super.remove(kwdikos, "Product.deleteById");
    }

    @Override
    public Product findById(int id) {
        return super.findById(id, "Product.findById");
    }
    
}
