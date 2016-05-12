package com.habuma.spitter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.habuma.spitter.handle.LoginSuccessHandle;

public class BaseController {
	
	protected static final Logger logger = LoggerFactory.getLogger(LoginSuccessHandle.class);
	
	@Autowired(required=true)
	SessionRegistry sessionRegistry;
	
	@ModelAttribute("numberUsers")
	public int getNumberOfUsers(){
		return sessionRegistry.getAllPrincipals().size();
	}
}
