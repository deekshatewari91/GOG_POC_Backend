<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="getApprUser">
		<input type="submit" value="Approved User"><br>
		
		</form><br>
		
		
		<form action="getNAUser">
			
		<input type="submit" value="Not Approved User"><br>
		
		<font color="red"><b>${gerror}</b></font><br>
		<font color="green"><b>${gID}</b></font><br>
		<font color="green"><b>${gfname}</b></font><br>
		<font color="green"><b>${glname}</b></font><br>
		<font color="green"><b>${gemail}</b></font><br>
		<font color="green"><b>${ggender}</b></font><br>
		<font color="green"><b>${gstatus}</b></font><br>
		<font color="green"><b>${gage}</b></font><br>
		<font color="green"><b>${gcontactno}</b></font><br>
		<font color="green"><b>${gcity}</b></font><br>		
		<font color="green"><b>${gdept}</b></font><br>
		
		</form><br>
		
		

</body>
</html>