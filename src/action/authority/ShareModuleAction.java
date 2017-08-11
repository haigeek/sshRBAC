package action.authority;

import com.opensymphony.xwork2.ActionSupport;
import entity.authority.ShareModule;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletRequestAware;
import service.authority.ShareModuleService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class ShareModuleAction extends ActionSupport implements
        ServletRequestAware {
	private static final Log log = LogFactory.getLog(ShareModuleAction.class);

	private HttpServletRequest request;

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * 前台提交属性
	 */
	@Resource(name = "sharemoduleService")
	private ShareModuleService sharemoduleService;
	//private entity.anthority.ShareModule sharemodule;
	private long moduleId;
	private String moduleName, description, url;
	private String id;
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private ShareModule module;
	public ShareModule getModule() {
		return module;
	}

	public void setModule(ShareModule module) {
		this.module = module;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
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

	/**
	 * 显示权限列表
	 * 
	 * @return
	 */
public String showModuleList() {
		try {
			List<ShareModule> ls = sharemoduleService.findAll();
			request.setAttribute("list", ls);
		} catch (Exception ex) {
		}

		return "showModuleList";
	}

	/**
	 * 添加权限
	 * 
	 * @return
	 */
	public String addModule() {
		try {
			module = sharemoduleService.saveAndGetEntity(module);
			return "showModuleListAction";
		} catch (Exception ex) {

			return "failure";

		}
	}

	/**
	 * 显示权限明细
	 * 
	 * @return
	 */
	public String getModuleById() {
		ShareModule moduleUpdate = sharemoduleService.findById(module.getModuleId());

		if (moduleUpdate != null) {
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
			sharemoduleService.update(module);
			return "showModuleListAction";
		}catch (Exception ex){
			return "failure";
		}
	}

	/**
	 * 显示权限列表
	 * 
	 * @return
	 */
	public String deleteModule() {
		try {
			System.out.println(module.getModuleId());
			module = sharemoduleService.findById(module.getModuleId());
			sharemoduleService.delete(module);
			return "showModuleListAction";
		}
		catch (Exception ex) {
			return "failure";
		}
	}
}
