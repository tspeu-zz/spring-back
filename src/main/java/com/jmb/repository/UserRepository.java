package com.jmb.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jmb.entity.User;

@Repository("userRepository")
public interface UserRepository  extends JpaRepository<User, Serializable>{
	
	//llamar desde el servicio para busacar un usuraio por useraname
	public abstract User findUserByUsername(String username);

}
