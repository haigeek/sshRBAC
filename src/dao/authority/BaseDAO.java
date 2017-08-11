package dao.authority;

import common.BaseReflectUtils;
import common.myHibernateDaoSupport;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * BaseDAO.java 
 * @param <T>
 * @param <ID>
 */
@Transactional
public class BaseDAO<T,ID extends Serializable>extends myHibernateDaoSupport{
	protected Logger logger= LoggerFactory.getLogger(this.getClass());
	protected Class<T> entityClass;
	@SuppressWarnings("unchecked")
	public BaseDAO(){
		this.entityClass = (Class<T>) BaseReflectUtils.getSuperClassGenricType(super.getClass());
	}
	//构造方法注入实体类
	public BaseDAO(Class<T> entityClass){
		this.entityClass=entityClass;
	}
	//保存
	@Transactional(readOnly=false)
	public void save(T entity){
    	logger.debug("saving entity:", entity);
        try {
        	getHibernateTemplate().merge(entity);
        	logger.debug("save successful");
		} catch (RuntimeException re) {
			logger.error("save failed", re);
		}
	}
	
	@Transactional(readOnly=false)
	public T saveAndGetEntity(T entity){
    	logger.debug("saving entity:", entity);
        try {
        	getHibernateTemplate().merge(entity);
        	entity = (T) this.getHibernateTemplate().findByExample(entity).get(0);
        	logger.debug("save successful");        	
		} catch (RuntimeException re) {
			logger.error("save failed", re);
		}
		return entity;
	}
	//修改
	@Transactional(readOnly=false)
    public void modify(T entity) {  
    	logger.debug("modifying entity:", entity);
        try {
        	getHibernateTemplate().merge(entity);
        	logger.debug("modify successful");
		} catch (RuntimeException re) {
			logger.error("modify failed", re);
		}
    }
	@Transactional(readOnly=false)
	public void update(T entity) {
		logger.debug("updating entity:", entity);
		try {
			getHibernateTemplate().update(entity);
			logger.debug("update successful");
		} catch (RuntimeException re) {
			logger.error("update failed", re);
		}
	}
    //删除
	@Transactional(readOnly=false)
    public void delete(T entity){
    	logger.debug("deleting entity:", entity);
        try {
        	getHibernateTemplate().delete(entity);
        	logger.debug("delete successful");
		} catch (RuntimeException re) {
			logger.error("delete failed", re);
		}
    }
    //按ID查找
    public T findById(ID id){
        T instance=(T)getHibernateTemplate().get(entityClass, id);
		return instance;
    }

    //查找全部
	@SuppressWarnings("unchecked")
	public List<T> findAll(){
		String queryString="from "+entityClass.getName();
    	return getHibernateTemplate().find(queryString);
    }
	//条件查找
	@SuppressWarnings("unchecked")
	public List<T> findByProperty(String propertyName, Object value) {
		logger.debug("finding BaseInfo instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from "+entityClass.getName()+" as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			logger.error("find by property name failed", re);
			throw re;
		}
	}
	//按条件分页查找
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<T> findByPage(final int page,final int rows,final String hql)
    {
    	List<T> list=new ArrayList<T>();
    	try {

    		list=getHibernateTemplate().executeFind(new HibernateCallback() {
    			public Object doInHibernate(Session s) throws HibernateException,
    			SQLException {
    				String qString="from "+entityClass.getName()+hql;
    			Query query = s.createQuery(qString);
    			query.setFirstResult((page-1)*rows);
    			query.setMaxResults(rows);
				return query.list();
    			}

			});
		} catch (RuntimeException re) {
			logger.error("query() failed",re);
			System.out.println(re);
			throw re;
		}
		return list;
    }
	//查询总数
    public long count(String hql)
    {
    	String qString="select count(*) from "+entityClass.getName()+hql;
    	Long  count=(Long) this.getHibernateTemplate().find(qString).listIterator().next();
    	return count.intValue();
    }
    //查询最大ID
    public String findMaxid(String hql){
    	String max_id;
    	hql="select max(id) from "+entityClass.getName()+hql;
    	max_id=(String)getHibernateTemplate().find(hql).get(0);
    	return max_id;
    }
    //自己组装hql语句进行查询，默认会查询所有的属性
    @SuppressWarnings({ "unchecked" })
	public List<T> findByStr(String hql){
    	hql="from "+entityClass.getName()+hql;
    	return getHibernateTemplate().find(hql);
    }
    //自己完全写hql语句进行查询，可以查询指定的属性
	@SuppressWarnings("rawtypes")
	public  List findByQuery(String hql){
    	return getHibernateTemplate().find(hql);
    }
	public Class<T> getEntityClass() {
		return entityClass;
	}
	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
  

}
