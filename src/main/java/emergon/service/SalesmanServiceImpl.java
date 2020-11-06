package emergon.service;

import emergon.dao.CrudInterfaceDao;
import emergon.entity.Salesman;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class SalesmanServiceImpl implements SalesmanService{

    @Autowired
    private CrudInterfaceDao<Salesman> cdao;
    
    @Override
    public List<Salesman> findAll() {
        return cdao.findAll();
    }
    @Override
    public int create(Salesman salesman) {
        int id = (Integer)cdao.add(salesman);
        return id;
    }
    @Override
    public void edit(Salesman salesman) {
        cdao.update(salesman);
    }
    @Override
    public String delete(int id) {
        return cdao.remove(id);
    }
    @Override
    public Salesman findById(int id) {
        Salesman salesman = cdao.findById(id);
        return salesman;
    }
}
