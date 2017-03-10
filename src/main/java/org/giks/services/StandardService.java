package org.giks.services;

import java.util.Map;

import org.giks.daos.StandardDaoImpl;
import org.giks.serviceInterfaces.StandardServiceIn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StandardService implements StandardServiceIn
{
	@Autowired
	public StandardDaoImpl standardDaoImpl;
	
	@Override
	public Map<Long, String> getAllStandard() 
	{
		return standardDaoImpl.getAllStandardList();
	}

}
