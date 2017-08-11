package entity.authority;

import javax.persistence.*;

/**
 * Created by haigeek on 2017/7/11.
 */
@Entity
@Table(name = "rolemodule")
public class RoleModule implements java.io.Serializable {
    private static final long serialVersionUID = 1L;
    private Long id;
    private Role role;
    private Module module;

    @Id
    @Column(name = "id", unique = true, nullable = false)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "roleId")
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "moduleId")
    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
}
