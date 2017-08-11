package service.authority;

import dao.authority.BaseDAO;
import dao.authority.UserInfoDAO;
import entity.authority.UserInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by haigeek on 2017/7/10.
 */

@Service(value = "userInfoService")
@Transactional
public class UserInfoService extends BaseService<UserInfo,Long> {
    @Resource(name="userInfoDAO")
    public void setBaseDAO(BaseDAO<UserInfo,Long>baseDAO){
        super.setBaseDAO(baseDAO);
    }
    @Resource(name="userInfoDAO")
    private UserInfoDAO userInfoDAO;
    public int validUser(UserInfo userInfo) {
        return userInfoDAO.validUser(userInfo);
    }
}
