
package dao.authority;

import dao.authority.BaseDAO;
import entity.authority.Role;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * InfoDAO.java
 */
@Transactional
@Repository(value = "roleDAO")
public class RoleDAO extends BaseDAO<Role, Integer> {

    @Transactional(readOnly=false)
    public String getModuleListUrlByRoleId(Long next) {
        Session session=this.getHibernateTemplate().getSessionFactory().openSession();
        String hql="select module .moduleId from RoleModule where role.roleId=?";
        Query query=session.createQuery(hql);
        query.setParameter(0, next);

        List moduleid=query.list();
        String url = "";
        for(int i=0;i<moduleid.size();i++){
            String hql2="select url from Module where moduleId="+ moduleid.get(i) +"";
            Query query2=session.createQuery(hql2);

            List urllist=query2.list();

            for(int i1=0;i1<urllist.size();i1++){
            url+=urllist.get(i1)+",";
        }
        }
        session.close();
        return url;
    }
}