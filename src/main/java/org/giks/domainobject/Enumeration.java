package org.giks.domainobject;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "enumeration")
public class Enumeration implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private Long id;
	
	@Column(name = "enum_id")
	private String enumId;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "description")
	private String description;
}
