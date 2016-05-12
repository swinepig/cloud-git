package com.habuma.spitter.test;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
//		ApplicationContext cnt = new ClassPathXmlApplicationContext("service.xml");
//		SpitterService service = (SpitterService)cnt.getBean("spitterService");
//		service.save();
		
		int t = 0;
		String password = "123456";
		System.out.println(password + " -> ");
		for (t = 1; t <= 10; t++) {
		    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		    String hashedPassword = passwordEncoder.encode(password);
		    System.out.println(hashedPassword);
		}

		password = "MIKE123";
		System.out.println(password + " -> ");
		for (t = 1; t <= 10; t++) {
		    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		    String hashedPassword = passwordEncoder.encode(password);
		    System.out.println(hashedPassword);
		}
	}

}
