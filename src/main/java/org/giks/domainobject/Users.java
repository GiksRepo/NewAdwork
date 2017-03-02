package org.giks.domainobject;

import java.util.Set;

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
@Table(name="users")
public class Users {
 
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long userId;
     
    private String login;
     
    private String password;
     
    @OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name="user_roles",
    joinColumns={@JoinColumn(name="user_id", referencedColumnName="user_id")},
    inverseJoinColumns={@JoinColumn(name="role_id", referencedColumnName="role_id")})
    private Set<Role> role;
     
    public Users(String login, String password) {
        this.login = login;
        this.password = password;
    }
 
    
 
    public Long getUserId() {
		return userId;
	}



	public void setUserId(Long userId) {
		this.userId = userId;
	}



	public String getLogin() {
        return login;
    }
 
    public void setLogin(String login) {
        this.login = login;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }



	public Set<Role> getRole() {
		return role;
	}



	public void setRole(Set<Role> role) {
		this.role = role;
	}

     
}