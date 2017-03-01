package org.giks.compositekeys;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.giks.domainobject.Fee;
import org.giks.domainobject.Standard;
import org.giks.domainobject.Student;

public class StandardFeeId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "fee_id")
	private Fee fee;
	
	@ManyToOne
	@JoinColumn(name = "class_id")
	private Standard standard;
	
	public StandardFeeId() {
		// TODO Auto-generated constructor stub
	}
	
	public StandardFeeId(Fee fee, Standard standard) {
		// TODO Auto-generated constructor stub
		this.fee = fee;
		this.standard = standard;
	}

	
	public Fee getFee() {
		return fee;
	}

	public Standard getStandard() {
		return standard;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StandardFeeId)) return false;
        StandardFeeId that = (StandardFeeId) o;
        return Objects.equals(getFee(), that.getFee()) &&
                Objects.equals(getStandard(), that.getStandard());
    }
	
	@Override
    public int hashCode() {
        return Objects.hash(getFee(), getStandard());
    }

}
