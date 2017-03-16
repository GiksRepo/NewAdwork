package org.giks.daos;

import java.util.Calendar;
import java.util.List;

import org.giks.commandobject.StudentCO;
import org.giks.config.ApplicationStartUp;
import org.giks.domainobject.Payment;
import org.giks.domainobject.Student;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
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
				 Criteria criteria = session.createCriteria(Payment.class);
				 criteria.add(Restrictions.eq("student", student));
				 criteria.addOrder(Order.desc("paymentDate"));
				 List<Payment> payments = criteria.list();
				 if(payments != null && payments.size()>0)
					 fromMonth = payments.get(0).getPaymentTo() + 1;
				 else
					 fromMonth = 4;
				 Calendar now = Calendar.getInstance();
				 Integer currentMonth = now.get(Calendar.MONTH) + 1;
				 Integer currentYear = now.get(Calendar.YEAR);
				 if(currentMonth < 4)
				 	currentYear--;
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
