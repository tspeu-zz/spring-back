package com.jmb.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

//import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "users")
public class User {

	@Id
	@Column(name= "username", unique=true, nullable= false, length=45)
	private String username;
	
	@Column(name ="password" , unique=false, length=60)
	private String password;
	
	@Column(name="enabled", nullable = false)
	private boolean enabled;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "user" )
	private Set<UserRole> userRole = new HashSet<UserRole>();

	public User() {
	}

	public User(String name, String password, boolean enabled) {
		super();
		this.username = name;
		this.password = password;
		this.enabled = enabled;
	}

	public User(String name, String password, boolean enabled, Set<UserRole> userRole) {
		super();
		this.username = name;
		this.password = password;
		this.enabled = enabled;
		this.userRole = userRole;
	}


	public String getUsername() {
		return username;
	}

	public void setName(String name) {
		this.username = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<UserRole> getUserRole() {
		return userRole;
	}

	public void setUserRole(Set<UserRole> userrole) {
		this.userRole = userrole;
	}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", enabled=" + enabled + ", userRole="
				+ userRole + "]";
	}
	
	

}
