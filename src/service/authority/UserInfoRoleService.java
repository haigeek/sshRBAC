package service.authority;

import dao.authority.BaseDAO;
import dao.authority.UserInfoRoleDAO;
import entity.authority.UserInfoRole;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by haigeek on 2017/8/4.
 */
@Service(value = "userInfoRoleService")
@Transactional
public class UserInfoRoleService extends BaseService<UserInfoRole,Long> {
    @Resource(name="userInfoRoleDAO")
    private UserInfoRoleDAO userInfoUserDAO;
    public void setBaseDAO(BaseDAO<UserInfoRole,Long> baseDAO){
        super.setBaseDAO(baseDAO);
    }
    @Transactional
    public void deleteRoleByUserId(long id) {
        userInfoUserDAO.deleteRoleByUserId(id);
    }

    public void saveUserRole(long id,String loginId,Object mis) {
        userInfoUserDAO.saveUserRole(id,loginId,mis);
    }
}

