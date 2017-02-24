package org.giks.compositekeys;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;

import org.giks.domainobject.Fee;
import org.giks.domainobject.Standard;
import org.giks.domainobject.Student;

public class StandardFeeId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "fee_id")
	private Fee feeId;
	
	@Column(name = "class_id")
	private Standard classId;
	
	public StandardFeeId() {
		// TODO Auto-generated constructor stub
	}
	
	public StandardFeeId(Fee feeId, Standard classId) {
		// TODO Auto-generated constructor stub
		this.feeId = feeId;
		this.classId = classId;
	}

	public Fee getFeeId() {
		return feeId;
	}

	public Standard getStandardId() {
		return classId;
	}
	
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentFeeId)) return false;
        StudentFeeId that = (StudentFeeId) o;
        return Objects.equals(getFeeId(), that.getFeeId()) &&
                Objects.equals(getStandardId(), that.getStudentId());
    }
	
	@Override
    public int hashCode() {
        return Objects.hash(getFeeId(), getStandardId());
    }

}
