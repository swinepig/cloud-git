package com.habuma.spitter.entity;

import java.io.Serializable;

public class Spitter implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4229674101261298681L;
	private String user_name;
	private String password;

	public Spitter() {
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String userName) {
		user_name = userName;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return this.user_name + ":" + this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Spitter(String userName, String password) {
		user_name = userName;
		this.password = password;
	}

}
