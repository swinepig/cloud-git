package com.habuma.spitter.Interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.habuma.spitter.Exception.SessionTimeoutException;
import com.habuma.spitter.entity.User;


public class SessionTimeoutInterceptor extends HandlerInterceptorAdapter {
	
	private List<String> allowUrls;
	
	public List<String> getAllowUrls() {
		return allowUrls;
	}

	public void setAllowUrls(List<String> allowUrls) {
		this.allowUrls = allowUrls;
	}

	/**
	 * Session超时，拦截访问
	 * 
	 */
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String requestUrl = request.getRequestURI();
		
		for(String url : allowUrls) {
			if(requestUrl.endsWith(url)) {
				return super.preHandle(request, response, handler);  
			}
		}
		
		User session = (User) request.getSession().getAttribute("user");
		if(null ==  session ) {
			if (request.getHeader("x-requested-with") != null 
					&& request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){
				response.setHeader("sessionstatus", "session_null");//在响应头设置session状态
			}else{
				throw new SessionTimeoutException("session超时,请重新登录!");
			}
			return false;
		}
		return super.preHandle(request, response, handler);  
	}

}
