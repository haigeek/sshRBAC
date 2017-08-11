package Authority;

import entity.authority.OnlineUserLog;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.*;
import java.util.HashMap;
import java.util.Map;

public class LogoutListener implements HttpSessionListener,
		ServletContextListener, HttpSessionAttributeListener {
	private HttpSession session;
	private ServletContext context;

	public void contextInitialized(ServletContextEvent event) {
		context = event.getServletContext();
	}

	// 实现方法
	public void sessionCreated(HttpSessionEvent se) {
		this.session = se.getSession();
		System.out.println("** Session 创建 ....");
		System.out.println("** SessionID --> " + this.session.getId());

	}

	public void sessionDestroyed(HttpSessionEvent se) {
		Map<String, OnlineUserLog> onlineUserMap = (Map) this.context
				.getAttribute("onlineUserLog");
		if (onlineUserMap == null) {
			onlineUserMap = new HashMap<String, OnlineUserLog>();
		}

		onlineUserMap.remove(this.session.getAttribute("loginId"));
		
		this.context.setAttribute("onlineUserLog", onlineUserMap);
		System.out.println("** Session 销毁 ....");

	}

	public void attributeAdded(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub

	}

	public void attributeRemoved(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub

	}

	public void attributeReplaced(HttpSessionBindingEvent se) {
		// TODO Auto-generated method stub

	}

	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}
}
