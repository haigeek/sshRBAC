package service.authority;

import dao.authority.BaseDAO;
import entity.authority.Module;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by haigeek on 2017/7/9.
 */
@Service(value = "moduleService")
@Transactional
public class ModuleService extends BaseService<Module,Long> {
    @Resource(name="moduleDAO")
    public void setBaseDAO(BaseDAO<Module,Long>baseDAO){
        super.setBaseDAO(baseDAO);
    }
}
