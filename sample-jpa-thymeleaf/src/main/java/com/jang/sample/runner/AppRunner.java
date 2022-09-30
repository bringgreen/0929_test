package com.jang.sample.runner;

import java.util.stream.LongStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.jang.sample.domain.Sample;
import com.jang.sample.repository.Sample2Repository;
import com.jang.sample.repository.SampleRepository;

@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    SampleRepository sampleRepository;
    

    @Autowired
    Sample2Repository sample2Repository;
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
    	
    	System.out.println("ApplicationRunner start ======");
    	
    	String[] arrDescription = {"Foundation Layer","Persistence Layer","Presentation Layer","Business Layer","Batch Layer"};
    	
        LongStream.rangeClosed(1, 10).forEach(
    		index ->
    			sampleRepository.save(
	    			Sample.builder()
	    				.name("Runtime Environment")
	    				.description(arrDescription[(int)(index%5)])
	    				.useYn("Y")
	    				.regUser("eGov")
	    				.build()
	    		)
		);
		

    	/*
    	IntStream.iterate(0, i -> i + 1)
        .limit(5)
        .forEach(
        	i->System.out.println("ApplicationRunner>>"+i)
		);
        */
		
		/*
        LongStream.rangeClosed(1, 10).forEach(
    		index ->
    			sampleRepository.save(
	    			Sample.builder()
	    				.name("Runtime Environment")
	    				.description("Foundation Layer")
	    				.useYn("Y")
	    				.regUser("eGov")
	    				.build()
	    		)
		);
		*/
    	/*
        LongStream.rangeClosed(1, 10).forEach(
    		index ->
    			sample2Repository.save(
	    			new Sample2("Runtime Environment","Foundation Layer","Y","eGov")
	    		)
		);
		*/
    	
    }
}
