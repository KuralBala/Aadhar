package com.qspider.springbootproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qspider.springbootproject.dao.AadharDao;
import com.qspider.springbootproject.entity.Aadhar;
import com.qspider.springbootproject.exception.AadharNotFoundException;
import com.qspider.springbootproject.util.ResponseStructure;

@Service
public class AadharService<T> {
	@Autowired
	AadharDao dao;
	
	@Autowired
	ResponseStructure<Aadhar> resstructure;
	
	//public Aadhar saveadhar(Aadhar adhar) {
	//public ResponseEntity<Aadhar> saveadhar(Aadhar adhar) {
	
	public ResponseEntity<ResponseStructure<Aadhar>> saveadhar(Aadhar adhar) {
		Aadhar saveadhar=dao.saveAdhar(adhar);
		if(saveadhar!=null) {
			//return saveadhar;
			//return new ResponseEntity<Aadhar>(saveadhar,HttpStatus.CREATED);
			resstructure.setStatus(HttpStatus.CREATED.value());
			resstructure.setMessage("Aadhar saved successfully");
			resstructure.setData(saveadhar);
			return new ResponseEntity<ResponseStructure<Aadhar>>(resstructure,HttpStatus.CREATED);
			
		}
		return null;
	}
	
	public ResponseEntity<ResponseStructure<Aadhar>> find(int id) {
		Aadhar adhar =dao.findAdharById(id);
		if(adhar!=null) {
			resstructure.setStatus(HttpStatus.FOUND.value());
			resstructure.setMessage("Aadhar Found given id");
			resstructure.setData(adhar);
			return new ResponseEntity<ResponseStructure<Aadhar>>(resstructure,HttpStatus.FOUND);
		}
		//return null;
		throw new AadharNotFoundException("Aadhar not found by given id");
	}

	  //public Aadhar deleteById(int id) {
	//public ResponseEntity<Aadhar> deleteById(int id) {
	public ResponseEntity<ResponseStructure<Aadhar>> deleteById(int id) {
		  Aadhar adhar =dao.findAdharById(id);
		  if(adhar!=null) {
			  dao.deleteById(id);
			  	resstructure.setStatus(HttpStatus.OK.value());
				resstructure.setMessage("Deleted successfully by given id");
				resstructure.setData(adhar);
				return new ResponseEntity<ResponseStructure<Aadhar>>(resstructure,HttpStatus.OK);
			 // return new ResponseEntity<Aadhar>(adhar,HttpStatus.OK);
		  }
		  return null;
	  }
	  
	 // public Aadhar updateAadhar(Aadhar adhar,int id) {
	 public ResponseEntity<ResponseStructure<Aadhar>> updateAadhar(Aadhar adhar,int id) {
		  Aadhar dbadhar=dao.findAdharById(id);
		  if(dbadhar!=null) {
			  dao.updateAadhar(dbadhar, id);
			  	resstructure.setStatus(HttpStatus.OK.value());
				resstructure.setMessage("Update successfully by given id");
				resstructure.setData(dbadhar);
				return new  ResponseEntity<ResponseStructure<Aadhar>>(resstructure,HttpStatus.FOUND);
			 // return new ResponseEntity<Aadhar>(dbadhar,HttpStatus.OK);
		  }
		  return null;
	  }
	  
	  public ResponseEntity<ResponseStructure<List<Aadhar>>> findAll(){
		  //return new ResponseEntity<List<Aadhar>>(dao.findAll(),HttpStatus.FOUND);
		  ResponseStructure<List<Aadhar>> structure =new ResponseStructure<List<Aadhar>>();
		  structure.setStatus(HttpStatus.FOUND.value());
		  structure.setMessage("Aadhars found");
		  structure.setData(dao.findAll());
		  return new ResponseEntity<ResponseStructure<List<Aadhar>>>(structure,HttpStatus.FOUND);
	  }
	  
	  public ResponseEntity<ResponseStructure<Aadhar>> findByNumber(int number) {
			Aadhar adharnum =dao.findBynumber(number);
			if(adharnum!=null) {
				resstructure.setStatus(HttpStatus.FOUND.value());
				resstructure.setMessage("Aadhar Found");
				resstructure.setData(adharnum);
				return new ResponseEntity<ResponseStructure<Aadhar>>(resstructure,HttpStatus.FOUND);
			}
			return null;
		}
}
