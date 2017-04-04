package org.giks.services;


import java.util.Calendar;

import org.giks.commandobject.StudentCO;
import org.giks.daos.StudentDaoImpl;
import org.giks.serviceInterfaces.StudentServiceIn;
import org.giks.viewobject.HomePageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class StudentService implements StudentServiceIn
{
	@Autowired
	private StudentDaoImpl studentDaoImpl;
	
	@Override
	public HomePageVO getStudentDetails(HomePageVO homePageVO) 
	{
		
		StudentCO studentCO = new StudentCO(homePageVO);
		if(studentCO.validate())
		{
			if(!StringUtils.isEmpty(studentCO.getAdmissionNo()))
			{
				studentCO = studentDaoImpl.getStudentDetailsByAdmissionNo(studentCO);
				if(studentCO == null)
					homePageVO.setError("Record not found");
				else
				{
					homePageVO.setAdmissionNo(String.valueOf(studentCO.getAdmissionNo()));
					homePageVO.setFatherName(studentCO.getFatherName());
					homePageVO.setStudentSection(studentCO.getSection());
					homePageVO.setStudentClass(studentCO.getClassId());
					homePageVO.setStudentName(studentCO.getFirstName()+" "+studentCO.getLastName());
				}
			}else
			{
				studentCO.setClassId("1");
				if(studentDaoImpl.getStudentDetailsByname(studentCO).isEmpty())
					homePageVO.setError("Record not found");
				else if(studentDaoImpl.getStudentDetailsByname(studentCO).size()>1)
					homePageVO.setError("Multiple Record found.Please Provide Student Admission No.");
				else
				{
					studentCO = studentDaoImpl.getStudentDetailsByname(studentCO).get(0);
					
					homePageVO.setAdmissionNo(String.valueOf(studentCO.getAdmissionNo()));
					homePageVO.setStudentName(studentCO.getFirstName()+" "+studentCO.getLastName());
					homePageVO.setFatherName(studentCO.getFatherName());
					homePageVO.setStudentClass(studentCO.getClassId());
					homePageVO.setStudentSection(studentCO.getSection());
				}
			}
		}
		else
			homePageVO.setError("Validation failed.");
		return homePageVO;
	}

	@Override
	public String getAcademicSession() {
		Calendar now = Calendar.getInstance();
		Integer currentMonth = now.get(Calendar.MONTH) + 1;
		Integer currentYear = now.get(Calendar.YEAR);
		Integer sessionStartYear = currentYear;
		Integer sessionEndYear = currentYear;
		if(currentMonth < 4)
			--sessionStartYear;
		else
			++sessionEndYear;
		System.out.println("session : "+sessionStartYear + " - " + sessionEndYear);
		return sessionStartYear + " - " + sessionEndYear;
	}
	
}
