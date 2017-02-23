package org.giks.domainobject;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "standard_fee")
public class StandardFee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private Long id;
	
	@OneToMany
	@JoinColumn(name = "class_id")
	private Standard classId;
	
	@OneToMany
	@JoinColumn(name = "fee_id")
	private Fee feeId;
}
