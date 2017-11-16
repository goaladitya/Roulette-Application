package com.nagarro.casinoadmin.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.casinoadmin.models.User;

@Repository
public interface UserDao extends CrudRepository<User , Long>{

	public List<User> findByNameOrContactOrEmail(String name, Long contact, String email);
	
}
