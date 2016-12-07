package com.tm.dao;

import com.tm.vo.TeamVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 *
 */
@Component("teamDetailsDAO")
public class TeamDetailsDAOImpl implements TeamDetailsDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<TeamVO> getTeamList(Integer supervisorId) {
        List<TeamVO> teamList = jdbcTemplate.query("SELECT T_DET.ID,FIRST_NAME,LAST_NAME,DESIGNATION,SUPERVISORID" +
                 ", T_EVAL.EVALUATION_STATUS " +
                "FROM TMP.TEAM_DETAILS T_DET, TMP.TEAM_EVALUATION T_EVAL WHERE SUPERVISORID=?" +
                " AND T_EVAL.TEAM_ASSO_ID=T_DET.ID",new Object[]{supervisorId},
                (rs,roNum) -> new TeamVO(rs.getInt("ID"),rs.getString("FIRST_NAME"),
                        rs.getString("LAST_NAME"),rs.getString("DESIGNATION"),rs.getInt("SUPERVISORiD"),
                        rs.getString("EVALUATION_STATUS")));
        return teamList;
    }
}
