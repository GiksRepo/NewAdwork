package org.giks.domainobject;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.giks.compositekeys.StudentFeeId;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "user_roles")
public class UserRoles implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
    private StudentFeeId id;
	
	@Column(name = "description")
	private String description;

	public StudentFeeId getId() {
		return id;
	}

	public void setId(StudentFeeId id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
