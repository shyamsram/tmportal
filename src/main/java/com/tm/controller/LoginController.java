package com.tm.controller;

import java.util.ArrayList;
import java.util.List;

import com.tm.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.tm.service.TeamDetailsService;


@RestController
public class LoginController {

	@Autowired
    private TeamDetailsService teamDetailsService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

	@RequestMapping(value="/deleteUser/{value}", method=RequestMethod.GET)
	public ModelAndView removeUser(@PathVariable("value") String value){
				
		List<String> list = getList();
		List<String> dept = getDept();
		list.remove(Integer.parseInt(value));
		dept.remove(Integer.parseInt(value));
		
		ModelAndView model = new ModelAndView("HomePage");
		model.addObject("lists", list);
		model.addObject("departments", dept);
		
		return model;
			
	}

	@RequestMapping(value="/index", method=RequestMethod.GET)
	public ModelAndView showLoginForm(){
		return new ModelAndView("login1");
	}
	
    @RequestMapping(value="/login", method=RequestMethod.POST,consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView verifyLogin(@ModelAttribute User user){
		ModelAndView model;
		Boolean loginStatus = teamDetailsService.loginCustomer(user.getUserId(),user.getPassword());
		if(loginStatus){
            System.out.println("login status is : " + loginStatus);
			List<String> list = getList();
			List<String> dept = getDept();
			model = new ModelAndView("index");
            model.addObject("teamList",teamDetailsService.getTeamList(1));
            model.addObject("lists", list);
			model.addObject("departments", dept);
		} else  {
            System.out.println("login status is : " + loginStatus);
            model = new ModelAndView("index.html");
			model.addObject("status", "Login Failure");
		}
		return model;
	}
	
	private List<String> getList() {

		List<String> list = new ArrayList<String>();
		list.add("Tony");
		list.add("Rich");
		list.add("John");
		list.add("Mike");
		

		return list;

	}
	
	private List<String> getDept() {

		List<String> list = new ArrayList<String>();
		list.add("Retail");
		list.add("Business");
		list.add("Retail");
		list.add("Business");
		

		return list;

	}



	
}