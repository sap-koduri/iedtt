<%@page import="in.iedtt.entity.Response"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Online Defect Tracking System</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link rel="stylesheet" href="layout/styles/layout.css" type="text/css" />
<script src="js/jquery.1.9.1.min.js"></script>

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
							<form method="post" action="./ProjectRegistrationServlet">
								<table>
									<tr>
										<td>
											<label for="First Name">First Name</label>
										</td>
										<td>
											<input type="text" name="firstName" id="firstName" required="required"/>
										</td>
									  </tr>
									<tr>
										<td>
											<label for="Last Name">Last Name</label>
												</td>
												<td>
													<input type="text" name="lastName" id="lastName" required="required"/>
												</td>
											</tr>
											<tr>
												<td>
													<label for="gender">Gender</label>
												</td>
												<td>
													<select name="gender" id="gender" style="width:173px;">
														<option name="male" id="male">Male</option>
														<option name="female" id="female">Female</option>
													</select>
												</td>
											</tr>
											<tr>
												<td>
													<label for="mobile">Mobile</label>
												</td>
												<td>
													<input type="number" name="mobile" id="mobile" required="required"/>
												</td>
											</tr>
											<tr>
												<td>
													<label for="email">Email</label>
												</td>
												<td>
													<input type="email" name="emailId" id="emailId" required="required"/>
												</td>
											</tr>
											<tr>
												<td>
													<label for="password">Password</label>
												</td>
												<td>
													<input type="password" name="password" id="password" required="required"/>
												</td>
											</tr>
											<tr>
												<td>
													<label for="Security Question 1">Security Question 1</label>
												</td>
												<td>
													<select name="securityQuestion1" id="securityQuestion1" style="width:173px;">
														<option name="fmn" id="fmn">First Mobile Number</option>
														<option name="fsn" id="fsn">First School Name</option>
														<option name="wyb" id="wyb">Where Your Born</option>
													</select>
												</td>
											</tr>
											<tr>
												<td>
													<label for="Security Question Answer 1">Security Question Answer 1</label>
												</td>
												<td>
													<input type="Text" name="securityQuestionAnswer1" id="securityQuestionAnswer1" required="required"/>
												</td>
											</tr>
											<tr>
											<tr>
												<td>
													<label for="Security Question 2">Security Question 2</label>
												</td>
												<td>
													<select name="securityQuestion2" id="securityQuestion2" style="width:173px;">
														<option name="bfn" id="bfn">Best Friend Name</option>
														<option name="mmn" id="mmn">Mother Middle Name</option>
														<option name="fc" id="fc">Favourite colour</option>
													</select>
												</td>
											</tr>
											<tr>
												<td>
													<label for="Security Question Answer 2">Security Question Answer 2</label>
												</td>
												<td>
													<input type="Text" name="securityQuestionAnswer2" id="securityQuestionAnswer2" required="required"/>
												</td>
											</tr>
											<tr>
											<tr>
												<td>
													
												</td>
												<td>
													<input type="submit" value="Register"/>
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