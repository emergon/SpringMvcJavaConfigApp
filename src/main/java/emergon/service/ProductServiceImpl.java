package emergon.service;

import emergon.dao.CrudInterfaceDao;
import emergon.dao.ProductDao;
import emergon.entity.Customer;
import emergon.entity.Product;
import emergon.entity.Product;
import emergon.entity.Product;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired
    private CrudInterfaceDao<Product> pdao;
    
    @Override
    public List<Product> findAll() {
        return pdao.findAll();
    }
    
    @Override
    public int create(Product product) {
        int id = (Integer)pdao.add(product);
        return id;
    }
    
    @Override
    public void edit(Product product) {
        pdao.update(product);
    }

    @Override
    public String delete(int id) {
        return pdao.remove(id);
    }

    @Override
    public Product findById(int id) {
        Product product = pdao.findById(id);
        return product;
    }
}
