package com.habuma.spitter.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Bcrypt {

	/***
	 * 对字符串str加密
	 * @param str
	 * @return
	 */
	public String bCryptEncoder(String str) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode("MIKE123");
	}

	public static void main(String[] args) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode("YJMYZZ");
		System.out.println(hashedPassword);
	}

}
