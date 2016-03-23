<%@ page import="java.util.*" %>
<%@ page import="com.ers.valueobject.SummaryVO" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link href="../ERS/resources/css/base.css" rel="stylesheet" type="text/css"/>
<title>Expense reimbursement system</title>
</head>
<body>
<%
String empId = (String)request.getSession().getAttribute("empId");

ArrayList<ArrayList<SummaryVO>> summaryList = (ArrayList<ArrayList<SummaryVO>>)request.getAttribute("summaryList");
ArrayList<SummaryVO> submitterList = null;
ArrayList<SummaryVO> approverList = null;
ArrayList<SummaryVO> tempList = summaryList.get(0);
if(summaryList.size()>0 && summaryList.size()==2){
	submitterList = summaryList.get(0);
	approverList = summaryList.get(1);
}else if((tempList.get(0)).isApprover()){
	approverList = tempList;
}else{
	submitterList = tempList;
}
%>


<table  class="headertable" height="70px";>
<thead>
	<tr>
	<td>
	   <h2>EXPENSE REIMBURSEMENT SYSTEM</h2>
	   
	</td>
	<td>welcome, <%=empId %></td>
 </tr>
 </thead>
</table>

</body>
</html>
