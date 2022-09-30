package com.jang.sample.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jang.sample.domain.Sample;

public interface SampleRepository extends JpaRepository<Sample, Long> {
	
	
	List<Sample> findByNameLikeIgnoreCase(String name);
	
	//Sample findBySample(Sample sample);
	List<Sample> findSampleByName(String name);
	//Sample findSampleByNameOne(String name);
	//List<Sample> findSampleByNameOrDescription(String name);
	// Board findByUser(User user);
	Optional<Sample> findById(Long id);
	
	Sample findSampleById(Long id);
	
	List<Sample> findByNameLikeIgnoreCaseOrDescriptionLikeIgnoreCase(String name, String description);

	
	//@Query("select t from Sample t where id > :id")
	//List<Sample> findByNameAndAgeLessThanSQL(@Param("id") Long id);
	
	
	
	//Page<Sample> findByIdGreaterThan(Long id, Sample paging);
}
