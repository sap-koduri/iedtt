<%@page import="in.iedtt.entity.Response"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>Online Defect Tracking System</title>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<style type="text/css">
	.rightCell{
		width: 143px;
	}
</style>
<link rel="stylesheet" href="layout/styles/layout.css" type="text/css" />
<script src="js/jquery.1.9.1.min.js"></script>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
	// Load google charts
	google.charts.load('current', {'packages':['corechart']});
	google.charts.setOnLoadCallback(drawChart);
	
	// Draw the chart and set the chart values
	function drawChart() {
	  var data = google.visualization.arrayToDataTable([
	  ['Defect Status', 'Number of Defects'],
	  ['New', 10],
	  ['Open',15],
	  ['Fixed',20],
	  ['Re Test',25],
	  ['Closed', 30]
	]);
	
	  // Optional; add a title and set the width and height of the chart
	  var options = {'title':'Defects Report', 'width':550, 'height':400};
	
	  // Display the chart inside the <div> element with id="piechart"
	  var chart = new google.visualization.PieChart(document.getElementById('piechart'));
	  chart.draw(data, options);
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
						<h3>Report</h3>
						<div>
						<form action="">
						<table>
							<tr>
								<td> <label class="rightCell">From Date</label> </td>
								<td> <label class="rightCell">To Date</label> </td>
								<td> <label class="rightCell">Status</label> </td>
								<td> <label class="rightCell">Project</label> </td>
								<td> <label class="rightCell">Module</label> </td>
								<td> <label class="rightCell"></label> </td>
							</tr>
							<tr>
								<td>
									<input type="date" id="fromDate" name="fromDate" placeholder="from date"  class="rightCell"></input>
								</td>
								<td>
									<input type="date" id="toDate" name="toDate" placeholder="to date"  class="rightCell"></input>
								</td>
								<td>
									<select id="status" name="status" required="required" class="rightCell"  class="rightCell">
										<option value="">Select</option>
										<option value="New">New</option>
										<option value="Open">Open</option>
										<option value="Fixed">Fixed</option>
										<option value="ReTest">Re Test</option>
										<option value="Closed">Close</option>
									</select>
								</td>
								<td>
									<select id="projectName" name="projectName" required="required" class="rightCell">
									<option value="">Select</option>
									</select>
								</td>
								<td>
									<select id="moduleName" name="moduleName" required="required" class="rightCell">
									<option value="">Select</option>
									</select>
								</td>
								<td>
									<input type="submit" value="Get Report"  class="rightCell"></input>
								</td>
							</tr>
						</table>
						</form>
						</div>
						<div>
							<section>
								<div id="piechart">
									
								</div>
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
    <br class="clear" />
  </div>
</div>
</body>
</html>