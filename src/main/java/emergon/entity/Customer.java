package emergon.entity;

import java.io.Serializable;
import javax.persistence.Entity;//JPA specification
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
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
