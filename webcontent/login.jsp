<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="../ERS/resources/css/base.css" rel="stylesheet" type="text/css"/>
<title>Expense reimbursement system</title>
<style type="text/css">
html {
    background-color: #8E8EB9;
}
</style>
</head>
<body>
<form action="LoginServlet" >
<table  width="100%" style="border-collapse:collapse">
<thead  >
  <tr height="300px">
	<td >
	   <h2>EXPENSE REIMBURSEMENT SYSTEM</h2>
	</td>
 </tr>
 <tr >
    <td width="70%">
    </td>
	<td width="20%" >
		<table width="100%"  >
		<thead bgcolor="#FFFFFF">
		<tr>
			<td><h3>Login </h3>
			</td>
		</tr>
		
		<tr>
			<td>
				<table border=0 >
				<tr>
					<td>
					   Employee Id:
				      
				   </td>
					<td>
					   <input type="text" name="empId" value="123">
				      
				   </td>
				</tr>
				<tr>
					<td>
					   
				      
				   </td>
					<td>
					   <input type="submit" value="login" src="LoginServlet">
				   </td>
				   <td>
				   </td>
				</tr>
			</table>
			</td>
			
		</tr>
		</thead>
	   </table>
	</td>
	<td width="10%">
			</td>
 </tr>
 
 </thead>
</table>

</form>
</body>
</html>