package dao.authority;

import dao.authority.BaseDAO;
import entity.authority.UserInfo;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by haigeek on 2017/7/10.
 */
@Transactional
@Repository(value = "userInfoDAO")
public class UserInfoDAO extends BaseDAO<UserInfo,Integer>{
    @Transactional(readOnly=false)
    public int validUser(UserInfo userInfo) {
        Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        String hql="select password from UserInfo where loginId=?";
        Query query=session.createQuery(hql);
        query.setParameter(0, userInfo.getLoginId());
        List userlist=query.list();
        int id = -1;
        if(userlist.get(0).equals(userInfo.getPassword())){
            id= (int) userInfo.getId();
        }
        session.close();
        return id;
    }
}
