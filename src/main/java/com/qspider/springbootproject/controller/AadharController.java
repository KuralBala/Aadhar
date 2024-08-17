package com.qspider.springbootproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qspider.springbootproject.entity.Aadhar;
import com.qspider.springbootproject.service.AadharService;
import com.qspider.springbootproject.util.ResponseStructure;

@RestController
@RequestMapping("adhar")
public class AadharController {
	
	@Autowired
	AadharService<Aadhar> service;
	
	@PostMapping
	public ResponseEntity<ResponseStructure<Aadhar>> saveAadhar(@RequestBody Aadhar adhar) {
		return service.saveadhar(adhar);
		
	}
	@GetMapping
	public ResponseEntity<ResponseStructure<Aadhar>> find(@RequestParam int id) {
		return service.find(id);
	}
	@DeleteMapping
	public ResponseEntity<ResponseStructure<Aadhar>> deleteadhar(@RequestParam int id) {
		return service.deleteById(id);
	}
	@PutMapping
	public ResponseEntity<ResponseStructure<Aadhar>> updateAadhar(@RequestBody Aadhar adhar,@RequestParam int id) {
		return service.updateAadhar(adhar, id);
	}
	
	@GetMapping("all")
	public ResponseEntity<ResponseStructure<List<Aadhar>>> findAll() {
		return service.findAll();
	}
	
	@GetMapping("num")
	public ResponseEntity<ResponseStructure<Aadhar>> findBynumber(@RequestParam int number) {
		return service.findByNumber(number);
}

}
 