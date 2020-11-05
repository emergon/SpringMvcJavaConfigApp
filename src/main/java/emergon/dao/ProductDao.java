package emergon.dao;

import emergon.entity.Product;
import emergon.entity.Product;
import java.io.Serializable;
import java.util.List;
import javax.persistence.PersistenceException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {
    
    @Autowired
    private SessionFactory sessionFactory;
    
    private Session getSession(){
        return sessionFactory.getCurrentSession();
    }
    
    public List<Product> findAll(){
        Query<Product> query = getSession().createNamedQuery("Product.findAll", Product.class);
        List<Product> products = query.getResultList();
        return products;
    }
    
    public Serializable addProduct(Product product){
        Session session = getSession();
        Serializable identifier = session.save(product);
        return identifier;
    }
    
    public String removeProduct(int kwdikos){
        Session session = getSession();
        Query q = session.createNamedQuery("Product.deleteById", Product.class);
        q.setParameter("id", kwdikos);
        String message = "Product deleted successfully!!";
        try{
            q.executeUpdate();
        }catch(PersistenceException e){
            System.out.println("Product cannot be deleted....PersistenceException..........");
            message = "Product cannot be deleted";
        }
        return message;
    }
    
    public void updateProduct(Product product){
        Session session = getSession();
        session.saveOrUpdate(product);
        System.out.println("Product updated ----------------------------");
    }

    public Product findById(int id) {
        Session session = getSession();
        Query q = session.createNamedQuery("Product.findById", Product.class);
        q.setParameter("id", id);
        Product c = (Product)q.getSingleResult();
        return c;
    }
}
