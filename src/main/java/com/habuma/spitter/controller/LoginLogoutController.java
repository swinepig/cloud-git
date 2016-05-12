package com.habuma.spitter.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.authentication.RememberMeAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginLogoutController extends BaseController{

	
	
	public static final String DENY = "403";
	// 新增加的Action方法，映射到
	// 1. /login 登录页面的常规显示
	// 2. /login?error 登录验证失败的展示
	// 3. /login?logout 注销登录的处理
	@RequestMapping(method = RequestMethod.GET, value = "/login.do")
	public String home(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,Model model,HttpServletRequest request) {
		
		//自定义错误信息
		String errorMessage = null;
		AuthenticationException ex = (AuthenticationException) request
				.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
		if (ex instanceof UsernameNotFoundException) {
			errorMessage = "UserName is not exists!";
		} else if (ex instanceof BadCredentialsException) {
			errorMessage = "Password is wrong!";
		} else if (ex instanceof AccountExpiredException) {
			errorMessage = "Account is Expired!";
		} else if (ex instanceof LockedException) {
			errorMessage = "Account is Locked!";
		} else if (ex instanceof DisabledException) {
			errorMessage = "Account is Disabled!";
		} else if (ex instanceof CredentialsExpiredException) {
			errorMessage = "Password is Expired!";
		}
		
		if (error != null) {
			model.addAttribute("error", errorMessage);
		}

		if (logout != null) {
			model.addAttribute("msg", "You've been logged out successfully.");
		}
		return "login";
	}
	
	
	/**
	 * 判断用户是否从Remember Me Cookie自动登录
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	private boolean isRememberMeAuthenticated() {

		Authentication authentication = SecurityContextHolder.getContext()
				.getAuthentication();
		if (authentication == null) {
			return false;
		}

		return RememberMeAuthenticationToken.class
				.isAssignableFrom(authentication.getClass());
	}

	
	// for 403 access denied page
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String accesssDenied(Model model) {


		// check if user is login
		//在服务端判断一个用户是否已经登录
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addAttribute("username", userDetail.getUsername());
		}

		return DENY;

	}
	
	@RequestMapping(value = "/home",method = RequestMethod.GET)
	public String home(){
		return "home";
	}
	
	
	@RequestMapping(value = "/timeout")
	public String timeout(){
		return "timeout";
	}
 
}
