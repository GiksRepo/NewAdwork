package org.giks.domainobject;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	@Column(name = "id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "enum_id")
	private Enumeration categoryId;

	@Column(name = "percent")
	private Byte percent;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Set<Student> students;
	
	public Reservation() {
		// TODO Auto-generated constructor stub
	}
	
	

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public Enumeration getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Enumeration categoryId) {
		this.categoryId = categoryId;
	}

	public Byte getPercent() {
		return percent;
	}

	public void setPercent(Byte percent) {
		this.percent = percent;
	}
	
	
}
