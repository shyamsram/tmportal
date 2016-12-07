package com.tm.service;

import com.tm.dao.TeamDetailsDAO;
import com.tm.vo.TeamVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component("teamDetailsService")
public class TeamDetailsServiceImpl implements TeamDetailsService {

	@Autowired
	private TeamDetailsDAO teamDetailsDAO;

    @Override
	public boolean loginCustomer(String userId, String password){
		if(userId.equals("admin") && password.equals("admin")){
			return true;	
		} else if(userId.equals("lead") && password.equals("lead")){
			return true;
		}
		return false;
	}

	@Override
	public List<TeamVO> getTeamList(Integer supervisorId) {
		return teamDetailsDAO.getTeamList(supervisorId);
	}
}