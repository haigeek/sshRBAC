package action.authority;

import com.opensymphony.xwork2.ActionSupport;
import entity.authority.OnlineUserLog;
import entity.authority.UserInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.util.ServletContextAware;
import service.authority.UserInfoService;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




public class LoginAction extends ActionSupport implements ServletRequestAware,
        ServletContextAware {
    private static final Log log = LogFactory.getLog(LoginAction.class);
    @Resource(name = "userInfoService")
    private UserInfoService userInfoService;
    private HttpServletRequest request;

    public void setServletRequest(HttpServletRequest request) {
        this.request = request;
    }

    private ServletContext servletContext;

    public void setServletContext(ServletContext application) {
        this.servletContext = application;
    }

    private UserInfo userInfo;

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

    /**
     * 用户登录
     *
     * @return
     */
//	public String loginAgain() {
//		int result = UserInfoDao.validUser(userInfo);
//		if (result != -1) {
//			// 去除前一个登录用户
//			boolean removeLoginId = removeLoginId(userInfo.getLoginId());
//
//			if (removeLoginId = true) {
////				Set<Integer> roleIdSet = UserInfoDao
////						.getRoleListByLoginId(userInfo.getLoginId());
//				List<Long> roleIdSet = userInfoService.findByQuery("select role.roleId from UserInfoRole where loginId='"+userInfo.getLoginId()+"'");
//
//				OnlineUserLog oul = new OnlineUserLog(userInfo.getLoginId(),
//						this.request.getSession(true).getId(), this.request
//								.getSession());
//
//				boolean login = isLogin(oul);
//
//				if (login == true)
//					return "loginAgain";
//				else {
//					request.getSession().setAttribute("roleIdList", roleIdSet);
//					request.getSession().setAttribute("loginId",
//							userInfo.getLoginId());
//					return "success";
//				}
//			}
//		}
//		return "failure";
//	}

    // 去除前一个登录用户
    public boolean removeLoginId(String loginId) {
        Map<String, OnlineUserLog> onlineUserMap = (Map) this.servletContext
                .getAttribute("onlineUserLog");
        if (onlineUserMap == null) {
            onlineUserMap = new HashMap<String, OnlineUserLog>();
        }

        OnlineUserLog onlineUser = onlineUserMap.get(loginId);
        javax.servlet.http.HttpSession destorySession = ((javax.servlet.http.HttpSession) onlineUser
                .getSession());
        if (destorySession != null) {
            try {
                destorySession.invalidate();
            } catch (Exception e) {

            }
        }

        onlineUserMap.remove(loginId);
        this.servletContext.setAttribute("onlineUserLog", onlineUserMap);

        return true;
    }

    /**
     * 用户登录
     *
     * @return
     */
    public String login() {
        try {
            int result = userInfoService.validUser(userInfo);
            if (result != -1) {
                OnlineUserLog oul = new OnlineUserLog(userInfo.getLoginId(),
                        this.request.getSession().getId(), this.request
                        .getSession());
                // 防止重复登录
                boolean login = isLogin(oul);
                if (login == true)
                    return "loginAgain";
                else {

                    List<Long> roleIdSet = userInfoService.findByQuery("select role.roleId from UserInfoRole where loginId='" + userInfo.getLoginId() + "'");
                    request.getSession().setAttribute("roleIdList", roleIdSet);
                    request.getSession().setAttribute("loginId",
                            userInfo.getLoginId());
                    return "success";
                }
            } else
                return "failure";
        } catch (Exception ex) {
            return "failure";
        }
    }


    // 判断是否重复登录
    public boolean isLogin(OnlineUserLog oul) {
        // Map<String,OnLineUserLog> onLineUserMap = new
        // HashMap<String,OnLineUserLog>()
        Map<String, OnlineUserLog> onlineUserMap = (Map) this.servletContext
                .getAttribute("onlineUserLog");
        if (onlineUserMap == null) {
            onlineUserMap = new HashMap<String, OnlineUserLog>();
        }

        boolean flag = false;
        OnlineUserLog oulFromMap = onlineUserMap.get(oul.getLoginId());
        if (oulFromMap != null) {
            String loginId = oulFromMap.getLoginId();
            if (oul.getLoginId().equals(loginId)
                    && !oul.getSessionId().equals(oulFromMap.getSessionId()))
                flag = true;
        }

        if (flag == false) {
            onlineUserMap.put(oul.getLoginId(), oul);
            this.servletContext.setAttribute("onlineUserLog", onlineUserMap);
        }
        return flag;
    }

    // 注销
    public String logout() {
        request.getSession().invalidate();
        return "logout";
    }
}
