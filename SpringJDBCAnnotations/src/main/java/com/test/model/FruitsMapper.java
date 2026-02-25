package com.test.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class FruitsMapper implements RowMapper<Fruits>{

	@Override
	public Fruits mapRow(ResultSet rs, int rowNum) throws SQLException {


		Fruits fruits= new Fruits();
		
		fruits.setId(rs.getInt("id"));
		fruits.setName(rs.getString("f_name"));
		fruits.setPrice(rs.getInt("f_price"));
		fruits.setQuantity(rs.getInt("f_quantity"));
		
		return fruits;
	}

}
