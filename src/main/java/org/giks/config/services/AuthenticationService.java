package org.giks.config.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.giks.config.dao.UserAuthDaoImpl;
import org.giks.domainobject.Role;
import org.giks.domainobject.Users;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.StringUtils;


public class AuthenticationService implements UserDetailsService
{	
	private static final Logger logger = LoggerFactory.getLogger(AuthenticationService.class);
	
	@Autowired
	private UserAuthDaoImpl userAuthDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		logger.info("Authentication of user... username : "+username);
		Users user = null;
		Set<Role> userRoles = null;
		User springUser = null;
		try 
		{
			user = userAuthDao.getUserCredentials(username);
			userRoles = user.getRole();
			//String userAuthorities = null;
			List<GrantedAuthority> roleArr = new ArrayList<GrantedAuthority>();
			if(userRoles !=null && !userRoles.isEmpty())
			{
				
				for(Role roleTemp:userRoles)
					roleArr.add(new SimpleGrantedAuthority(roleTemp.getRole()));
				//userAuthorities = StringUtils.arrayToCommaDelimitedString(roleArr.toArray());
			}
			if (StringUtils.isEmpty(user.getLogin())) 
			{
				logger.info("Authentication Fail username : "+username);
		        throw new UsernameNotFoundException("Invalid username/password.");
		    }
		    //Collection<? extends GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(roleArr.get(0));
		    		springUser = new User(user.getLogin(), user.getPassword(), roleArr);
			
		    logger.info("user_id : "+user.getLogin());
		    logger.info("Role : "+user.getPassword());			
		} 
		catch (Exception e) 
		{
			logger.error("UserAuthDaoImpl is Null :"+e.getMessage());
		}	
		
	    return springUser;
	}

}
