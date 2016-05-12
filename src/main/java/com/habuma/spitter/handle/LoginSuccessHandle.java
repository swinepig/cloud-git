package com.habuma.spitter.handle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.habuma.spitter.util.HttpUtil;

public class LoginSuccessHandle extends
		SavedRequestAwareAuthenticationSuccessHandler {

	private static final Logger logger = LoggerFactory.getLogger(LoginSuccessHandle.class);
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {

		UserDetails userDetails = (UserDetails) authentication.getPrincipal();

		//TODO：记录登录日志
		// 输出登录提示信息
		//logs exception
		logger.info("登陆员 " + userDetails.getUsername());
		try {
			logger.info("登陆IP " + HttpUtil.getIpAddr(request));
		} catch (Exception e) {
			e.printStackTrace();
		}
		super.onAuthenticationSuccess(request, response, authentication);
	}
}
