<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html xmlns="http://www.w3.org/1999/xhtml" 
    xmlns:th="http://www.thymeleaf.org" 
    xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3"
    xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Demo Project</title>
</head>
<body>
		
        <form action=addperson>
		<font color="green"><b>${MSG}</b></font>
		<font color="red"><b>${ErrorMSG}</b></font>
		<br>Insert User :<br>
<!-- 		ID : <input type="text" name="id"><br> -->
		Email : <input type="text" name="email"><br>
		First Name :<input type="text" name="firstname"  >  <br>
		Last Name : <input type="text" name="lastname" >  <br>
		<!-- Gender : <input type="text" name="gender"><br>  
		
		Gender :<select name="gender" >
  			<option value="Male">Male</option>
  			<option value="Female">Female</option>
		</select><br>-->
		
		  Gender :<input type="radio" name="gender" value="Male" checked> Male
		  <input type="radio" name="gender" value="Female"> Female
		  <input type="radio" name="gender" value="Other"> Other <br> 
		
		Age :<input type="text" name="age"  >  <br>
		Contact No. :<input type="text" name="contact"  >  <br>

		Designation :<input type="text" name="designation"  >  <br>
		City :<input type="text" name="city"  >  <br>
		
	
		
		
		<input type="submit"><br>
		</form> 
		
		<br><br>
		Show User :
		<form action="getUser">
		ID : <input type="text" name="id">
		
		<input type="submit"><br>
		
		<font color="red"><b>${gerror}</b></font><br>
		<font color="green"><b>${gID}</b></font><br>
		<font color="green"><b>${gfname}</b></font><br>
		<font color="green"><b>${glname}</b></font><br>
		<font color="green"><b>${gemail}</b></font><br>
		<font color="green"><b>${ggender}</b></font><br>
		<font color="green"><b>${gstatus}</b></font><br>
		<font color="green"><b>${gage}</b></font><br>
		<font color="green"><b>${gcontactno}</b></font><br>
		
		</form><br>
		
		Show User Names :
		<form action="getName">
		<input type="submit" value="Find Name"><br>
		${lfname}
		</form><br><br>
		
		
		
		Delete User :
		<form action="deleteUser">
		ID : <input type="text" name="id">
		<input type="submit" value="Delete"><br>
		${delMSG}
		</form>

</body>
</html>