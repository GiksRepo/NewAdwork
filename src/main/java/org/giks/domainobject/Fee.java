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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "fee")
public class Fee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	@Column(name = "fee_id")
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "enum_id")
	private Enumeration feeType;
	
	@Column(name = "amount")
	private Long amount;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="student_fees",
	joinColumns={@JoinColumn(name="fee_id", referencedColumnName="fee_id")},
	inverseJoinColumns={@JoinColumn(name="student_id", referencedColumnName="student_id")})
	private Set<Student> students;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="standard_fees",
	joinColumns={@JoinColumn(name="fee_id", referencedColumnName="fee_id")},
	inverseJoinColumns={@JoinColumn(name="class_id", referencedColumnName="class_id")})
	private Set<Standard> standards;
	
	public Set<Standard> getStandards() {
		return standards;
	}



	public void setStandards(Set<Standard> standards) {
		this.standards = standards;
	}



	public Fee() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Set<Student> getStudents() {
		return students;
	}



	public void setStudents(Set<Student> students) {
		this.students = students;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Enumeration getFeeType() {
		return feeType;
	}

	public void setFeeType(Enumeration feeType) {
		this.feeType = feeType;
	}

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}
	

}
