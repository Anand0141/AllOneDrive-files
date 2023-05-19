package com.ojas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
private int sno;
private String sname;
private String sadd;
private String gender;
private String[]courses;

private String cityFrom;  
private String cityTo;


}
