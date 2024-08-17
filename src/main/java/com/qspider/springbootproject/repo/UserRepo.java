package com.qspider.springbootproject.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qspider.springbootproject.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	@Query("select u from User u where u.gender= ?1")
	public List<User> findUserBygender(String gender);
	

}
