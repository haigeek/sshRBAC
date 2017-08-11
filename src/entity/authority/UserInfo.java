package entity.authority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "userinfo")
public class UserInfo implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private long id;
	private String loginId, password;
	private Set<UserInfoRole> userInfoRoles;
	@Id
	@Column(name = "id", unique = true, nullable = false)
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	@Column(name = "loginId", columnDefinition = "varchar")
	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	@Column(name = "password", columnDefinition = "varchar")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	@OneToMany(cascade= CascadeType.ALL,fetch= FetchType.LAZY,mappedBy="userInfo")
	public Set<UserInfoRole> getUserInfoRoles() {
		return userInfoRoles;
	}

	public void setUserInfoRoles(Set<UserInfoRole> userInfoRoles) {
		this.userInfoRoles = userInfoRoles;
	}
}