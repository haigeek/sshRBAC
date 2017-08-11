package service.authority;

import dao.authority.BaseDAO;
import dao.authority.RoleModuleDAO;
import entity.authority.RoleModule;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by haigeek on 2017/7/11.
 */
@Service(value = "rolemoduleService")
@Transactional
public class RoleModuleService extends BaseService<RoleModule,Long> {

    @Resource(name="rolemoduleDAO")
    private RoleModuleDAO rolemoduleDAO;
    public void setBaseDAO(BaseDAO<RoleModule,Long> baseDAO){
        super.setBaseDAO(baseDAO);
    }
    @Transactional
    public void deleteModuleByRoleId(long roleId) {

        rolemoduleDAO.deleteModuleByRoleId(roleId);
    }

    public void saveRoleModule(long roleId, Object mis) {
        rolemoduleDAO.saveRoleModule(roleId,mis);
    }
}
