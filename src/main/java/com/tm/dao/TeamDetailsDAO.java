package com.tm.dao;

import com.tm.vo.TeamVO;

import java.util.List;

/**
 *
 */
public interface TeamDetailsDAO {
    List<TeamVO> getTeamList(Integer supervisorId);
}
