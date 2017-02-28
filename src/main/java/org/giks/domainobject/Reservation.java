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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "category_id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "enum_id")
	private Enumeration category;

	@Column(name = "percent")
	private Byte percent;
	
	@OneToMany(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
	private Set<Student> students;  
	
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	
	public Reservation() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Enumeration getCategory() {
		return category;
	}

	public void setCategory(Enumeration category) {
		this.category = category;
	}

	public Byte getPercent() {
		return percent;
	}

	public void setPercent(Byte percent) {
		this.percent = percent;
	}
	
	
}
