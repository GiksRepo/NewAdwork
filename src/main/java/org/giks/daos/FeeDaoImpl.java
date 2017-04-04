package org.giks.daos;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.giks.commandobject.StudentCO;
import org.giks.config.ApplicationStartUp;
import org.giks.domainobject.Fee;
import org.giks.domainobject.Payment;
import org.giks.domainobject.Standard;
import org.giks.domainobject.Student;
import org.giks.viewobject.PayMonthVO;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

interface FeeDaoIn{
	public Integer getFromFeeMonth(Long admissionNo);
	public Map<String, String> getAllFees(PayMonthVO monthVO);
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
				 Integer sessionStartYear = currentYear;
				 if(currentMonth < 4)
					 sessionStartYear = currentYear - 1;
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
	@Override
	public Map<String, String> getAllFees(PayMonthVO monthVO) {
		// TODO Auto-generated method stub
		Map <String, String> allFees = new LinkedHashMap<>();
		Long admissionNo = Long.valueOf(monthVO.getAdmissionNo());
		Long feeAmount = 0L;
		Integer fromMonth = syncMonth(getFromFeeMonth(admissionNo));
		System.out.println("toMonth "+monthVO.getToMonth());
		Integer toMonth = Integer.valueOf(monthVO.getToMonth());
		System.out.println("fromMonth "+fromMonth+" toMonth "+toMonth);
		Session session = null;
		Integer numberOfMonths = toMonth - fromMonth;
		++numberOfMonths;
		try {
			 session = applicationStartUp.getSessionFactory().openSession();
			 session.beginTransaction();
			 Student student = session.get(Student.class, admissionNo);
			 Standard standard = null;
			 if(student != null){
				standard = student.getStandard();
				Set<Fee> fees = new HashSet<>(student.getFees());
				Iterator<Fee> it = fees.iterator();
					while(it.hasNext())
					{
						Fee sf = it.next();
						feeAmount += sf.getAmount();
						allFees.put(sf.getFeeType().getDescription(), String.valueOf(sf.getAmount()) + " * "+numberOfMonths);
					}
					
					Set<Fee> classFees = new HashSet<>(standard.getFees());
					Iterator<Fee> it1 = classFees.iterator();
						while(it1.hasNext())
						{
							Fee sf = it1.next();
							feeAmount += sf.getAmount();
							allFees.put(sf.getFeeType().getDescription(), String.valueOf(sf.getAmount()) + " * "+numberOfMonths);
						}
						allFees.put("Total Fee", String.valueOf(feeAmount * numberOfMonths));
				
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
		return allFees;
	}
	
	private Integer syncMonth(Integer monthFromDB){
		if(monthFromDB < 4)
			monthFromDB += 12;
		return monthFromDB;
	}
	
}
