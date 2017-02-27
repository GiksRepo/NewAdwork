package org.giks.compositekeys;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.giks.domainobject.Enumeration;
import org.giks.domainobject.Fee;
import org.giks.domainobject.Student;
import org.giks.domainobject.Users;

public class UserRoleId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private Users user;
	
	@ManyToOne
	@JoinColumn(name = "enum_id")
	private Enumeration role;
	
	public UserRoleId() {
		// TODO Auto-generated constructor stub
	}
	
	public UserRoleId(Users user, Enumeration role) {
		// TODO Auto-generated constructor stub
		this.user = user;
		this.role = role;
	}

	
	
	public Users getUser() {
		return user;
	}

	public Enumeration getRole() {
		return role;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserRoleId)) return false;
        UserRoleId that = (UserRoleId) o;
        return Objects.equals(getUser(), that.getUser()) &&
                Objects.equals(getRole(), that.getRole());
    }
	
	@Override
    public int hashCode() {
        return Objects.hash(getUser(), getRole());
    }

}
