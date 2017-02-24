package org.giks.compositekeys;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.giks.domainobject.Fee;
import org.giks.domainobject.Standard;
import org.giks.domainobject.Student;

@Embeddable
public class StudentFeeId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "fee_id")
	private Fee feeId;
	
	@Column(name = "student_id")
	private Student studentId;
	
	public StudentFeeId() {
		// TODO Auto-generated constructor stub
	}
	
	public StudentFeeId(Fee classId, Student studentId) {
		// TODO Auto-generated constructor stub
		this.feeId = classId;
		this.studentId = studentId;
	}

	public Fee getFeeId() {
		return feeId;
	}

	public Student getStudentId() {
		return studentId;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentFeeId)) return false;
        StudentFeeId that = (StudentFeeId) o;
        return Objects.equals(getFeeId(), that.getFeeId()) &&
                Objects.equals(getStudentId(), that.getStudentId());
    }
	
	@Override
    public int hashCode() {
        return Objects.hash(getFeeId(), getStudentId());
    }

}
