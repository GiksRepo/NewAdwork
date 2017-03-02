package org.giks.domainobject;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "standard")
public class Standard implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "class_id")
	private Long classId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "class_id")
	private Set<Student> students;  
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="standard_fees",
	joinColumns={@JoinColumn(name="class_id", referencedColumnName="class_id")},
	inverseJoinColumns={@JoinColumn(name="fee_id", referencedColumnName="fee_id")})
	private Set<Fee> Fees;
	
	
	

	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}

	public Set<Fee> getFees() {
		return Fees;
	}

	public void setFees(Set<Fee> fees) {
		Fees = fees;
	}

	public Standard() {
		// TODO Auto-generated constructor stub
	}

	public Long getClassId() {
		return classId;
	}

	public void setClassId(Long classId) {
		this.classId = classId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
}