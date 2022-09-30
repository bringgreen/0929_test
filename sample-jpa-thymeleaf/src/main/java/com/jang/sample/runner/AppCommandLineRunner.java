package com.jang.sample.runner;

import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppCommandLineRunner implements CommandLineRunner {

	@Override
	public void run(String... strings) throws Exception {
		
    	System.out.println("ApplicationRunner start ======");
    	/*
        IntStream.rangeClosed(1, 10).forEach(
        		System.out::println
		);
		*/
        IntStream.rangeClosed(1, 2).forEach(
        		i->System.out.println("AppCommandLineRunner>>"+i)
		);
	}
}
