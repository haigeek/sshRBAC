package entity.authority;

import javax.servlet.http.HttpSession;

public class OnlineUserLog {

	private String loginId, sessionId;
	private HttpSession session;

	public OnlineUserLog(String loginId, String sessionId, HttpSession session) {
		super();
		this.loginId = loginId;
		this.sessionId = sessionId;
		this.session = session;
	}

	public HttpSession getSession() {
		return (HttpSession) session;
	}

	public void setSession(HttpSession httpSession) {
		this.session = httpSession;
	}

	public OnlineUserLog(String loginId, String sessionId) {
		this.loginId = loginId;
		this.sessionId = sessionId;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getSessionId() {
		return sessionId;
	}

	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
}
