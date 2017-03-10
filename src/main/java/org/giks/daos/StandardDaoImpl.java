package org.giks.daos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.giks.config.ApplicationStartUp;
import org.giks.domainobject.Standard;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

interface StandardDaoIn
{
	public Map<Long,String> getAllStandardList();
}

@Repository
public class StandardDaoImpl implements StandardDaoIn
{
	@Autowired
	private ApplicationStartUp applicationStartUp;
	
	@Override
	public Map<Long, String> getAllStandardList() 
	{
		Session session = null;
		Map<Long,String> standardList = null;
		try
		{
			 session = applicationStartUp.getSessionFactory().openSession();
			 session.beginTransaction();
			 Criteria criteria = session.createCriteria(Standard.class);
			 List<Standard> listOfStandard = criteria.list();
			 if(!listOfStandard.isEmpty())
			 {
				 standardList = new HashMap<>();
				 for(Standard standard : listOfStandard)
					 standardList.put(standard.getClassId(), standard.getName());
			 }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(session != null)
				session.close();
		}
		
		return standardList;
	}
}
