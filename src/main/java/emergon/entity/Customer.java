package emergon.entity;

public class Customer {
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
