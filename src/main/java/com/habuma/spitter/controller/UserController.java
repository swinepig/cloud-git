package com.habuma.spitter.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.session.SessionInformation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.habuma.spitter.entity.Article;
import com.habuma.spitter.entity.ResultFilter;
import com.habuma.spitter.entity.User;
import com.habuma.spitter.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController{

	@Resource
	private IUserService userService;

	/***
	 * 根据用户号查询用户
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request, Model model) {
		int userId = Integer.parseInt(request.getParameter("id"));
		User user = this.userService.getUserById(userId);
		model.addAttribute("user", user);
		return "showUser";
	}
	
	/***
	 * 注册用户
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/regeist", method = RequestMethod.POST)
	public String regeist(User user,Model model) {
		if (user.getUserName().equals("zx")) {
			model.addAttribute("msg", "username is exist!");
		} else {
			model.addAttribute("msg", "regesit succesful!");
		}
		userService.addUser(user);
//		return "login";
		return "redirect:/login.do";
	}
	
	
	/**
	 * 简单分页处理
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/listUser")
	public ModelAndView listUser(@RequestParam(value="page",required=false) String page, Model model) {

		// 每页显示的条数
		int pageSize = 10;

		List<User> users = new ArrayList<User>();
		// users = this.userService.getAllUser();

		// 查到的总用户数
		model.addAttribute("userNum", 101);

		// 总页数
		int pageTimes;
//		if (users.size() % pageSize == 0) {
//			pageTimes = users.size() / pageSize;
//		} else {
//			pageTimes = users.size() / pageSize + 1;
//		}
		if (101 % pageSize == 0) {
			pageTimes = 101 / pageSize;
		} else {
			pageTimes = 101 / pageSize + 1;
		}
		model.addAttribute("pageTimes", pageTimes);

		// 页面初始的时候page没有值
		if (null == page) {
			page = "1";
		}

		// 每页开始的第几条记录
		// int startRow = (Integer.parseInt(page)-1) * pageSize;
		// users = this.userService.getUserByPage(startRow, pageSize);

		model.addAttribute("currentPage", Integer.parseInt(page));
		model.addAttribute("users", users);

		return new ModelAndView("fenye");
	}
	
	/***
	 * 使用bootstrap-paginator.js AJAX做分页
	 * @param page
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/listUser2", method = RequestMethod.POST)
	public @ResponseBody
	ResultFilter<Article> getAllArticles(
			@RequestParam(value = "page", required = false) String page,
			Model model) {
		// 每页显示的条数
		int pageSize = 10;

		List<User> users = new ArrayList<User>();
		// users = this.userService.getAllUser();

		// 查到的总用户数
		model.addAttribute("userNum", 101);

		// 总页数
		int pageTimes;
		if (101 % pageSize == 0) {
			pageTimes = 101 / pageSize;
		} else {
			pageTimes = 101 / pageSize + 1;
		}

		// 页面初始的时候page没有值
		if (null == page) {
			page = "1";
		}
		Article a = new Article();
		a.setId(1);
		a.setTitle("1");
		a.setAuthor("1");
		Article a1 = new Article();
		a1.setId(2);
		a1.setTitle("12222");
		a1.setAuthor("啊大苏打");
		Article a2 = new Article();
		a2.setId(1);
		a2.setTitle("1");
		a2.setAuthor("1");
		Article a3 = new Article();
		a3.setId(2);
		a3.setTitle("12222");
		a3.setAuthor("啊大苏打");
		ResultFilter<Article> rf = new ResultFilter<Article>();
		rf.setCurrentPage(Integer.parseInt(page));
		rf.setTotalCount(pageTimes);
		rf.addItem(a);rf.addItem(a1);rf.addItem(a2);rf.addItem(a3);
		return rf;
	}
	
	/***
	 * 查找SessionRegistry中的信息并收集当前session信息
	 * @param model
	 */
	@RequestMapping("/listActiveUsers")
	public String listActiveUsers(Model model){
		//each principal each lastRequest
		Map<Object, Date> lastActivityDates = new HashMap<Object,Date>();
		for(Object principal:sessionRegistry.getAllPrincipals()){
			for(SessionInformation session:sessionRegistry.getAllSessions(principal, false)){
				if(lastActivityDates.get(principal)==null){
					lastActivityDates.put(principal, session.getLastRequest());
				}else{
					Date preLastRequest= lastActivityDates.get(principal);
					if(session.getLastRequest().after(preLastRequest)){
						lastActivityDates.put(principal, session.getLastRequest());
					}
				}
			}
		}
		model.addAttribute("activeUsers",lastActivityDates);
		return "listActiveUsers";
	}
}
