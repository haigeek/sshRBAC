package dao.authority;

import dao.authority.BaseDAO;
import entity.authority.RoleModule;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by haigeek on 2017/7/11.
 */
@Transactional
@Repository(value = "rolemoduleDAO")
public class RoleModuleDAO extends BaseDAO<RoleModule, Integer> {

    @Transactional(readOnly=false)
    public void  deleteModuleByRoleId(long roleId) {
        Session session=this.getHibernateTemplate().getSessionFactory().openSession();
       String hql="delete from RoleModule where role.roleId=?";
        Query query=session.createQuery(hql);
        query.setParameter(0, roleId);
        query.executeUpdate();
        session.close();
    }
    @Transactional(readOnly=false)
    public void saveRoleModule(long roleId, Object mis) {
        Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        String hql="insert into  RoleModule (roleId,moduleId) VALUES ("+roleId+","+mis+")";
        SQLQuery s=session.createSQLQuery(hql);
        s.executeUpdate();
        session.close();
    }
}