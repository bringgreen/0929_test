package com.jang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleApplication {

	public static void main(String[] args) {
		
		
		//System.setProperty("spring.profiles.active", "local");
		//System.setProperty("server.ports", "8080");
		

		SpringApplication.run(SampleApplication.class, args);
		//java -Dspring.profiles.active=dev -jar some-project.jar
//		String[] myArgs = {"--spring.profiles.active=local", "--server.port=8081"};
//		SpringApplication.run(SampleApplication.class, myArgs);
//		 
//		
//		try {
//			Runtime.getRuntime().exec(new String[]{"/usr/bin/open", "-a", "/Applications/Google Chrome.app", "http://localhost:8081/"});
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}

}
