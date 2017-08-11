package action.authority;

import com.opensymphony.xwork2.ActionSupport;
import entity.authority.Module;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ServletRequestAware;
import service.authority.ModuleService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ModuleAction extends ActionSupport implements
        ServletRequestAware {
    private static final Log log = LogFactory.getLog(ModuleAction.class);
    private HttpServletRequest request;
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    /**
     * 前台提交属性
     */
    @Resource(name = "moduleService")
    private ModuleService moduleService;
    private entity.authority.Module module;
    private long moduleId;
    private String moduleName, description, url;
    private String id;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public long getModuleId() {
        return moduleId;
    }

    public void setModuleId(long moduleId) {
        this.moduleId = moduleId;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    /**
     * 显示模块列表
     *
     * @return
     */
    public String showModuleList() {
        try {
            List<Module> moduleList = moduleService.findAll();
            HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute("list", moduleList);
        } catch (Exception ex) {
            return "failure";
        }

        return "showModuleList";
    }

    /**
     * 添加模块
     *
     * @return
     */
    public String addModule() {
        try {
            module = moduleService.saveAndGetEntity(module);
            return "showModuleListAction";
        } catch (Exception ex) {

            return "failure";

        }
    }

    /**
     * 显示模块明细（编辑）
     *
     * @return
     */
    public String getModuleById() {
        Module moduleUpdate = moduleService.findById(module.getModuleId());

        if (moduleUpdate != null) {
            HttpServletRequest request = ServletActionContext.getRequest();
            request.setAttribute("module", moduleUpdate);
            return "showModule";
        } else
            return "failure";
    }

    /**
     * 更新权限
     *
     * @return
     */
    public String updateModule() {
        try {
            module.setModuleId(Integer.parseInt(id));
            moduleService.update(module);
            return "showModuleListAction";
        } catch (Exception ex) {
            return "failure";
        }
    }

    /**
     * 删除模块
     *
     * @return
     */
    public String deleteModule() {
        try {
            module = moduleService.findById(module.getModuleId());
            moduleService.delete(module);
            return "showModuleListAction";
        } catch (Exception ex) {
            return "failure";
        }
    }
}

