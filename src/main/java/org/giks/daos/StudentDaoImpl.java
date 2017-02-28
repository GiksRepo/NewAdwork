package org.giks.daos;

import org.giks.commandobject.StudentCO;
import org.giks.config.ApplicationStartUp;
import org.giks.domainobject.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

interface StudentDaoIn
{
	public StudentCO getStudentDetailsByAdmissionNo(StudentCO studentCO);
}

@Repository
public class StudentDaoImpl implements StudentDaoIn
{
	@Autowired
	private ApplicationStartUp applicationStartUp;
	@Override
	public StudentCO getStudentDetailsByAdmissionNo(StudentCO studentCO) 
	{
		Long admissonNo = studentCO.getAdmissionNo();
		 try {
			 Session session = applicationStartUp.getSessionFactory().openSession();
			 session.beginTransaction();
			 Student student = session.get(Student.class, admissonNo);
			 if(student != null)
				 studentCO = new StudentCO(student);
			 else
				 studentCO = null;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentCO;
	}

}
