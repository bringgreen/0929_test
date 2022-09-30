package com.jang.sample.repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jang.sample.domain.Sample;

public interface SampleRepositoryQueryDsl {
	
	
	List<Sample> findByNameLikeDescriptionLike(Map map);
	
}
