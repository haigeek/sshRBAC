package dao.authority;

import entity.authority.Module;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * InfoDAO.java
 */
@Transactional
@Repository(value = "moduleDAO")
public class ModuleDAO extends BaseDAO<Module, Integer> {

}