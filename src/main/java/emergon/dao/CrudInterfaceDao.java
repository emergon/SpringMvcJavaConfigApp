/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emergon.dao;

import java.io.Serializable;
import java.util.List;

public interface CrudInterfaceDao<E> {
    
    List<E> findAll(String namedQuery);
    Serializable add(E e);
    String remove(int kwdikos);
    void update(E e);
    E findById(int id);
}
