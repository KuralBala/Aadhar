package com.qspider.springbootproject.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qspider.springbootproject.entity.Aadhar;

public interface AadharRepo extends JpaRepository<Aadhar, Integer>{

	public Aadhar findBynumber(int number);

		

}
