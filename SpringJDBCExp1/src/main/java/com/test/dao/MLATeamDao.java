package com.test.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.dao.DataAccessException;

import com.test.model.MLATeam;

public class MLATeamDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    
    public int saveMLATeam(MLATeam obj) {

        String sql = "INSERT INTO mlateam (id, e_name, e_skill, t_manager) VALUES (?, ?, ?, ?)";

        return jdbcTemplate.update(sql,
                obj.getId(),
                obj.getName(),
                obj.getSkill(),
                obj.getManager());
    }

    
    public int updateMLAteam(MLATeam obj) {

        String sql = "UPDATE mlateam SET e_name=?, e_skill=?, t_manager=? WHERE id=?";

        return jdbcTemplate.update(sql,
                obj.getName(),
                obj.getSkill(),
                obj.getManager(),
                obj.getId());
    }

   
    public int deleteMLATeamMember(int id) {

        String sql = "DELETE FROM mlateam WHERE id=?";

        return jdbcTemplate.update(sql, id);
    }

    public List<MLATeam> getAllMembers() {

        String sql = "SELECT * FROM mlateam";

        return jdbcTemplate.query(sql, new ResultSetExtractor<List<MLATeam>>() {

            @Override
            public List<MLATeam> extractData(ResultSet rs)
                    throws SQLException, DataAccessException {

                List<MLATeam> listTeam = new ArrayList<>();

                while (rs.next()) {
                    MLATeam team = new MLATeam();

                    team.setId(rs.getInt("id"));
                    team.setName(rs.getString("e_name"));
                    team.setSkill(rs.getString("e_skill"));
                    team.setManager(rs.getString("t_manager"));

                    listTeam.add(team);
                }

                return listTeam;
            }
        });
    }
}