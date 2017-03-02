package org.giks.config.dao;

import java.util.List;

import org.giks.config.ApplicationStartUp;
import org.giks.domainobject.Users;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

interface UserAuthDao
{
	public Users getUserCredentials(String loginId);
}


public class UserAuthDaoImpl implements UserAuthDao
{
	private static final Logger logger = LoggerFactory.getLogger(UserAuthDaoImpl.class);
			
	@Autowired
	private ApplicationStartUp applicationStartUp;
	
	public UserAuthDaoImpl() 
	{
		logger.info("UserAuthDaoImpl constructor");
	}


	@Override
	public Users getUserCredentials(String loginId) 
	{
		Users user = null;
		Session session = null;
		if(applicationStartUp == null)
			logger.info("applicationStartUp is null");
		try
		{
			SessionFactory sessionFactory = applicationStartUp.getSessionFactory();
			session = sessionFactory.openSession();
			Criteria criteria = session.createCriteria(Users.class);
			criteria.add(Restrictions.eq("loginId", loginId));
			user = (Users)criteria.uniqueResult();
		}
		catch(Exception e)
		{
			logger.info("Error occured getUserCredentials "+e.getMessage());
		}
		finally 
		{
			if(session != null)
			{
				session.flush();
				session.close();
			}
		}
		return user;
	}

}
