package com.qspider.springbootproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.qspider.springbootproject.entity.Aadhar;
import com.qspider.springbootproject.dao.AadharDao;
import com.qspider.springbootproject.dao.UserDao;
import com.qspider.springbootproject.entity.User;
import com.qspider.springbootproject.exception.AadharNotFoundException;
import com.qspider.springbootproject.exception.UserNotFound;
import com.qspider.springbootproject.repo.AadharRepo;
import com.qspider.springbootproject.repo.UserRepo;
import com.qspider.springbootproject.util.ResponseStructure;

@Service
public class UserService<T> {
	@Autowired
	UserDao udao;
	
	@Autowired
	AadharDao adao;
	
	@Autowired
	ResponseStructure<User> structure;
	
	@Autowired
	AadharRepo repo;
	
	@Autowired
	UserRepo urepo;
	
	public ResponseEntity<ResponseStructure<User>> saveUser(User user){
		User saveuser=udao.saveUser(user);
		if(saveuser!=null) {
			structure.setStatus(HttpStatus.CREATED.value());
			structure.setMessage("User saved successfully");
			structure.setData(saveuser);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.CREATED);
			
		}
		//return null;
		throw new UserNotFound("User not saved");
	}
	
	public ResponseEntity<ResponseStructure<User>> find(int id) {
		User dbuser =udao.findUserById(id);
		if(dbuser!=null) {
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setMessage("User Found");
			structure.setData(dbuser);
			return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.FOUND);
		}
		//return null; we have through exception
		
		throw new UserNotFound("User not found by given id");
	}
	
	public ResponseEntity<ResponseStructure<User>> deleteById(int id) {
		  User deleteduser =udao.deleteById(id);
		  if(deleteduser!=null) {
			  	structure.setStatus(HttpStatus.OK.value());
				structure.setMessage("Deleted successfully by given id");
				structure.setData(deleteduser);
				return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
			 
		  }
		  //return null;
		  throw new UserNotFound("could not delete user by given id");
	  }

	
	public ResponseEntity<ResponseStructure<User>> assignAadhartoUser(int aid,int uid) {
		  User user =udao.findUserById(uid);
		  Aadhar adhar =adao.findAdharById(aid);
		  if(user!=null) {
			  if(adhar!=null) {	
				  user.setAdhar(adhar);
				  User updateduser=udao.updateUser(user, uid);
			  	structure.setStatus(HttpStatus.OK.value());
			  	structure.setMessage("success");
			  	structure.setData(updateduser);
				return new ResponseEntity<ResponseStructure<User>>(structure,HttpStatus.OK);
			 
		  }
		//  return null;
			  throw new AadharNotFoundException("Aadhar not found given id");
		  
		  }
		 // return null;
		  throw new UserNotFound("User not found given id");
	  }
	
	public ResponseEntity<ResponseStructure<List<User>>> findAll(){	
		List<User> allusers=udao.findAll();
		if(allusers!=null) {
		ResponseStructure<List<User>> structure =new ResponseStructure<List<User>>();
		  structure.setStatus(HttpStatus.FOUND.value());
		  structure.setMessage("users found");
		  structure.setData(udao.findAll());
		  return new ResponseEntity<ResponseStructure<List<User>>>(structure,HttpStatus.FOUND);
		}
		throw new UserNotFound("Users Not Found");
	  }
	
	//hw
	public ResponseEntity<ResponseStructure<List<User>>> userWithNoAdhar(){	
		List<User> allusers=udao.findAll();
		List<User> noAdhar=allusers.stream().filter(u->u.getAdhar()==null).toList();
		ResponseStructure<List<User>> structure =new ResponseStructure<List<User>>();
		 structure.setData(noAdhar);
		 structure.setMessage("data found");
		 structure.setStatus(HttpStatus.FOUND.value());
		 return new ResponseEntity<ResponseStructure<List<User>>>(structure,HttpStatus.FOUND);
		
	}
	
	 public ResponseEntity<ResponseStructure<List<User>>> findUserBygender(String gender) {
		List<User> users=urepo.findUserBygender(gender);
		ResponseStructure<List<User>> structure =new ResponseStructure<List<User>>();
		 structure.setData(users);
		 structure.setMessage("users found by gender");
		 structure.setStatus(HttpStatus.FOUND.value());
		 return new ResponseEntity<ResponseStructure<List<User>>>(structure,HttpStatus.FOUND);
		
		}
	
		
}


