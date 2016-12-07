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
			model = new ModelAndView("index");
            model.addObject("teamList",teamDetailsService.getTeamList(1));
		} else  {
            System.out.println("login status is : " + loginStatus);
            model = new ModelAndView("index.html");
			model.getModelMap().addAttribute("status", "Login Failure");
		}
		return model;
	}
}