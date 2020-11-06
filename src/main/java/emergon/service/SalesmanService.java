package emergon.service;

import emergon.entity.Salesman;
import java.util.List;

public interface SalesmanService {
    
    List<Salesman> findAll();
    int create(Salesman salesman);
    void edit(Salesman salesman);
    String delete(int id);
    Salesman findById(int id);
    
}
