package org.giks.compositekeys;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.giks.domainobject.Fee;
import org.giks.domainobject.Standard;
import org.giks.domainobject.Student;

@Embeddable
public class StudentFeeId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "fee_id")
	private Fee fee;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id")
	private Student student;
	
	public StudentFeeId() {
		// TODO Auto-generated constructor stub
	}
	
	public StudentFeeId(Fee fee, Student student) {
		// TODO Auto-generated constructor stub
		this.fee = fee;
		this.student = student;
	}

	
	
	public Fee getFee() {
		return fee;
	}

	public Student getStudent() {
		return student;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentFeeId)) return false;
        StudentFeeId that = (StudentFeeId) o;
        return Objects.equals(getFee(), that.getFee()) &&
                Objects.equals(getStudent(), that.getStudent());
    }
	
	@Override
    public int hashCode() {
        return Objects.hash(getFee(), getStudent());
    }

}
