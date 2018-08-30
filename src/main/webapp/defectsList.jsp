<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="in.iedtt.entity.Defect"%>
<%@page import="java.util.List"%>
<%@page import="in.iedtt.entity.Response"%>
<%
	Response resp = (Response)request.getAttribute("response");
	String status = null; 
	String statusMessage = null;
	List<Defect> defects = new ArrayList<Defect>();
	if(resp!=null){
		status = resp.getStatus();
		statusMessage = resp.getStatusMessage();
		defects = (List<Defect>)resp.getResponseObject();
	}
%>
<html lang="en">
<script type="text/javascript">
function loadDefectForEdit(defectId) {
	alert(defectId);
}
</script>
<head>
	<title>Defects</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/perfect-scrollbar/perfect-scrollbar.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->

<script type="text/javascript">
	console.log("all defects list response : " + "<%=resp%>");
</script>
</head>
<body>
	
	<div class="limiter">
				<div class="table100 ver2 m-b-110" style="overflow:scroll; height:500px;">
					<table data-vertable="ver2">
						<thead>
							<tr class="row100 head">
								<th class="column100 column2" data-column="column1">Defect Id</th>
								<th class="column100 column1" data-column="column2">Description</th>
								<th class="column100 column1" data-column="column3">Project</th>
								<th class="column100 column1" data-column="column4">Module</th>
								<th class="column100 column3" data-column="column5">Status</th>
								<th class="column100 column4" data-column="column6">Identified By</th>
								<th class="column100 column5" data-column="column7">Assigned To</th>
								<th class="column100 column6" data-column="column8">ETA</th>
								<th class="column100 column7" data-column="column9">Date</th>
								<th class="column100 column8" data-column="column10">RCA</th>
							</tr>
						</thead>
						<tbody>
						<% for(Defect defect:defects){ %>
							<tr class="row100">
								<td class="column100 column2" data-column="column1"><a href="javascript:loadDefectForEdit(<%= defect.getId()%>);"><%= defect.getId()%></a></td>
								<td class="column100 column1" data-column="column2"><%= defect.getDescription()%></td>
								<td class="column100 column1" data-column="column3"><%= defect.getDescription()%></td>
								<td class="column100 column1" data-column="column4"><%= defect.getDescription()%></td>
								<td class="column100 column3" data-column="column5"><%= defect.getStatus()%></td>
								<td class="column100 column4" data-column="column6"><%= defect.getIdentifiedBy()%></td>
								<td class="column100 column5" data-column="column7"><%= defect.getAssignedTo()%></td>
								<td class="column100 column6" data-column="column8"><%= defect.getEta()%></td>
								<td class="column100 column7" data-column="column9"><%= defect.getDefectDate()%></td>
								<td class="column100 column8" data-column="column10"><%= defect.getRca()%></td>
							</tr>
						<%} %>
						</tbody>
					</table>
				</div>
	</div>


	

<!--===============================================================================================-->	
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>