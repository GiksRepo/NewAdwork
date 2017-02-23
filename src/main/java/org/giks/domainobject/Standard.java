package org.giks.domainobject;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "standard")
public class Standard implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "fee_id")
	private Long feeId;
	
	@Column(name = "fee_type")
	private String feeType;
	
	@Column(name = "amount")
	private Long amount;
}
