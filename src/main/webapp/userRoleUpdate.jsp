<%@page import="in.iedtt.util.UserRoles"%>
<%@page import="in.iedtt.entity.Response"%>
<%@page import="in.iedtt.entity.UserProfile"%>
<%@page import="java.util.List"%>
<%@page import="in.iedtt.entity.Response"%>
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
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Online Defect Tracking System</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" href="layout/styles/layout.css" type="text/css" />
<script src="js/jquery.1.9.1.min.js"></script>
<script type="text/javascript">
$( document ).ready(function() {
	$("#users").val("");
    $("#users").append('<%=usrNames%>');
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
     <h1><a href="home.jsp">Online Defect Tracking System</a></h1>
      <p>ODTS</p>
    </div>
    <ul id="topnav">
    	 <li><a href="./adminPanel.jsp">Admin Home</a></li>
    </ul>
    <br class="clear"/>
  </div>
</div>

<div class="wrapper col3">
  <div id="intro">
			<div>
				<section>
					<div id="regDiv">
						<h2>Project</h2>
						<p><h3>registration</h3></p>
						<div>
								<section>
									<form method="post" action="./UpdateUserRoleServlet">
										<table>
										<tr>
											<td>
												<label for="user Name">User Name</label>
											</td>
											<td>
												<select id="users" name="users" required="required" style="width:200px;">
														
												</select>
											</td>
										  	</tr>
											<tr>
											<td>
												<label for="Role">Role</label>
											</td>
											<td>
												<select id="role" name="role" style="width: 200px;">
													<option value="<%=UserRoles.NEW_USER%>">NEW USER</option>
													<option value="<%=UserRoles.DEVELOPER%>">DEVELOPER</option>
													<option value="<%=UserRoles.TESTER%>">TESTER</option>
													<option value="<%=UserRoles.LEAD%>">LEAD</option>
													<option value="<%=UserRoles.MANAGER%>">MANAGER</option>
													<option value="<%=UserRoles.SCRUM_MASTER%>">SCRUM MASTER</option>
												</select>
											</td>
										  </tr>
											<tr>
											<td>
											</td>
											<td>
												<input type="submit" value="Update Role">
											</td>
										  </tr>
										</table>
									</form>
								</section>
							</div>
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