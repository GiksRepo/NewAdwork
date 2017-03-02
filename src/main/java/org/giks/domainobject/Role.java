package org.giks.domainobject;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role {
 
    @Id
    @GeneratedValue
    @Column(name = "role_id")
    private Integer roleId;
     
    private String role;
     
    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name="user_roles",
    joinColumns={@JoinColumn(name="role_id", referencedColumnName="role_id")},
    inverseJoinColumns={@JoinColumn(name="user_id", referencedColumnName="user_id")})
    private List<Users> userList;
     
    
    public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public List<Users> getUserList() {
        return userList;
    }
    public void setUserList(List<Users> userList) {
        this.userList = userList;
    }
     
}
