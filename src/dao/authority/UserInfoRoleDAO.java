package dao.authority;

import entity.authority.UserInfoRole;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by haigeek on 2017/8/4.
 */
@Transactional
@Repository(value = "userInfoRoleDAO")
public class UserInfoRoleDAO extends BaseDAO<UserInfoRole, Integer> {
    @Transactional(readOnly=false)
    public void deleteRoleByUserId(long id) {
        Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        String hql="delete from UserInfoRole where userInfo.id=?";
        Query query=session.createQuery(hql);
        query.setParameter(0, id);
        query.executeUpdate();
        session.close();
    }
    @Transactional(readOnly=false)
    public void saveUserRole(long id, String loginId,Object mis) {
        Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        String hql="insert into  UserInfoRole (roleId,id,loginId) VALUES ("+mis+","+id+",'"+loginId+"')";
        SQLQuery s=session.createSQLQuery(hql);
        s.executeUpdate();
        session.close();
    }
}