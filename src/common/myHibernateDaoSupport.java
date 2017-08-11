package common;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import javax.annotation.Resource;

/**
 * myHibernateDaoSupport.java zzn
 */
public class myHibernateDaoSupport extends HibernateDaoSupport {
	@Resource(name="sessionFactory")
    public void setSuperSessionFactory(SessionFactory sessionFactory)
	{
		super.setSessionFactory(sessionFactory);
	}
}
