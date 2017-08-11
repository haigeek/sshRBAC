package Authority;

import entity.authority.Role;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import service.authority.RoleService;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.util.List;

public class AuthorityTag extends TagSupport implements ServletRequestAware {
	private RoleService roleService;
	private HttpServletRequest request;

	public void setServletRequest(HttpServletRequest request) {
		this.request = request;
	}

	private String role = ""; // 默认值：""

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public int doStartTag() {
		//注入service
		ServletContext servletContext = (this.pageContext).getServletContext();
		WebApplicationContext wac = WebApplicationContextUtils
				.getRequiredWebApplicationContext(servletContext);
		roleService=(RoleService) wac.getBean("roleService");

		JspWriter out = pageContext.getOut();
		
		// 获取用户角色
//		Set<Integer> roleIdSet = null;
		List<Long>roleIdSet=null;
		try {
			roleIdSet = (List<Long>) pageContext.getSession().getAttribute(
					"roleIdList");
		} catch (Exception e) {
			 e.printStackTrace();
		}
		
		if(roleIdSet==null) return (SKIP_BODY);
		
		System.out.println(role);
		
		String roleStr = "";
		for (Long ris : roleIdSet) {
			Role roleTemp = roleService.findById(ris);
			roleStr += roleTemp.getRoleName() + ",";
		}	

		String[] roleArray = role.split(",");
		boolean flag = false;
		for (String ra : roleArray) {
			System.out.println("-----"+ra);
		}
		for (String ra : roleArray) {
			if (roleStr.contains(ra)) {
				flag = true;
				break;
			}
		}

		if (flag == true)
			return (EVAL_BODY_INCLUDE);
		else
			return (SKIP_BODY);
	}	
}