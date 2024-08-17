package com.qspider.springbootproject.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qspider.springbootproject.entity.Aadhar;
import com.qspider.springbootproject.repo.AadharRepo;

@Repository
public class AadharDao {
	@Autowired
	AadharRepo repo;
	
	public Aadhar saveAdhar(Aadhar adhar) {
		return repo.save(adhar);
		
	}
	
	public Aadhar findAdharById(int id) {
		Optional<Aadhar> optionalAdhar=repo.findById(id);
		if(optionalAdhar.isPresent()) {
			return optionalAdhar.get();
		}
		return null;
	}
	
	public Aadhar deleteById(int id) {
		Aadhar adhar=findAdharById(id);
		if(adhar!=null) {
			repo.delete(adhar);
			return adhar;
		}
		return null;
	}
	
	public Aadhar updateAadhar(Aadhar adhar, int id) {
		Aadhar dbadhar=findAdharById(id);
		if(dbadhar!=null) {
			adhar.setId(id);
			return repo.save(adhar);
		}
		return null;
	}
	
	public List<Aadhar>findAll(){
		return repo.findAll();
		
	}
	
	public Aadhar findBynumber(int number) {
		Aadhar optionalAdhar=repo.findBynumber(number);	
		return optionalAdhar;
	}

}
