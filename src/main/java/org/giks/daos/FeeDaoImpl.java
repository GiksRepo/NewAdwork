package org.giks.daos;

import java.util.Calendar;

import org.giks.commandobject.StudentCO;
import org.giks.config.ApplicationStartUp;
import org.giks.domainobject.Student;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

interface FeeDaoIn{
	public Integer getFromFeeMonth(Long admissionNo);
}

@Repository
public class FeeDaoImpl implements FeeDaoIn{
	@Autowired
	private ApplicationStartUp applicationStartUp;
	@Override
	public Integer getFromFeeMonth(Long admissionNo) {
		Integer fromMonth = 0;
		Session session = null;
		 try {
			 session = applicationStartUp.getSessionFactory().openSession();
			 session.beginTransaction();
			 Student student = session.get(Student.class, admissionNo);
			 if(student != null){
				 Calendar now = Calendar.getInstance();
				    // 
				    System.out.println("Current Year is : " + now.get(Calendar.YEAR));
				    // month start from 0 to 11
				    System.out.println("Current Month is : " + (now.get(Calendar.MONTH) + 1));
				    System.out.println("Current Date is : " + now.get(Calendar.DATE));
				    fromMonth = now.get(Calendar.MONTH) + 1;
			 }
				 
		} catch (Exception e) {
			e.printStackTrace();
			fromMonth = -1;
		}
		 finally
		 {
			 if(session != null)
				 session.close();
		 }
		return fromMonth;
	}

}
