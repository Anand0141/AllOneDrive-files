package com.ojas.spring.dao;

import java.util.List;

import com.ojas.spring.model.People;

public interface PeopleDAO {

	People getPeopleById(Long id);

	List<People> getAllPeople();

	boolean deletePeople(People people);

	boolean updatePeople(People people);

	boolean createPeople(People people);
}
