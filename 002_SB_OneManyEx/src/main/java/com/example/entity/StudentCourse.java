package com.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StudentCourse {
private int sno;
private String sname;
private String sadd;
private String cname;
private String cduration;
private int cfee;
public StudentCourse(int sno, String sname, String sadd, String cname, String cduration, int cfee) {
	super();
	this.sno = sno;
	this.sname = sname;
	this.sadd = sadd;
	this.cname = cname;
	this.cduration = cduration;
	this.cfee = cfee;
}


}
