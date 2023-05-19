package com.example;

import java.util.Optional;
import java.util.Set;

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
		ConfigurableApplicationContext ctx=		SpringApplication.run(Application.class, args);
		
		CourseRepo courseRepo = ctx.getBean(CourseRepo.class);
		StudentRepo stuRepo = ctx.getBean(StudentRepo.class);
		/*
		 * //display Courses
		 * 
		 * List<CourseEntity> viewCourses = courseRepo.findAll(); for(CourseEntity
		 * course : viewCourses) {
		 * System.out.println(course.getCname()+"\t"+course.getCduration()+"\t"+course.
		 * getCfee()); }
		 */
		/*
		 * //display Students List<StudentEntity> viewStudents = stuRepo.findAll();
		 * 
		 * for(StudentEntity stu : viewStudents) {
		 * System.out.println(stu.getSno()+"\t"+stu.getSname()+"\t"+stu.getSadd());
		 * 
		 * }
		 */
		
		/*
		 * StudentEntity stu=new StudentEntity(); stu.setSname("malli");
		 * stu.setSadd("Hyd"); StudentEntity stu1=new StudentEntity();
		 * stu1.setSname("lilly"); stu1.setSadd("hyd");
		 * 
		 * 
		 * Set<StudentEntity>addStudents=new HashSet<>(); addStudents.add(stu);
		 * addStudents.add(stu1);
		 * 
		 * CourseEntity course=new CourseEntity();
		 * course.setCname("SpringBootWithMicroServices");
		 * course.setCduration("90days"); course.setCfee(25000);
		 * course.setStudents(addStudents);
		 * 
		 * courseRepo.save(course);
		 * 
		 */
		
		
		
		
		
		
		
		
		/*
		 * CourseRepo courseRepo = ctx.getBean(CourseRepo.class); StudentRepo
		 * stuRepo=ctx.getBean(StudentRepo.class);
		 */	/*
		 * StudentEntity stu=new StudentEntity(); stu.setSname("shiva");
		 * stu.setSadd("Hyd"); StudentEntity stu1=new StudentEntity();
		 * stu1.setSname("rani"); stu1.setSadd("Hyd"); Set<StudentEntity>addStudents=new
		 * HashSet<>(); addStudents.add(stu); addStudents.add(stu1); CourseEntity
		 * course=new CourseEntity(); course.setCname("ReactJs");
		 * course.setCduration("30"); course.setCfee(15000);
		 * course.setStudents(addStudents); CourseEntity savedEntity=
		 * courseRepo.save(course); if(savedEntity!=null)
		 * System.out.println(savedEntity.getCname()+"\t"+savedEntity.getCduration()+
		 * "\t"+savedEntity.getCfee());
		 */
	/*	List<CourseEntity>addCourses=courseRepo.findAll();
		addCourses.forEach(course->
		{
			System.out.println(course.getCname()+"\t"+course.getCduration()+"\t"+course.getCfee());
		}
				
				);
		*/
		
		
	/*
	 * StudentEntity stu=new StudentEntity(); stu.setSname("arya");
	 * stu.setSadd("usa"); StudentEntity stu1=new StudentEntity();
	 * stu1.setSname("Jasmin"); stu1.setSadd("usa");
	 * 
	 * 
	 * Set<StudentEntity> courseSet=new HashSet<StudentEntity>();
	 * courseSet.add(stu); courseSet.add(stu1);
	 * 
	 * CourseEntity course=new CourseEntity(); course.setCname("Boomi");
	 * course.setCduration("20"); course.setCfee(25000);
	 * course.setStudents(courseSet); courseRepo.save(course);
	 */
		
	
	
	  Optional<CourseEntity> findById = courseRepo.findById(1); CourseEntity
	  courseEntity = findById.get();
	  
	  Set<StudentEntity> students = courseEntity.getStudents();
	  
	  System.out.println("Course Details : ");
	  System.out.println(courseEntity.getCname()+"\t"+courseEntity.getCduration()+
	  "\t"+courseEntity.getCfee());
	  
	  System.out.println("Student Details : "); for(StudentEntity stu : students) {
	  System.out.println(stu.getSname()+"\t"+stu.getSadd()); }
	 
		
	
	/*
	 * List<StudentCourse> stuInfo = courseRepo.getStudentInfo();
	 * 
	 * for(StudentCourse stu : stuInfo) {
	 * System.out.println(stu.getSno()+"\t"+stu.getSname()+"\t"+stu.getSadd()+"\t"+
	 * stu.getCname()+"\t"+stu.getCfee()+"\t"+stu.getCduration()); }
	 */	
		
	 	}

}
