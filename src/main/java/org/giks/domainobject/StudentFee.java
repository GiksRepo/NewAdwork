package org.giks.domainobject;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.giks.compositekeys.StudentFeeId;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "student_fee")
public class StudentFee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
    private StudentFeeId id;
	
	@ManyToOne
    @MapsId("feeId")
    private Fee fee;
	
	@ManyToOne
    @MapsId("studentId")
    private Student student;
	
	@Column(name = "description")
	private String description;
	
	public StudentFee() {
		// TODO Auto-generated constructor stub
	}

	
	public StudentFeeId getId() {
		return id;
	}


	public void setId(StudentFeeId id) {
		this.id = id;
	}


	public Fee getFee() {
		return fee;
	}


	public void setFee(Fee fee) {
		this.fee = fee;
	}


	public Student getStudent() {
		return student;
	}


	public void setStudent(Student student) {
		this.student = student;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	
}
