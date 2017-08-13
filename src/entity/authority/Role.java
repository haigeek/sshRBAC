package entity.authority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
public class Role  implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	private long roleId;
	private String roleName,description;
	//表示权限
	private Set<RoleModule> roleModules;
	private Set<UserInfoRole>userInfoRoles;
	@Id
	@Column(name = "roleId", unique = true, nullable = false)
	public long getRoleId() {
		return roleId;
	}
	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}
	@Column(name = "roleName", columnDefinition = "varchar")
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	@Column(name = "description", columnDefinition = "varchar")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@OneToMany(cascade= CascadeType.ALL,fetch= FetchType.LAZY,mappedBy="role")
	@JoinColumn(name = "roleId")
	public Set<RoleModule> getRoleModules() {
		return roleModules;
	}

	public void setRoleModules(Set<RoleModule> roleModules) {
		this.roleModules = roleModules;
	}
	@OneToMany(cascade= CascadeType.ALL,fetch= FetchType.LAZY,mappedBy="role")
	@JoinColumn(name = "roleId")
	public Set<UserInfoRole> getUserInfoRoles() {
		return userInfoRoles;
	}

	public void setUserInfoRoles(Set<UserInfoRole> userInfoRoles) {
		this.userInfoRoles = userInfoRoles;
	}
}
