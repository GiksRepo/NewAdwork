package org.giks.services;

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
			if(StringUtils.isEmpty(studentCO.getAdmissionNo()))
			{
				studentCO = studentDaoImpl.getStudentDetailsByAdmissionNo(studentCO);
				if(StringUtils.isEmpty(String.valueOf(studentCO.getAdmissionNo())))
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
				homePageVO.setError("under construction");
			}
		}
		else
			homePageVO.setError("Validation failed.");
		return homePageVO;
	}

}
