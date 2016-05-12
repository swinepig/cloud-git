package com.habuma.spitter.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.habuma.spitter.Exception.SessionTimeoutException;
import com.habuma.spitter.entity.Spitter;
import com.habuma.spitter.service.ISpitterService;


/*
                   _ooOoo_
                  o8888888o
                  88" . "88
                  (| -_- |)
                  O\  =  /O
               ____/`---'\____
             .'  \\|     |//  `.
            /  \\|||  :  |||//  \
           /  _||||| -:- |||||-  \
           |   | \\\  -  /// |   |
           | \_|  ''\---/''  |   |
           \  .-\__  `-`  ___/-. /
         ___`. .'  /--.--\  `. . __
      ."" '<  `.___\_<|>_/___.'  >'"".
     | | :  `- \`.;`\ _ /`;.`/ - ` : | |
     \  \ `-.   \_ __\ /__ _/   .-` /  /
======`-.____`-.___\_____/___.-`____.-'======
                   `=---='
^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
         ���汣��       ����BUG
*/



@Controller
@RequestMapping("/spitter")
public class SpitterController extends BaseController{

	@Resource(name = "spitterService")
	private ISpitterService service;

	public SpitterController() {
	}

	@RequestMapping(value = "/spitters", method = RequestMethod.GET)
	public String listSpitters(@RequestParam("spitter") String username,
			Model model) {
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 5; i++) {
			list.add(i);
		}
		model.addAttribute("intelist", list);
		logger.info(username);
		service.save();
		return "list";
	}

	@RequestMapping(method = RequestMethod.GET, params = "new")
	public String createSpitter(Model model) {
		model.addAttribute(new Spitter());
		return "edit";
	}

	@RequestMapping(method = RequestMethod.POST)
	public String addSpitterFromForm(Spitter spitter, BindingResult result) {
		System.out.println(spitter);
		// POST֮������ض���
		return "redirect:/spitter/" + spitter.getUser_name();
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{user_name}")
	public String showSpitter(@PathVariable String user_name, Model model) {
		System.out.println(user_name);
		model.addAttribute("username", user_name);
		return "list";
	}

	@RequestMapping(value = "/porfile/{user_name}/{password}", method = RequestMethod.GET)
	public @ResponseBody
	Spitter porfile(@PathVariable String user_name,
			@PathVariable String password) {
		return new Spitter(user_name, password);
	}

	/**
	 * ��¼
	 * 
	 * @param person
	 * @return
	 */
	@RequestMapping(value = "/porfile/login", method = RequestMethod.POST)
	public @ResponseBody
	Spitter login(@RequestBody Spitter spitter) {
		return spitter;
	}
	
	@RequestMapping(value="/testException",method = RequestMethod.GET)
	public void testException(HttpServletResponse response) throws Exception{
		throw new SessionTimeoutException();  
	}

}
