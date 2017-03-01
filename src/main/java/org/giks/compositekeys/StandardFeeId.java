package org.giks.compositekeys;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.giks.domainobject.Fee;
import org.giks.domainobject.Standard;
import org.giks.domainobject.Student;

@Embeddable
public class StandardFeeId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(name = "fee_id")
	private Long feeId;
	
	@Column(name = "class_id")
	private Long classId;

	public StandardFeeId(Long feeId, Long classId) {
		// TODO Auto-generated constructor stub
		this.feeId = feeId;
		this.classId = classId;
	}
	
	
	public Long getFeeId() {
		return feeId;
	}


	public Long getClassId() {
		return classId;
	}


	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StandardFeeId)) return false;
        StandardFeeId that = (StandardFeeId) o;
        return Objects.equals(getFeeId(), that.getFeeId()) &&
                Objects.equals(getClassId(), that.getClassId());
    }
	
	@Override
    public int hashCode() {
        return Objects.hash(getFeeId(), getClassId());
    }
}
