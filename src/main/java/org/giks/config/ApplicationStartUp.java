package org.giks.config;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.giks.domainobject.Enumeration;
import org.giks.domainobject.Fee;
import org.giks.domainobject.Reservation;
import org.giks.domainobject.Standard;
import org.giks.domainobject.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ApplicationStartUp 
{
	private EntityManagerFactory entityManagerFactory;
	private SessionFactory sessionFactory;
	private static final Logger logger = LoggerFactory.getLogger(ApplicationStartUp.class);
	
	public void initIt() throws Exception
	{
		logger.info("Intializing Start");
		if(entityManagerFactory == null)
		{
			entityManagerFactory = Persistence.createEntityManagerFactory("feePaymentPortal");
			sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
			
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			transaction.begin();
			
			Enumeration enumeration = new Enumeration();
			enumeration.setEnumId("TUTION_FEE");
			enumeration.setType("Fee");
			enumeration.setDescription("Tution Fee");
			session.persist(enumeration);
			
			Enumeration enumeration2 = new Enumeration();
			enumeration2.setEnumId("GENERAL");
			enumeration2.setType("CATEGORY");
			enumeration2.setDescription("General");
			session.persist(enumeration2);
			
			Enumeration enumeration3 = new Enumeration();
			enumeration3.setEnumId("TRANSPORTATION_FEE");
			enumeration3.setType("Fee");
			enumeration3.setDescription("Transportation Fee");
			session.persist(enumeration3);
			
			Enumeration enumeration4 = new Enumeration();
			enumeration4.setEnumId("ADMISSION_FEE");
			enumeration4.setType("Fee");
			enumeration4.setDescription("Admission Fee");
			session.persist(enumeration4);
			
			Reservation reservation = new Reservation();
			reservation.setCategory(enumeration2);
			reservation.setPercent(Byte.valueOf("10"));
			session.persist(reservation);
			
			Set<Fee> feesSet = new HashSet<>();
			
			Fee fee = new Fee();
			fee.setAmount(8000L);
			fee.setFeeType(enumeration);
			session.persist(fee);
			
			Fee fee2 = new Fee();
			fee2.setAmount(800L);
			fee2.setFeeType(enumeration3);
			session.persist(fee2);
			
			Fee fee3 = new Fee();
			fee3.setAmount(1000L);
			fee3.setFeeType(enumeration4);
			session.persist(fee3);
			
			Standard standard = new Standard();
			standard.setDescription("Class 1");
			standard.setName("Class 1");
			feesSet.add(fee3);
			standard.setFees(feesSet);
			session.persist(standard);
			
			Standard standard2 = new Standard();
			standard2.setDescription("Class 2");
			standard2.setName("Class 2");
			//standard2.setFees(feesSet);
			session.persist(standard2);
			
			/*Standard standard3 = new Standard();
			standard3.setDescription("Class 3");
			standard3.setName("Class 3");
			standard3.setFees(feesSet);
			session.persist(standard3);*/
			
			Set<Fee> feesSet2 = new HashSet<>();
			feesSet2.add(fee);
			feesSet2.add(fee2);
			
			Student student = new Student();
			student.setAdmissionNo(1L);
			student.setFirstName("Aman");
			student.setLastName("Nan");
			student.setCategory(reservation);
			student.setSection("A");
			student.setFatherName("Fname");
			student.setStandard(standard);
			student.setFees(feesSet2);
			session.persist(student);
						
			transaction.commit();
			session.close();
		}
	}
	
	
	public SessionFactory getSessionFactory() throws Exception
	{
		logger.info("Creating Hibernate Session Factory");
		
		if(entityManagerFactory == null)
			entityManagerFactory = Persistence.createEntityManagerFactory("feePaymentPortal");
		if(sessionFactory == null)
			sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		
		return sessionFactory;
	}
	
	public void cleanUp() throws Exception
	{
		logger.info("Clean up start");
		if(entityManagerFactory != null)
			entityManagerFactory.close();
		if(sessionFactory != null)
			sessionFactory.close();
	}
}
