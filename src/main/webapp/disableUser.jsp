<%@page import="in.iedtt.entity.Response"%>
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
	usrNames+="<option value=\"\">Select User</option>";
	if(findAllUsers !=null){
		users = (List<UserProfile>)findAllUsers.getResponseObject();
		 if(users!=null && !users.isEmpty()){
		    	for(int i=0;i<users.size();i++){
		    		usrNames+="<option value=\""+users.get(i).getEmailId()+"\">"+users.get(i).getFirstName()+", "+ users.get(i).getLastName()+"</option>";
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
	$("#userIds").val("");
    $("#userIds").append('<%=usrNames%>');
});

</script>
<script type="text/javascript">
    $(function () {
        $("#userIds").change(function () {
            var selectedText = $(this).find("option:selected").text();
            var tokens = selectedText.split(',');
            $("#firstName").val(tokens[0]);
            $("#lastName").val(tokens[1]);
        });
    });
    function validateForm() {
    	var selectedUserId = $(this).val();
    	if(selectedUserId == ""){
    		return false;
    	}
    	return true;
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
      <h1><a href="#">Online Defect Tracking System</a></h1>
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
								<form method="post" action="./DisableUserServlet"  onsubmit="return validateForm()">
										<table>
											<tr>
												<td><label for="userIds">User Id</label></td>
												<td>
													<select id="userIds" name="userIds" required="required" style="width:173px;">
														
													</select>
												</td>
											</tr>
											<tr>
												<td><label for="First Name">First Name</label></td>
												<td><input type="text" name="firstName" id="firstName" required="required" disabled="disabled" style="width:173px;"/></td>
											</tr>
											<tr>
												<td><label for="First Name">Last Name</label></td>
												<td><input type="text" name="lastName" id="lastName" required="required" disabled="disabled" style="width:173px;"/></td>
											</tr>
	
											<tr>
												<td></td>
												<td><input type="submit" value="Disable" /></td>
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