package org.giks.commandobject;

import java.util.Set;

import org.giks.domainobject.Student;

public class ReservationCO 
{
	private Long id;
	private EnumerationCO category;
	private Byte percent;
	private Set<Student> students;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public EnumerationCO getCategory() {
		return category;
	}
	public void setCategory(EnumerationCO category) {
		this.category = category;
	}
	public Byte getPercent() {
		return percent;
	}
	public void setPercent(Byte percent) {
		this.percent = percent;
	}
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	} 
}
