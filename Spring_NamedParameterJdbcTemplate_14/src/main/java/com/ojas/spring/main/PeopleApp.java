package com.ojas.spring.main;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.ojas.spring.config.AppConfig;
import com.ojas.spring.dao.PeopleDAO;
import com.ojas.spring.dao.PeopleDAOImpl;
import com.ojas.spring.model.People;

public class PeopleApp {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		PeopleDAO dao = context.getBean(PeopleDAOImpl.class);
		//List of people
		System.out.println("List of Peoples");
		List<People> peoples = dao.getAllPeople();
		for(People p:peoples){
			System.out.println(p);
		}
//		//get people by id
//		
//		System.out.println("get by id");
//		People people=dao.getPeopleById(2l);
//		
//		System.out.println(people);
//		
//		
//		//update people
//		
//		People people3=new People();
//		people3.setId(2l);
//		people3.setFirstName("sankar");
//		people3.setLastName("reddy");
//		people3.setAge(23);
//		
//		boolean b4=dao.updatePeople(people3);
//		
//		System.out.println("updated"+b4);
//		
//		//delete people
////        boolean b=dao.deletePeople(people);
////        
////        
////		System.out.println("data deleted");
//		
//		
//		
//		//create people
//		
//		People people2=new People();
//		people2.setId(5l);
//		people2.setFirstName("siva sankar");
//		people2.setLastName("uppaluru");
//		people2.setAge(24);
//		
//		boolean b1=dao.createPeople(people2);
//		
//		System.out.println(b1);
//		
//		
//		
//		//List of people
//		
//		List<People> peoples1 = dao.getAllPeople();
//		for(People p:peoples1){
//			System.out.println(p);
//		}
		
	}

}
