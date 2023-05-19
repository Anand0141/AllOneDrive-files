package com.ojas.spring.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.ojas.spring.model.People;


@Component
public class PeopleDAOImpl implements PeopleDAO {
	@Autowired
	public NamedParameterJdbcTemplate jt;

	// public PeopleDAOImpl(JdbcTemplate jt) {
	// this.jt = jt;
	// }

	@Override
	public People getPeopleById(Long id) {
		// TODO Auto-generated method stub
		SqlParameterSource paramSource = new MapSqlParameterSource().addValue("id", id);
		return (People) jt.queryForMap("SELECT * FROM PEOPLE WHERE ID=:id", paramSource);

	}

	@Override
	public List<People> getAllPeople() {
		// TODO Auto-generated method stub
		SqlParameterSource namedParameters = new MapSqlParameterSource();
		return jt.query("SELECT * FROM PEOPLE",  new 
			     BeanPropertyRowMapper<>(People.class));
	}

	@Override
	public boolean deletePeople(People people) {
		SqlParameterSource paramSource = new MapSqlParameterSource().addValue("id", people.getId());
		return jt.update("DELETE FROM people WHERE id=:id", paramSource) > 0;

	}

	@Override
	public boolean updatePeople(People people) {
		// TODO Auto-generated method stub
		SqlParameterSource paramSource = new MapSqlParameterSource().addValue("id", people.getId())
				.addValue("first_name", people.getFirstName()).addValue("last_name", people.getLastName())
				.addValue("age", people.getAge());
		return jt.update("UPDATE people SET first_name=:first_name, last_name=last_name,age=:age WHERE id=:id",
				paramSource) > 0;
	}

	@Override
	public boolean createPeople(People people) {
		// TODO Auto-generated method stub
		SqlParameterSource paramSource = new MapSqlParameterSource().addValue("id", people.getId())
				.addValue("first_name", people.getFirstName()).addValue("last_name", people.getLastName())
				.addValue("age", people.getAge());
		return jt.update("INSERT INTO people VALUES(?,?,?,?)", paramSource) > 0;
	}

}
