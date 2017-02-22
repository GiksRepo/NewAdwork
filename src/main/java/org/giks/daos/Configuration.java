package org.giks.daos;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

interface ConfigurationIn
{
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void addPrint();
}
//Class to be deleted
@Component
public class Configuration implements ConfigurationIn
{
	public void addPrint()
	{
		System.out.println("Admin access only");
	}
}
