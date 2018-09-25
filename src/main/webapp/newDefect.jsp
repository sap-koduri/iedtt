<%@page import="in.iedtt.entity.Project"%>
<%@page import="in.iedtt.entity.UserProfile"%>
<%@page import="java.util.List"%>
<%@page import="in.iedtt.entity.Response"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	String userId = String.valueOf(request.getSession().getAttribute("userId"));
	Response findAllUsers = (Response) request.getSession().getAttribute("findAllUsers");
	List<Project> projects = (List<Project>) request.getSession().getAttribute("projects");
	List<UserProfile> users = null;
	String usrNames = "<option value=\"select\">Select</option>";
	if(findAllUsers !=null){
		users = (List<UserProfile>)findAllUsers.getResponseObject();
		 if(users!=null && !users.isEmpty()){
		    	for(int i=0;i<users.size();i++){
		    		usrNames+="<option value=\""+users.get(i).getEmailId()+"\">"+users.get(i).getFirstName()+" "+ users.get(i).getLastName()+"</option>";
		    	}
		 }
	}
	String prjcts = "<option value=\"select\">Select</option>";
	if(projects !=null){
		for(int i=0;i<projects.size();i++){
			prjcts+="<option value=\""+projects.get(i).getProjectName()+"\">"+projects.get(i).getProjectName()+"</option>";
    	}
	}
%>
<head>
<title>Online Defect Tracking System</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" href="layout/styles/layout.css" type="text/css" />
<script src="js/jquery.1.9.1.min.js"></script>  
<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<link href = "https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css"
         rel = "stylesheet">
<style type="text/css">
	.rightCell{
		width: 173px;
	}
</style>

<script type="text/javascript">
$( document ).ready(function() {
	$("#assignedTo").val("");
    $("#assignedTo").append('<%=usrNames%>');
    $("#projectName").append('<%=prjcts%>');
    $("#defectDate").datepicker();
});

</script>
<script type="text/javascript">
function isValidDate(dateVal){
	  if (dateVal.match(/^(?:(0[1-9]|1[012])[\- \/.](0[1-9]|[12][0-9]|3[01])[\- \/.](19|20)[0-9]{2})$/)){
	    return true;
	  }else{
	    return false;
	  }
	}
</script>
<script type="text/javascript">
function validateForm() {
	if(isValidDate($("#defectDate").val()) == true){
		return true;
	}else{
		alert(" Give date in mm/dd/yyyy format");
		return false;
	}
}
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
     <h1><a href="home.jsp">Online Defect Tracking System</a></h1>
      <p>ODTS</p>
    </div>
    <ul id="topnav">
    </ul>
    <br class="clear"/>
  </div>
</div>

<div class="wrapper col3">
  <div id="intro">
			<div>
					<section>
						<div id="newDefect">
						<div>
							<h2>Defect</h2>
							<p><h3>Create New Defect</h3></p>
							<div>
								<section>
									<form method="post" action="./CreateDefectServlet" onsubmit="return validateForm()">
										<table>
											<tr>
												<td>Description</td>
												<td><input type="text" name="description" id="description" value="" required="required" class="rightCell"/></td>
											</tr>
											<tr>
												<td>Project Name</td>
												<td>
													<select id="projectName" name="projectName" required="required" class="rightCell">
														
													</select>
												</td>
											</tr>
											<tr>
												<td>Module Name</td>
												<td>
													<select id="moduleName" name="moduleName" required="required" class="rightCell">
														
													</select>
												</td>
											</tr>
											<tr>
												<td>status</td>
												<td>
													<select id="status" name="status" required="required" class="rightCell">
														<option value="New">New</option>
<!-- 														<option value="Open">Open</option> -->
<!-- 														<option value="Fixed">Fixed</option> -->
<!-- 														<option value="ReTest">Re Test</option> -->
<!-- 														<option value="Closed">Close</option> -->
													</select>
												</td>
											</tr>
											<tr>
												<td>identifiedBy</td>
												<td><input type="email" name="identifiedBy" id="identifiedBy" value="<%= userId %>" required="required" class="rightCell"/></td>
											</tr>
											<tr>
												<td>assignedTo</td>
												<td>
													<select id="assignedTo" name="assignedTo" required="required" class="rightCell">
														
													</select>
												</td>
											</tr>
											<tr>
												<td>Defect Identified Date</td>
												<td><input type="text" name="defectDate" id="defectDate" value="" required="required" class="rightCell" readonly="readonly"/></td>
											</tr>
<!-- 											<tr> -->
<!-- 												<td>ETA</td> -->
<!-- 												<td><input type="date" name="eta" id="eta" value="" required="required" class="rightCell"/></td> -->
<!-- 											</tr> -->
<!-- 											<tr> -->
<!-- 												<td>RCA</td> -->
<!-- 												<td><input type="text" name="rca" id="rca" value="" class="rightCell"/></td> -->
<!-- 											</tr> -->
											<tr>
											<td>
												
											</td>
											<td>
												<input type="submit" value="Create" />
											</td>
											</tr>
										</table>
									</form>
								</section>
							</div>
						</div>
						</div>
						<div id="defects">
						
						</div>
					</section>
			</div>
    
    
    <br class="clear" />
  </div>
</div>
<div class="wrapper col5">
  <div id="footer">
   
    <div class="footbox last">
      <h2>Developer Details !</h2>
      <address>
      Company Name<br />
      Street Name &amp; Number<br />
      Town<br />
      Postcode/Zip<br />
      </address>
      Tel: xxxxx xxxxxxxxxx 
      <!-- --> 
    </div>
    <br class="clear" />
  </div>
</div>
<div class="wrapper col6">
  <div id="copyright">
    <p class="fl_left">Copyright &copy; 2018 - All Rights Reserved - <a href="#">Laxmi</a></p>
    <p class="fl_right">. <a target="_blank" href="#" title="More info">.</a></p>
    <br class="clear" />
  </div>
</div>
<script type="text/javascript">

$("#projectName").change(function(){
      $.post("./GetProjectModulesServlet",
    	  	{
    	  		projectName: this.value
    	    },
    	        function(data,status){
    	    	if(status == "success")
    	            console.log("Data: " + data + "\nStatus: " + status);
    	    	  $("#moduleName").append(data);
    	        });
});

</script>
</body>
</html>