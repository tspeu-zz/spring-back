package com.jmb.services.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//import com.jmb.entity.CustomUserDetail;
//import com.jmb.entity.User;
import com.jmb.entity.UserRole;
import com.jmb.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserDetailsService{

	@Autowired
	@Qualifier("userRepository")
	private UserRepository userRepository;
	
	//@Autowired
//	private CustomUserDetail customUserDetail;
	
//	private static final Log LOG = LogFactory.getLog(UserServiceImpl.class);
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		com.jmb.entity.User user = userRepository.findUserByUsername(username);
		List<GrantedAuthority> authorities = buildAuthorities(user.getUserRole());
		return buildUser(user, authorities);
	}

	private UserDetails buildUser(com.jmb.entity.User  user, List<GrantedAuthority> authorities) {
		
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.isEnabled(), true, true, true, authorities);
	}

	private List<GrantedAuthority> buildAuthorities(Set<UserRole> userRoles) {
		Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
		for (UserRole userRole : userRoles) {
			auths.add(new SimpleGrantedAuthority(userRole.getRole()));
		}
		return new ArrayList<GrantedAuthority>(auths);
	}
	
	
	
	
	
	/*
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		LOG.info("-->loadUserByUsername() username: " + username);
		
		
		//buscar el usuario por name y tra un User y hauy que convertirla a un objeto UserDatail	
		 com.jmb.entity.User user = userRepository.findUserByUsername(username);
		
		//LOG.info(" -->loadUserByUsername() USER: " + user.toString());
		
		List<GrantedAuthority> auth = buildAuth(user.getUserrole());
		
		//LOG.info(" -->loadUserByUsername() auth: " + auth.toString());
		
		//customUserDetail = null;	 
		 
		//customUserDetail.setUser(buildUser(user, auth));
		
		LOG.info(" -->loadUserByUsername() customUserDetail: " + customUserDetail.toString());
		
//		customUserDetail.setAuthorities((Set<GrantedAuthority>) auth);
		
//		return  customUserDetail;
		return buildUser(user, auth);
	}
	
	
	
														//ROLES objeto de entity security y son los roles
	public UserDetails buildUser(com.jmb.entity.User user, List<GrantedAuthority> authorities) {
		
		
		
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.isEnabled(),true, true, true, authorities);
				//new User(user.getUsername(), user.getPassword(), user.isEnabled(), user.getUserrole());
				//(user.getUsername(), user.getPassword(), user.isEnabled(), auth);

	}

	//convierte los roles Set<UserRole> userrole a una lista de objetos GrantedAuthority
	public List<GrantedAuthority> buildAuth( Set<UserRole> userroles) {
		
//		Set<GrantedAuthority> auths = new HashSet<GrantedAuthority>();
		List<GrantedAuthority>auths = new ArrayList<>();
		auths.add(new SimpleGrantedAuthority("ROLE_USER"));
	
		/*
		for (UserRole userrole : userroles ) {
			
//			auths.add(new GrantedAuthorityDefaults("ROLE_USER"));
//			auths.add(new SimpleGrantedAuthority(userrole.getRole()));
			auths.add(new SimpleGrantedAuthority("ROLE_USER"));
			
			//role_name.add(new GrantedAuthorityDefaults(userrole.getRole()));
		} 
			*/
	/*
		return new ArrayList<GrantedAuthority>(auths);
	}
	*/
}
//$2a$10$eZV4IaGAo3UechnHeO71ZOyGWBQTANAJqGcd9jzqVXnR8hHTfrkZC