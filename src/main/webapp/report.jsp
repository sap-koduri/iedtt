<%@page import="in.iedtt.entity.UserProfile"%>
<%@page import="in.iedtt.entity.Project"%>
<%@page import="java.util.List"%>
<%@page import="in.iedtt.entity.Response"%>
<%
	List<Project> projects = (List<Project>) request.getSession().getAttribute("projects");
	String prjcts = "<option value=\"\">Select</option>";
	if(projects !=null){
		for(int i=0;i<projects.size();i++){
			prjcts+="<option value=\""+projects.get(i).getProjectName()+"\">"+projects.get(i).getProjectName()+"</option>";
    	}
	}
%>
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
<script type="text/javascript" src="https://canvasjs.com/assets/script/jquery-1.11.1.min.js"></script>
<script type="text/javascript" src="https://canvasjs.com/assets/script/canvasjs.min.js"></script> 
<script type="text/javascript">
window.onload = function () {
	var newCount = 0;
	var openCount = 0;
	var fixedCount = 0;
	var reTestCount = 0;
	var closedCount =  0;
	var chart = new CanvasJS.Chart("chartContainer", { 
		title: {
			text: "Reports"
		},
		data: [
		{
			type: "column",
			dataPoints: [
              { label: "New", y: newCount },
				{ label: "opened",y:  openCount },
				{ label: "Fixed",y: fixedCount },
				{ label: "ReTest",y:  reTestCount },
				{ label: "closed",y:  closedCount }	
			]
		}
		]
	});
	chart.render();	
	$("#getReport").click(function () {
	var length = chart.options.data[0].dataPoints.length;
	chart.options.title.text = "Reports Based on Search Criteria";
	var fromDate = $("#fromDate").val();
	var toDate = $("#toDate").val();
	var status=$("#status").val();
	var projectName=$("#projectName").val();
	var moduleName=$("#moduleName").val();

	$.post("./GetDefectStatusServlet",
    	  	{
				fromDate: fromDate,
				toDate:toDate,
				status:status,
				projectName:projectName,
				moduleName:moduleName
    	  		
    	    },
    	        function(data,status){
	    	    	if(status == "success"){
	    	            console.log(data);
	    	    		 var counts = data.split(";");
	    	    		 newCount = counts[0].split(":")[1];
	    	    		 openCount = counts[1].split(":")[1];
	    	    		 fixedCount = counts[2].split(":")[1];
	    	    		 reTestCount = counts[3].split(":")[1];
	    	    		 closedCount = counts[4].split(":")[1];
	    	    		 
	    	    		}
	    	    	});
	setTimeout(function(){
		console.log("newCount: " + newCount + "\n openCount: " + openCount+"\n fixedCount: " + fixedCount + "\n reTestCount: " + reTestCount+ "\n closedCount: " + closedCount);
		chart.options.data[0].dataPoints[0].y = parseInt(newCount,10);
		chart.options.data[0].dataPoints[1].y =  parseInt(openCount,10);
		chart.options.data[0].dataPoints[2].y =  parseInt(fixedCount,10);
		chart.options.data[0].dataPoints[3].y =  parseInt(reTestCount,10);
		chart.options.data[0].dataPoints[4].y =  parseInt(closedCount,10);
		chart.render();
	},100);
	chart.render();
	});
}
$( document ).ready(function() {
	$("#projectName").empty();
    $("#projectName").append('<%=prjcts%>');
});
</script>

<script type="text/javascript">
	// Load google charts

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
										<input type="date" id="fromDate" name="fromDate" placeholder="from date" class="rightCell"></input>
									</td>
									<td>
										<input type="date" id="toDate" name="toDate" placeholder="to date" class="rightCell"></input>
									</td>
									<td>
										<select id="status" name="status" class="rightCell"  class="rightCell">
											<option value="">Select</option>
											<option value="New">New</option>
											<option value="Open">Open</option>
											<option value="Fixed">Fixed</option>
											<option value="ReTest">Re Test</option>
											<option value="Closed">Close</option>
										</select>
									</td>
									<td>
										<select id="projectName" name="projectName" class="rightCell">
										<option value="">Select</option>
										</select>
									</td>
									<td>
										<select id="moduleName" name="moduleName" class="rightCell">
										<option value="">Select</option>
										</select>
									</td>
									<td>
										<input type="button" id="getReport" name="getReport"  value="Get Report" class="rightCell" onclick="javascript:getReport();"></input>
									</td>
								</tr>
							</table>
						</div>
						<div>
							<section>
								<div id="chartContainer" style="height: 370px; max-width: 920px; margin: 0px auto;"></div>
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
<script type="text/javascript">

$("#projectName").change(function(){
      $.post("./GetProjectModulesServlet",
    	  	{
    	  		projectName: this.value
    	    },
    	        function(data,status){
    	    	if(status == "success")
    	    	$("#moduleName").empty();
    	            console.log("Data: " + data + "\nStatus: " + status);
    	    	  $("#moduleName").append(data);
    	        });
});

</script>
<script type="text/javascript">
	function getReport() {
		
		

	}
</script>
</body>
</html>