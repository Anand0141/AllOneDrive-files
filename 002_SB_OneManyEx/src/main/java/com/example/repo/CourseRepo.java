package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.entity.CourseEntity;
import com.example.entity.StudentCourse;

@Repository
public interface CourseRepo extends JpaRepository<CourseEntity, Integer> {

	@Query("SELECT new com.example.entity.StudentCourse(s.sno,s.sname,s.sadd,c.cname,c.cduration,c.cfee) FROM CourseEntity c ,StudentEntity s")
	List<StudentCourse> getStudentInfo();
}
