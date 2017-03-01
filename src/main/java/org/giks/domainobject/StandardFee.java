package org.giks.domainobject;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.giks.compositekeys.StandardFeeId;
import org.giks.compositekeys.StudentFeeId;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "standard_fee")
public class StandardFee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public StandardFee() {
		// TODO Auto-generated constructor stub
	}
	
	@EmbeddedId
    private StandardFeeId id;
	
	@ManyToOne
    @MapsId("feeId")
    private Fee fee;
	
	@ManyToOne
    @MapsId("classId")
    private Standard standard;
	
	@Column(name = "description")
	private String description;

	public StandardFeeId getId() {
		return id;
	}

	public Fee getFee() {
		return fee;
	}

	public void setFee(Fee fee) {
		this.fee = fee;
	}

	public Standard getStandard() {
		return standard;
	}

	public void setStandard(Standard standard) {
		this.standard = standard;
	}

	public void setId(StandardFeeId id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
