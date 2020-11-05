package emergon.service;

import emergon.dao.ProductDao;
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
    
}
