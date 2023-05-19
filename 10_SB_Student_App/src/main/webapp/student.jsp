<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form action="register" modelAttribute="stu">

Student Number :  <form:input path="sno" /><br>
Student Name : <form:input path="sname"/><br>
Student Address : <form:input path="sadd"/><br>
Gender : <form:radiobutton path="gender" value="Male"/>Male
<form:radiobutton path="gender" value="Female"/>Fe-Male<br>
Courses : <br>
<form:checkbox path="courses" value="SpringBoot"/>SpringBoot<br>
<form:checkbox path="courses" value="MicroServices"/>MicroServices<br>
<form:checkbox path="courses" value="ReactJs"/>ReactJs<br><br>

<br><br>  
        Leaving from: <form:select path="cityFrom">  
        <form:option value="Guntur" label="Guntur"/>  
        <form:option value="Guntur" label="Guntur"/>
        <form:option value="Guntur" label="Guntur"/>
        <form:option value="Guntur" label="Guntur"/>
        <form:option value="Guntur" label="Guntur"/>  
        </form:select>  
        <br><br>  
        Going to: <form:select path="cityTo">  
        <form:option value="Guntur" label="Guntur"/>  
        <form:option value="Guntur" label="Guntur"/>
        <form:option value="Guntur" label="Guntur"/>
        <form:option value="Guntur" label="Guntur"/>
        <form:option value="Guntur" label="Guntur"/>  
        </form:select>
<input type="submit" value="ClickMe">
</form:form>
</body>
</html>