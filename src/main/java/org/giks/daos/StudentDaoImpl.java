package org.giks.daos;

import org.giks.commandobject.StudentCO;
import org.springframework.stereotype.Repository;

interface StudentDaoIn
{
	public StudentCO getStudentDetails(Long studentAdmissionNO);
}

@Repository
public class StudentDaoImpl implements StudentDaoIn
{

	@Override
	public StudentCO getStudentDetails(Long studentAdmissionNO) 
	{
		StudentCO student = new StudentCO();
		student.setAdmissionNo(studentAdmissionNO);
		student.setFirstName("Ravi");
		student.setMiddleName("Kumar");
		student.setLastName("Sharma");
		student.setSection("A");
		student.setFatherName("Ajay Kumar Sharma");
		
		return student;
	}

}
