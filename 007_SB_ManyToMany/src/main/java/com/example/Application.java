package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.entity.CourseEntity;
import com.example.entity.StudentEntity;
import com.example.repo.CourseRepo;
import com.example.repo.StudentRepo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext  ctx=		SpringApplication.run(Application.class, args);
		
		CourseRepo courseRepo = ctx.getBean(CourseRepo.class);
		StudentRepo stuRepo=ctx.getBean(StudentRepo.class);
		
		CourseEntity course=new CourseEntity();
		CourseEntity course1=new CourseEntity();
		
		course.setCname("angular");
		course.setCduration("30");
		course.setCfee(25000);
		
		course1.setCname("Spring");
		course1.setCduration("25");
		course1.setCfee(35000);
		
		List<CourseEntity> addCourses=		new ArrayList<CourseEntity>();
		
		addCourses.add(course);
		addCourses.add(course1);
		
		
		StudentEntity s1=new StudentEntity();
		
		s1.setSname("rani");
		s1.setSadd("usa");
		s1.setClist(addCourses);
		
		stuRepo.save(s1);
		
		
			
	}

}
