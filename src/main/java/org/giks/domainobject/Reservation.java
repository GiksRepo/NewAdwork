package org.giks.domainobject;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@javax.persistence.Id
	@Column
	private Long Id;
	
	@OneToOne
	@JoinColumn(name = "category_id")
	private Enumeration categoryId;

	@Column(name = "percent")
	private Byte percent;
}
