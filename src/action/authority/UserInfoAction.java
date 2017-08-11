package action.authority;

import com.opensymphony.xwork2.ActionSupport;
import entity.authority.Role;
import entity.authority.UserInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletRequestAware;
import service.authority.RoleService;
import service.authority.UserInfoRoleService;
import service.authority.UserInfoService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class UserInfoAction extends ActionSupport implements ServletRequestAware {
	private static final Log log = LogFactory.getLog(UserInfoAction.class);
	private HttpServletRequest request;
	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}
	@Resource(name = "userInfoService")
	private UserInfoService userInfoService;
	@Resource(name = "userInfoRoleService")
	private UserInfoRoleService userInfoRoleService;
	@Resource(name = "roleService")
	private RoleService roleService;
	private List roleIdSets;
	private UserInfo userInfo;
	private Role role;
	private long id;
	private String loginId,password;
	private String id1;
	public List getRoleIdSets() {
		return roleIdSets;
	}

	public void setRoleIdSets(List roleIdSets) {
		this.roleIdSets = roleIdSets;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getId1() {
		return id1;
	}

	public void setId1(String id1) {
		this.id1 = id1;
	}

	public UserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public static Log getLog() {
		return log;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * 显示用户列表
	 *
	 * @return
	 */
	public String showUserInfoList() {
		try {
			List<UserInfo> ls = userInfoService.findAll();
			request.setAttribute("list", ls);
			System.out.println(ls.size());

		} catch (Exception ex) {
			return "failure";
		}

		return "showUserInfoList";
	}

	/**
	 * 添加用户
	 *
	 * @return
	 */
	public String addUserInfo() {
		try {
			userInfo = userInfoService.saveAndGetEntity(userInfo);

		} catch (Exception ex) {

			return "failure";

		}
		return "showUserInfoListAction";
	}

	/**
	 * 显示用户明细
	 *
	 * @return
	 */
	public String getUserInfoById() {
		UserInfo userInfoUpdate = userInfoService.findById(userInfo.getId());

		List<Role> roleList = roleService.findAll();
		request.setAttribute("roleList", roleList);
		List ls=userInfoService.findByQuery("select role.roleId from UserInfoRole where userInfo.id="+userInfo.getId()+"");
		roleIdSets=ls;
		request.setAttribute("roleIdSets", this.roleIdSets);
		if (userInfoUpdate != null) {
			request.setAttribute("userInfo", userInfoUpdate);
			return "showUserInfo";
		} else
			return "failure";
	}

	/**
	 * 更新用户信息
	 *
	 * @return
	 */
	public String updateUserInfo() {
		userInfo.setId(Integer.parseInt(id1));
		userInfo=userInfoService.saveAndGetEntity(userInfo);
		userInfoRoleService.deleteRoleByUserId(userInfo.getId());

		if (this.roleIdSets != null && this.roleIdSets.size() > 0) {
			for(Object mis:roleIdSets){
				userInfoRoleService.saveUserRole(userInfo.getId(),userInfo.getLoginId(),mis);
			}
		}
		return "showUserInfoListAction";

	}

	/**
	 * 显示权限列表
	 *
	 * @return
	 */
	public String deleteUserInfo() {
			userInfoRoleService.deleteRoleByUserId(userInfo.getId());
			userInfo = userInfoService.findById(userInfo.getId());
			userInfoService.delete(userInfo);

		return "showUserInfoListAction";
	}
}
