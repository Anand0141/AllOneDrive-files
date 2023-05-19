package com.ojas.spring.model;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PeopleMapper implements  RowMapper<People>{

	@Override
	public People mapRow(ResultSet rs, int i) throws SQLException {
		People people = new People();
		people.setId(rs.getLong("id"));
		people.setFirstName(rs.getString("first_name"));
		people.setLastName(rs.getString("last_name"));
		people.setAge(rs.getInt("age"));
		return people;
	}

}
