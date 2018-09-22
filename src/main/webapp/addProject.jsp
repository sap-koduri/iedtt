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
							<form method="post" action="./ProjectRegistrationServlet">
								<table>
									<tr>
										<td>
											<label for="First Name">Project Name</label>
										</td>
										<td>
											<input type="text" name="projectName" id="projectName" required="required"/>
										</td>
									  </tr>
										<tr>
										<td>
											<label for="Last Name">Description</label>
												</td>
												<td>
													<input type="text" name="description" id="description" required="required"/>
												</td>
											</tr>

										<tr>
										<td>
											<label for="Last Name">Module</label>
												</td>
												<td>
													<input type="text" name="module" id="module" required="required"/>
												</td>
											</tr>
											<tr>
												<td>
													
												</td>
												<td>
													<input type="submit" value="Add Project"/>
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