<%@page import="java.util.HashMap"%>
<%@page import="in.iedtt.entity.DefectComment"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="in.iedtt.entity.Defect"%>
<%@page import="in.iedtt.entity.UserProfile"%>
<%@page import="java.util.List"%>
<%@page import="in.iedtt.entity.Response"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<head>
<title>Online Defect Tracking System</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" href="layout/styles/layout.css" type="text/css" />
<script src="js/jquery.1.9.1.min.js"></script>
<style>
.rightCell {
	width: 173px;
}
</style>
<%
	String userId = String.valueOf(request.getSession().getAttribute("userId"));
	Response findAllUsers = (Response) request.getSession().getAttribute("findAllUsers");
	Response defectDetails = (Response) request.getSession().getAttribute("response");
	HashMap<String, UserProfile> userProfilesMap = (HashMap<String, UserProfile>) request.getSession().getAttribute("userProfilesMap");
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
	List<DefectComment> commentsByDefectId = (List<DefectComment>)request.getSession().getAttribute("commentsByDefectId");
%>
<head>

<script type="text/javascript">
var defectStatus = '<%=defect.getStatus()%>';
$( document ).ready(function() {
	console.log('<%=defect%>');
    $("#defectId").val('<%=defect.getId()%>');
    $("#description").val('<%=defect.getDescription()%>');
    $("#projectName").val('<%=defect.getProjectName()%>');
    $("#moduleName").val('<%=defect.getModuleName()%>');
    $("#status").val('<%=defect.getStatus()%>');
    $("#identifiedBy").val('<%=userProfilesMap.get(defect.getIdentifiedBy()).getFirstName() + " "+userProfilesMap.get(defect.getIdentifiedBy()).getLastName()%>');
    $("#assignedTo").append('<%=usrNames%>');
    $("#assignedTo").val('<%=defect.getAssignedTo()!= null ?defect.getAssignedTo():""%>');
    $("#defectDate").val('<%=defect.getDefectDate()!= null ?defect.getDefectDate():""%>');
    $("#eta").val('<%=defect.getEta()!= null ?defect.getEta():"" %>');
    $("#rca").val('<%=defect.getRca()!= null ?defect.getRca():"" %>');
});
$("#status").change(function(){
	
	if(defectStatus != this.val){
		
	}
	
});
</script>
</head>
<body id="top">
<div class="wrapper col1">
  <div id="topbar">
  </div>
</div>
<div class="wrapper col2">
  <div id="header">
    <div class="fl_left">
      <h1><a href="./home.jsp">Online Defect Tracking System</a></h1>
      <p>ODTS</p>
    </div>
    <ul id="topnav">
     <li><a href="./newDefect">Defect</a></li>
      <li><a href="./adminPanel.jsp">Admin Page</a></li>
    </ul>
    <br class="clear"/>
  </div>
</div>
<div class="wrapper col3">
  <div id="intro">
			<div>
				<section>
					<div>
						<div>
							<h2>Edit defect here</h2>
							<div id="defectsListDiv">
									<form method="post" action="./EditDefectServlet">
										<table >
											<tr>
												<td>Defect Id</td>
												<td><input type="text" name="defectId" id="defectId" value=""
													required="required" class="rightCell" readonly="readonly" /></td>
												<td>Description</td>
												<td><input type="text" name="description" id="description"
													value="" required="required" class="rightCell" readonly="readonly" /></td>
											</tr>
											<tr>
												<td>Project Name</td>
												<td><input type="text" id="projectName" name="projectName"
													required="required" class="rightCell" readonly="readonly" /></td>
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
												<td>identifiedBy</td>
												<td><input type="email" name="identifiedBy" id="identifiedBy"
													value="" required="required" class="rightCell" readonly="readonly" /></td>
											</tr>
											<tr>
												<td>assignedTo</td>
												<td>
													<select id="assignedTo" name="assignedTo" required="required" class="rightCell">
													</select>
												</td>
												<td>Defect Identified Date</td>
												<td><input type="datetime" name="defectDate" id="defectDate"
													value="" required="required" class="rightCell" readonly="readonly" /></td>
											</tr>
											<tr>
												<td>ETA</td>
												<td><input type="date" name="eta" id="eta" value=""
													required="required" class="rightCell" placeholder="MM/DD/YYYY"/></td>
												<td>RCA</td>
												<td><textarea  name="rca" id="rca" 
													class="rightCell" placeholder="Root Cause of Defect Analysis"></textarea></td>
											</tr>
											<tr>
												<td></td>
												<td></td>
												<td></td>
												<td><input type="submit" value="Update" /></td>
											</tr>
										</table>
									</form>
								<form action="./NewCommentServlet" method="post">
									<input type="hidden" id="defectId" name="defectId" value="<%=defect.getId()%>"/>
									<table>
										<tr>
											<td>Comment</td>
											<td><textarea name="comment" id="comment" required="required" style="width:728px;"></textarea></td>
											<td><input type="submit" value="Add"  style="width:100px;"/></td>
										</tr>
									</table>
								</form>
							</div>
						</div>
					</div>
				</section>
			</div>

  </div>
</div>
<div class="wrapper col5">
  <div id="footer">
    <div class="footbox last">
      <h2>Comments</h2>
      <div style="width: 1000px;overflow:scroll; max-height:120px; min-height:30px; overflow-x: hidden;">
     	<table style="width: 969px;">
     	<% for(DefectComment defectComment : commentsByDefectId){ %>
			<tr>
				<td style="width:100px;"><label style="color: blue;"><%= userProfilesMap.get(defectComment.getCommentor()).getFirstName() + " "+userProfilesMap.get(defectComment.getCommentor()).getLastName()%></label></td>
				<td style="width:600px;"><label style="color: black;"><%= defectComment.getComment()%></label></td>
				<td style="width:100px;"><label style="color: gray;"><%= defectComment.getDate()%></label></td>
			</tr>
			<%} %>
		</table>
		</div>
    </div>
    <br class="clear" />
    <br class="clear" />
    <br class="clear" />
    <br class="clear" />
    <br class="clear" />
    <br class="clear" />
  </div>
</div>
</body>
</html>