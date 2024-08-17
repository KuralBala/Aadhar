package com.qspider.springbootproject.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qspider.springbootproject.entity.User;
import com.qspider.springbootproject.repo.UserRepo;

@Repository
public class UserDao {
	
	@Autowired
	UserRepo urepo;
	
	public User saveUser(User user) {
		return urepo.save(user);
		
	}
	
	public User findUserById(int id) {
		Optional<User> optionalUser=urepo.findById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}
		return null;
	}
	
	public User deleteById(int id) {
		User user=findUserById(id);
		if(user!=null) {
			urepo.delete(user);
			return user;
		}
		return null;
	}
	
	public User updateUser(User user, int id) {
		User dbuser=findUserById(id);
		if(dbuser!=null) {
			user.setUid(id);
			return urepo.save(user);
		}
		return null;
	}
	
	public List<User>findAll(){
		return urepo.findAll();
		
	}


}
