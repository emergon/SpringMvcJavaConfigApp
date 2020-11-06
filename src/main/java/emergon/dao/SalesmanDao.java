package emergon.dao;

import emergon.entity.Salesman;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class SalesmanDao extends SuperDao<Salesman>{
    
    @Override
    public List<Salesman> findAll(){
        return super.findAll("Salesman.findAll");
    }
    
    @Override
    public String remove(int kwdikos){
        return super.remove(kwdikos, "Salesman.deleteById");
    }
    
    @Override
    public Salesman findById(int id) {
        return super.findById(id, "Salesman.findById");
    }
    
}
