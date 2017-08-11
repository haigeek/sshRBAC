package entity.authority;

import javax.persistence.*;

/**
 * Created by haigeek on 2017/8/4.
 */
@Entity
@Table(name = "userinforole")
public class UserInfoRole implements java.io.Serializable{
    private static final long serialVersionUID = 1L;
    private long urid;
    private UserInfo userInfo;
    private Role role;
    private String loginId;
    @Id
    @Column(name = "urid", unique = true, nullable = false)
    public long getUrid() {
        return urid;
    }

    public void setUrid(long urid) {
        this.urid = urid;
    }
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "roleId")
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    @Column(name = "loginId", columnDefinition = "varchar")
    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }
}
