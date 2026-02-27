package com.test.dao;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.test.model.MLATeam;

public class MLATeamDao1 {
		
	private NamedParameterJdbcTemplate namedParamaterJdbcTemplate;


	public void setNamedParamaterJdbcTemplate(NamedParameterJdbcTemplate namedParamaterJdbcTemplate) {
		this.namedParamaterJdbcTemplate = namedParamaterJdbcTemplate;
	}
		
	public void createMLATeam(MLATeam obj) {
		String sql = "INSERT INTO mlateam (id, e_name, e_skill, t_manager) VALUES (:e_id, :e_name, :e_skill, :t_manager)";      //anything we can take in place of e_id ....

	    MapSqlParameterSource msp = new MapSqlParameterSource();
	        
	    msp.addValue("e_id",obj.getId());
	    msp.addValue("e_name",obj.getName());
	    msp.addValue("e_skill",obj.getSkill());
	    msp.addValue("t_manager",obj.getManager());
	    
	    namedParamaterJdbcTemplate.update(sql,msp);
	}
}
		
		

