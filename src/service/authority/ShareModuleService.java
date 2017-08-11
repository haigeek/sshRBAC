package service.authority;

import dao.authority.BaseDAO;
import entity.authority.ShareModule;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by haigeek on 2017/7/10.
 */
@Service(value = "sharemoduleService")
@Transactional
public class ShareModuleService extends BaseService<ShareModule,Long> {
    @Resource(name = "sharemoduleDao")
    public void setBaseDao(BaseDAO<ShareModule,Long>baseDao){super.setBaseDAO(baseDao);}
//    private ShareModuleDAO sharemoduleDao;
//    public List<String> getShareModulUrlList() {
//        return sharemoduleDao.getShareModulUrlList();
//    }
}
