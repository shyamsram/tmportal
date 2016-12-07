package com.tm.controller;

import com.tm.service.TeamDetailsService;
import com.tm.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TeamController {

	@Autowired
    private TeamDetailsService teamDetailsService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping(value="/addnewassociate")
	public ModelAndView addNewAssociate(){
		return new ModelAndView("addnew");
	}
}