package service.authority;

import dao.authority.BaseDAO;
import dao.authority.RoleDAO;
import entity.authority.Role;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by haigeek on 2017/7/9.
 */
@Service(value = "roleService")
@Transactional
public class RoleService extends BaseService<Role,Long> {

    @Resource(name="roleDAO")

    public void setBaseDAO(BaseDAO<Role,Long>baseDAO){
        super.setBaseDAO(baseDAO);
    }
    @Resource(name="roleDAO")
    private RoleDAO roleDAO;
    @Transactional
    public String getModuleListUrlByRoleId(Long next) {
        return roleDAO.getModuleListUrlByRoleId(next);

    }
}
