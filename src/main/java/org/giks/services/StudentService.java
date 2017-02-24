package org.giks.services;

import org.giks.commandobject.StudentCO;
import org.giks.daos.StudentDaoImpl;
import org.giks.serviceInterfaces.StudentServiceIn;
import org.giks.viewobject.HomePageVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements StudentServiceIn
{
	@Autowired
	private StudentDaoImpl studentDaoImpl;
	
	@Override
	public HomePageVO getStudentDetails(Long studentAdmissionNO) 
	{
		HomePageVO homePageVO = null;
		StudentCO studentCO = studentDaoImpl.getStudentDetails(studentAdmissionNO);
		if(studentCO != null)
		{
			homePageVO = new HomePageVO();
			homePageVO.setAdmissionNo(String.valueOf(studentCO.getAdmissionNo()));
			homePageVO.setStudentName(studentCO.getFirstName()+" "+studentCO.getMiddleName()+" "+studentCO.getLastName());
			homePageVO.setFatherName(studentCO.getFatherName());
			homePageVO.setStudentClass("IV");
			homePageVO.setStudentSection(studentCO.getSection());
		}
		return homePageVO;
	}

}
