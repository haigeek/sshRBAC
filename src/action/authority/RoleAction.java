package action.authority;

import com.opensymphony.xwork2.ActionSupport;
import entity.authority.Module;
import entity.authority.Role;
import entity.authority.RoleModule;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletRequestAware;
import service.authority.ModuleService;
import service.authority.RoleModuleService;
import service.authority.RoleService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class RoleAction extends ActionSupport implements ServletRequestAware {
    private static final Log log = LogFactory.getLog(RoleAction.class);
    private HttpServletRequest request;
    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }
    @Resource(name = "moduleService")
    private ModuleService moduleService;
    @Resource(name = "rolemoduleService")
    private RoleModuleService rolemoduleService;
    @Resource(name = "roleService")
    private RoleService roleService;
    private entity.authority.Role role;
    private entity.authority.RoleModule roleModule;

    private long roleId;
    private String roleName,description;
    private List moduleIdSets;

    public long getRoleId() {
        return roleId;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public List getModuleIdSets() {
        return moduleIdSets;
    }

    public void setModuleIdSets(List moduleIdSets) {
        this.moduleIdSets = moduleIdSets;
    }

    public RoleModule getRoleModule() {
        return roleModule;
    }

    public void setRoleModule(RoleModule roleModule) {
        this.roleModule = roleModule;
    }

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    /**
     * 显示角色列表
     *
     * @return
     */
    public String showRoleList() {
        try {
            List<Role> ls = roleService.findAll();
            request.setAttribute("list", ls);
        } catch (Exception ex) {
            return "failure";
        }

        return "showRoleList";
    }


    /**
     * 添加角色
     *
     * @return
     */
    public String addRole() {
     try {
        role = roleService.saveAndGetEntity(role);

    } catch (Exception ex) {

        return "failure";

    }
        return "showRoleListAction";
}

    /**
     * 显示角色明细
     *
     * @return
     */
    public String getRoleById() {
        Role roleUpdate = roleService.findById(role.getRoleId());

        List<Module> moduleList = moduleService.findAll();
        request.setAttribute("moduleList", moduleList);
        List ls= roleService.findByQuery("select module.moduleId from RoleModule where role.roleId="+role.getRoleId()+"");
        for(int i = 0; i< ls.size(); i++){
            System.out.println(ls.size());
            System.out.println(ls.get(i));
        }
        moduleIdSets=ls;
        request.setAttribute("moduleIdSet", this.moduleIdSets);

        if (roleUpdate != null) {
            request.setAttribute("role", roleUpdate);
            return "showRole";
        } else
            return "failure";
    }

    /**
     * 更新角色权限
     *
     * @return
     */
    public String updateRole() {
        role.setRoleId(Integer.parseInt(id));
        role = roleService.saveAndGetEntity(role);
        //删除roleModule表中包含roleId的记录
        rolemoduleService.deleteModuleByRoleId(role.getRoleId());
        if (this.moduleIdSets != null && this.moduleIdSets.size() > 0) {
                for(Object mis:moduleIdSets){
                rolemoduleService.saveRoleModule(role.getRoleId(),mis);
             }
        }
        return "showRoleListAction";
    }

    /**
     * 删除角色
     *
     * @return
     */
    public String deleteRole() {
     try {
         //删除rolemodule数据
         rolemoduleService.deleteModuleByRoleId(role.getRoleId());
        role = roleService.findById(role.getRoleId());
        roleService.delete(role);
    } catch (Exception ex) {
        return "failure";
    }
        return "showRoleListAction";
}
}
