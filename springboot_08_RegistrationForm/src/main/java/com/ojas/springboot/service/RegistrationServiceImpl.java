package com.ojas.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ojas.springboot.model.Registration;
import com.ojas.springboot.repository.RegistrationRepo;
@Service
public class RegistrationServiceImpl implements RegistrationService{

	@Autowired
	private RegistrationRepo registrationRepo;
	@Override
	public String saveData(Registration registration) {
		Registration reg=registrationRepo.save(registration);
		String msg;
		if(reg!=null)
			msg="registration sucessfully";
		else
			msg="registration not sucessfully";
		return msg;
	} 
	

}
