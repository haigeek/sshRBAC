package dao.authority;

import entity.authority.ShareModule;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by haigeek on 2017/7/10.
 */
@Transactional
@Repository(value = "sharemoduleDao")
public class ShareModuleDAO extends BaseDAO<ShareModule,Integer>{
}
