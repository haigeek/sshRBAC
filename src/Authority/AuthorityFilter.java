package Authority;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import service.authority.RoleService;
import service.authority.ShareModuleService;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class AuthorityFilter implements Filter {

	private ShareModuleService sharemoduleService;
	private RoleService roleService;

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String path = req.getContextPath();
		String basePath = req.getScheme() + "://" + request.getServerName()
				+ ":" + request.getServerPort();

		// System.out.println(basePath);
		// System.out.println(path);
		// System.out.println(req.getRequestURI());
		int beginIndex = path.length();
		String requestUrlAll = req.getRequestURI();
		String requestUrl = requestUrlAll.substring(beginIndex, requestUrlAll
				.lastIndexOf("/") + 1);
		System.out.println(requestUrl);

		// 判断是否是共享模块
		List<String> shareModule = sharemoduleService.findByQuery("select url from ShareModule");
		for (String sm : shareModule) {
			if (sm.indexOf(requestUrl) != -1) {
				// HttpSession session = req.getSession();

				RequestDispatcher rd = null;
				rd = req.getRequestDispatcher(requestUrlAll.substring(beginIndex,requestUrlAll.length()));
				rd.forward(request, response);

				return;
			}
		}

		basePath = basePath + path;

		// 获取用户角色
//		Set<Integer> roleIdSet = null;
		List<Long>roleIdSet = null;
		try {
			roleIdSet = (List<Long>) req.getSession(false).getAttribute(
					"roleIdList");
		} catch (Exception e) {
			// e.printStackTrace();
			roleIdSet = null;
		}

		if (roleIdSet == null || roleIdSet.size() == 0) {
			res.sendRedirect(basePath + "/bgLogin/index.jsp");
			return;
		} else {
			// 由角色获取所能访问的url
			Iterator<Long> iterator = roleIdSet.iterator();
			String url = "";
			while (iterator.hasNext()) {
				url += roleService.getModuleListUrlByRoleId(iterator.next());
			}
			System.out.println(url);
			
			// 判断是否可以访问
			requestUrl = requestUrl.substring(0, requestUrl.substring(1).indexOf("/")+2);
			System.out.println(requestUrl);
			if (url.indexOf(requestUrl) != -1) {
				// HttpSession session = req.getSession();
				chain.doFilter(request, response);
			} else {
				res.sendRedirect(basePath + "/bgLogin/index.jsp");
				return;
			}
		}
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public void init(FilterConfig filterConfig) throws ServletException {
		ServletContext context = filterConfig.getServletContext();
		ApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(context);
		sharemoduleService=(ShareModuleService) ctx.getBean("sharemoduleService");
		roleService=(RoleService)ctx.getBean("roleService");
	}
	
	

	
}
