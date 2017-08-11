package entity.authority;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "module")
public class Module implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private long moduleId;
	private String moduleName,description,url;
	private Set<RoleModule> roleModules;
	@Id
	@Column(name = "moduleId", unique = true, nullable = false)
	public long getModuleId() {
		return moduleId;
	}
	public void setModuleId(long moduleId) {
		this.moduleId = moduleId;
	}
	@Column(name = "moduleName", columnDefinition = "varchar")
	public String getModuleName() {
		return moduleName;
	}
	public void setModuleName(String moduleName) {
		this.moduleName = moduleName;
	}
	@Column(name = "description", columnDefinition = "varchar")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Column(name = "url", columnDefinition = "varchar")
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	@OneToMany(cascade= CascadeType.ALL,fetch= FetchType.LAZY,mappedBy="module")
	public Set<RoleModule> getRoleModules() {
		return roleModules;
	}
	public void setRoleModules(Set<RoleModule> roleModules) {
		this.roleModules = roleModules;
	}
}
