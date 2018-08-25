<%@page import="in.iedtt.entity.UserProfile"%>
<%@page import="java.util.List"%>
<%@page import="in.iedtt.entity.Response"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	String userId = String.valueOf(request.getSession().getAttribute("userId"));
	Response findAllUsers = (Response) request.getSession().getAttribute("findAllUsers");
	List<UserProfile> users = null;
	String usrNames = "";
	if(findAllUsers !=null){
		users = (List<UserProfile>)findAllUsers.getResponseObject();
		 if(users!=null && !users.isEmpty()){
		    	for(int i=0;i<users.size();i++){
		    		usrNames+="<option value=\""+users.get(i).getEmailId()+"\">"+users.get(i).getFirstName()+" "+ users.get(i).getLastName()+"</option>";
		    	}
		 }
	}
%>
<head>
<title>Online Defect Tracking System</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" href="layout/styles/layout.css" type="text/css" />
<script src="js/jquery.1.9.1.min.js"></script>

<script type="text/javascript">
$( document ).ready(function() {
	$("#assignedTo").val("");
    $("#assignedTo").append('<%=usrNames%>');
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
      <h1><a href="#">Online Defect Tracking System</a></h1>
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
									<form method="post" action="./CreateDefectServlet">
										<table>
											<tr>
												<td>Description</td>
												<td><input type="text" name="description" id="description" value="" required="required" style="width:173px;"/></td>
											</tr>
											<tr>
												<td>status</td>
												<td>
													<select id="status" name="status" required="required" style="width:173px;">
														<option value="0">New</option>
														<option value="1">Open</option>
														<option value="2">Fixed</option>
														<option value="3">Re Test</option>
														<option value="4">Close</option>
													</select>
												</td>
											</tr>
											<tr>
												<td>identifiedBy</td>
												<td><input type="email" name="identifiedBy" id="identifiedBy" value="<%= userId %>" required="required" style="width:173px;"/></td>
											</tr>
											<tr>
												<td>assignedTo</td>
												<td>
													<select id="assignedTo" name="assignedTo" required="required" style="width:173px;">
														
													</select>
												</td>
											</tr>
											<tr>
												<td>ETA</td>
												<td><input type="date" name="eta" id="eta" value="" required="required" style="width:173px;"/></td>
											</tr>
											<tr>
												<td>Defect Identified Date</td>
												<td><input type="date" name="defectDate" id="defectDate" value="" required="required" style="width:173px;"/></td>
											</tr>
											<tr>
												<td>RCA</td>
												<td><input type="text" name="rca" id="rca" value="" required="required" style="width:173px;"/></td>
											</tr>
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
</body>
</html>