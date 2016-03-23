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
HttpSession httpSession = request.getSession();
String empId = (String)httpSession.getAttribute("empId");

ArrayList<ArrayList<SummaryVO>> summaryList = (ArrayList<ArrayList<SummaryVO>>)request.getAttribute("summaryList");
ArrayList<SummaryVO> submitterList = null;
ArrayList<SummaryVO> approverList = null;
if(summaryList!=null && summaryList.size()!=0){
	ArrayList<SummaryVO> tempList = summaryList.get(0);
	if(summaryList.size()>0 && summaryList.size()==2){
		submitterList = summaryList.get(0);
		approverList = summaryList.get(1);
	}else if((tempList.get(0)).isApprover()){
		approverList = tempList;
	}else{
		submitterList = tempList;
	}
}
%>

<form action="OperationServlet">
<table  class="headertable" height="70px">
<thead>
	<tr>
	<td>
	   <h2>EXPENSE REIMBURSEMENT SYSTEM</h2>
	   
	</td>
	<td>welcome, <%=empId %></td>
 </tr>
 </thead>
</table>
<%if(submitterList != null) {%>
<table width="100%" >
	<tr>
		<td>
			<h3>Summary of reimbursement forms submitted by you</h3>
		</td>
	</tr>
	<tr>
	 <td>
		<table width="70%" class="summarytable">
		<thead >
		<tr>
			<td>
				Form Id
			</td>
			<td>
				Type
			</td>
			<td>
				Supervisor
			</td>
			<td>
				Amount
			</td>
			<td>
				Last operation date
			</td>
			<td>
				Status
			</td>
			<td>
				Action
			</td>
		</tr>
		</thead>
<%
	for(int i=0;i<submitterList.size();i++){
		httpSession.setAttribute("submitterVO", submitterList.get(i));
%>
		<tr>
			<td>
				<%=submitterList.get(i).getReimbursementId()%>
			</td>
			<td>
				<%=submitterList.get(i).getType()%>
			</td>
			<td>
				<%=submitterList.get(i).getApproverEmpId()%>
			</td>
			<td>
				<%=submitterList.get(i).getAmount()%>
			</td>
			<td>
				<%=submitterList.get(i).getOperationDate()%>
			</td>
			<td>
				<%=submitterList.get(i).getStatus()%>
			</td>
			<td>
				<input type="submit" name="submitterView" value="View" >
				<input type="submit" name="Update" value="Update" >
				<input type="submit" name="Delete" value="Delete" >
			</td>
		</tr>
<%
	}
%>
		</table>
	</td>
	</tr>	
</table>
<%
}
%>
<%if(approverList != null) {%>
		
<table width="100%" >
	<tr>
		<td>
			<h3>Summary of reimbursement forms awaiting your approval</h3>
		</td>
	</tr>
	<tr>
	 <td>
		<table width="70%" class="summarytable">
		<thead >
		<tr>
			<td>
				Form Id
			</td>
			<td>
				Type
			</td>
			<td>
				Submitted by
			</td>
			<td>
				Amount
			</td>
			<td>
				Last operation date
			</td>
			<td>
				Status
			</td>
			<td>
				Action
			</td>
		</tr>
		</thead>
<%
	for(int i=0;i<approverList.size();i++){
		httpSession.setAttribute("approverVO", approverList.get(i));
%>
		<tr>
			<td>
				<%=approverList.get(i).getReimbursementId()%>
			</td>
			<td>
				<%=approverList.get(i).getType()%>
			</td>
			<td>
				<%=approverList.get(i).getEmpId()%>
			</td>
			<td>
				<%=approverList.get(i).getAmount()%>
			</td>
			<td>
				<%=approverList.get(i).getOperationDate()%>
			</td>
			<td>
				<%=approverList.get(i).getStatus()%>
			</td>
			<td>
			    <input type="button" name="ApproverView" value="View" >
				<input type="button" name="Approve" value="Approve" >
				<input type="submit" name="Reject" value="Reject" > 
			</td>
		</tr>
<%
	}
%>
		</table>
	</td>
	</tr>	
</table>
<%
}
%>
</form>
</body>
</html>