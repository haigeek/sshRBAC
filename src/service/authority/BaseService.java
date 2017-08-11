package service.authority;

import dao.authority.BaseDAO;

import java.io.Serializable;
import java.util.List;

/**
 * BaseService.java @author zzn
 * @param <T>
 * @param <ID>
 */
public class BaseService<T,ID extends Serializable>{
	
	private BaseDAO<T,ID> baseDAO;
    public List<T> findAll() {           
	    return baseDAO.findAll();   
	}   
	public T findById(ID id) {         
	    return baseDAO.findById(id);
	}   
	public void modify(T entity) {   
		baseDAO.modify(entity);         
	}
	public void update(T entity) {
		baseDAO.update(entity);
	}
	public void delete(T entity) {   
		baseDAO.delete(entity);   
	}     
	public void save(T entity) {         
		baseDAO.save(entity);
	}
	public T saveAndGetEntity(T entity) {         
		return baseDAO.saveAndGetEntity(entity);
	}
	public List<T> findByproperty(String propertyName, Object value){
		return baseDAO.findByProperty(propertyName, value);
	}
	public List<T> findByPage(int page,int rows, String hql){
		return baseDAO.findByPage(page, rows, hql);
	}
	public long count(String hql){
		return baseDAO.count(hql);
	}
	public String findMaxId(String hql){
		return baseDAO.findMaxid(hql);
	}
	public List<T>findByStr(String str){
		return baseDAO.findByStr(str);
	}
	public BaseDAO<T, ID> getBaseDAO() {
		return baseDAO;
	}
	public void setBaseDAO(BaseDAO<T, ID> baseDAO) {
		this.baseDAO = baseDAO;
	}
    
	@SuppressWarnings("rawtypes")
	public List findByQuery(String hql){
		return baseDAO.findByQuery(hql);
	}
		
}
