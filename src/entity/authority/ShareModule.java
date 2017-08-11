package entity.authority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sharemodule")
public class ShareModule implements java.io.Serializable{
	private static final long serialVersionUID = 1L;
	private long moduleId;
	private String moduleName,description,url;
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
}
