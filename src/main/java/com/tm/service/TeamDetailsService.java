package com.tm.service;

import com.tm.vo.TeamVO;

import java.util.List;

/**
 *
 */
public interface TeamDetailsService {
    boolean loginCustomer(String userId, String password);
    List<TeamVO> getTeamList(Integer supervisorId);
}
