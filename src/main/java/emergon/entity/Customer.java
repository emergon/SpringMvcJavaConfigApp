package emergon.entity;

import java.io.Serializable;
import javax.persistence.Entity;//JPA specification
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
@NamedQueries(value = {
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
    @NamedQuery(name = "Customer.deleteById", query = "Delete from Customer c where c.ccode = :id"),
    @NamedQuery(name = "Customer.findById", query = "SELECT c FROM Customer c WHERE c.ccode = :id")
})
public class Customer implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ccode;
    private String cname;

    public Customer() {
    }

    public Customer(int ccode, String cname) {
        this.ccode = ccode;
        this.cname = cname;
    }

    public int getCcode() {
        return ccode;
    }

    public void setCcode(int ccode) {
        this.ccode = ccode;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    @Override
    public String toString() {
        return "Customer{" + "ccode=" + ccode + ", cname=" + cname + '}';
    }
    
    
}
