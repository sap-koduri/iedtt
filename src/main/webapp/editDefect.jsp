<%@page import="in.iedtt.entity.Defect"%>
<%@page import="in.iedtt.entity.UserProfile"%>
<%@page import="java.util.List"%>
<%@page import="in.iedtt.entity.Response"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String userId = String.valueOf(request.getSession().getAttribute("userId"));
	Response findAllUsers = (Response) request.getSession().getAttribute("findAllUsers");
	Response defectDetails = (Response) request.getAttribute("response");
	Defect defect = new Defect();
	List<UserProfile> users = null;
	String usrNames = "";
	if(findAllUsers !=null){
		users = (List<UserProfile>)findAllUsers.getResponseObject();
		 if(users!=null && !users.isEmpty()){
		    	for(int i=0;i<users.size();i++){
		    		usrNames+="<option value=\""+users.get(i).getEmailId()+"\">"+users.get(i).getFirstName()+" "+ users.get(i).getLastName()+"</option>";
		    	}
		 }
		 if(defectDetails != null){
			 if(defectDetails.getStatus() == "Success"){
				 List<Defect> defects = (List<Defect>)defectDetails.getResponseObject();
				 if(!defects.isEmpty()){
				 	defect =defects.get(0);
				 }
			 }
		 }
	}
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" href="layout/styles/layout.css" type="text/css" />
<script src="js/jquery.1.9.1.min.js"></script>
<style>
.rightCell {
	width: 173px;
}
</style>
<script type="text/javascript">
$( document ).ready(function() {
	console.log('<%=defect%>');
    $("#defectId").val('<%=defect.getId()%>');
    $("#description").val('<%=defect.getDescription()%>');
    $("#projectName").val('<%=defect.getProjectName()%>');
    $("#moduleName").val('<%=defect.getModuleName()%>');
    $("#status").val('<%=defect.getStatus()%>');
    $("#identifiedBy").val('<%=defect.getIdentifiedBy()%>');
    $("#assignedTo").val('<%=defect.getAssignedTo()%>');
    $("#defectDate").val('<%=defect.getDefectDate()%>');
    $("#eta").val('<%=defect.getEta()%>');
    $("#rca").val('<%=defect.getRca()%>');
    
});
</script>
</head>
<body id="top">

	<form method="post" action="#">
		<table>
			<tr>
				<td>Defect Id</td>
				<td><input type="text" name="defectId" id="defectId" value=""
					required="required" class="rightCell" readonly="readonly" /></td>
			</tr>
			<tr>
				<td>Description</td>
				<td><input type="text" name="description" id="description"
					value="" required="required" class="rightCell" readonly="readonly" /></td>
			</tr>
			<tr>
				<td>Project Name</td>
				<td><input type="text" id="projectName" name="projectName"
					required="required" class="rightCell" readonly="readonly" /></td>
			</tr>
			<tr>
				<td>Module Name</td>
				<td><input type="text" id="moduleName" name="moduleName"
					required="required" class="rightCell" readonly="readonly" /></td>
			</tr>
			<tr>
				<td>status</td>
				<td><select id="status" name="status" required="required"
					class="rightCell">
						<option value="New">New</option>
						<option value="Open">Open</option>
						<option value="Fixed">Fixed</option>
						<option value="ReTest">Re Test</option>
						<option value="Closed">Close</option>
				</select></td>
			</tr>
			<tr>
				<td>identifiedBy</td>
				<td><input type="email" name="identifiedBy" id="identifiedBy"
					value="" required="required" class="rightCell" readonly="readonly" /></td>
			</tr>
			<tr>
				<td>assignedTo</td>
				<td><input type="text" id="assignedTo" name="assignedTo"
					required="required" class="rightCell"></td>
			</tr>
			<tr>
				<td>Defect Identified Date</td>
				<td><input type="text" name="defectDate" id="defectDate"
					value="" required="required" class="rightCell" readonly="readonly" /></td>
			</tr>
			<tr>
				<td>ETA</td>
				<td><input type="text" name="eta" id="eta" value=""
					required="required" class="rightCell" /></td>
			</tr>
			<tr>
				<td>RCA</td>
				<td><input type="text" name="rca" id="rca" value=""
					class="rightCell" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Update" /></td>
			</tr>
		</table>
	</form>
</body>
</html>