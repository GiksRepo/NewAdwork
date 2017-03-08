package org.giks.util;

import java.util.ArrayList;
import java.util.List;

import org.giks.commandobject.StudentCO;
import org.giks.domainobject.Student;

public class MiscUtility 
{
	public static List<StudentCO> convertDomainToCommandObject(List<Student> listOfStudent)
	{
		List<StudentCO> listOfStudentCO = null;
		if(listOfStudent != null)
		{
			listOfStudentCO = new ArrayList<StudentCO>();
			for(Student student : listOfStudent)
			{
				StudentCO studentCO = new StudentCO();
				studentCO.setAdmissionNo(student.getAdmissionNo());
				studentCO.setFirstName(student.getFirstName());
				studentCO.setMiddleName(student.getMiddleName());
				studentCO.setLastName(student.getLastName());
				studentCO.setFatherName(student.getFatherName());
				studentCO.setAddress(student.getAddress());
				studentCO.setClassId(student.getStandard().getName());
				studentCO.setDateOfBirth(student.getDateOfBirth());
				studentCO.setSection(student.getSection());
				listOfStudentCO.add(studentCO);
			}
		}
		return listOfStudentCO;
	}
}
