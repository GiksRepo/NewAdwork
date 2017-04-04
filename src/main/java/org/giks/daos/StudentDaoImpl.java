package org.giks.daos;

import java.util.List;

import org.giks.commandobject.StudentCO;
import org.giks.config.ApplicationStartUp;
import org.giks.domainobject.Student;
import org.giks.util.MiscUtility;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

interface StudentDaoIn
{
	public StudentCO getStudentDetailsByAdmissionNo(StudentCO studentCO);
	public List<StudentCO> getStudentDetailsByname(StudentCO studentCO);
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
		Session session = null;
		 try {
			 session = applicationStartUp.getSessionFactory().openSession();
			 session.beginTransaction();
			 Student student = session.get(Student.class, admissonNo);
			 if(student != null)
				 studentCO = new StudentCO(student);
			 else
				 studentCO = null;
		} catch (Exception e) {
			e.printStackTrace();
		}
		 finally
		 {
			 if(session != null)
				 session.close();
		 }
		return studentCO;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<StudentCO> getStudentDetailsByname(StudentCO studentCO) 
	{
		String studentName = studentCO.getFirstName();
		String fatherName = studentCO.getFatherName();
		String section = studentCO.getSection();
		Session session = null;
		List<StudentCO> listOfStudent = null;
		try{
			session = applicationStartUp.getSessionFactory().openSession();
			session.beginTransaction();

			Criteria criteria = session.createCriteria(Student.class);
			Criterion conditions1 = Restrictions.ilike("firstName", studentName);
			Criterion conditions2 = Restrictions.ilike("fatherName", fatherName);
			Criterion conditions3 = Restrictions.ilike("section", section);
			
			
			criteria.add(Restrictions.conjunction().add(conditions1).add(conditions2).add(conditions3));
			listOfStudent = MiscUtility.convertDomainToCommandObject((List<Student>)criteria.list());
		}catch (Exception e) {
			e.printStackTrace();
		}
		 finally
		 {
			 if(session != null)
				 session.close();
		 }
		return listOfStudent;
	}

}
