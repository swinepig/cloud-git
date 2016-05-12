package com.habuma.spitter.dao;

import org.springframework.stereotype.Component;

@Component("spitterDao")
public class SpitterDao  {

	public void save(){
		System.out.println("spitterDao save");
	}
}
