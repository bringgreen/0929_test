package com.jang.sample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jang.sample.domain.Sample2;

public interface Sample2Repository extends JpaRepository<Sample2, String> {
	
	//Sample findBySample(Sample sample);
	List<Sample2> findSampleByName(String name);
	
	
	//List<Sample> findSampleByNameOrDescription(String name);
	
	
}
