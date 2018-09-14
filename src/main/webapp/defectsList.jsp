<!DOCTYPE html>
<%@page import="in.iedtt.entity.UserProfile"%>
<%@page import="java.util.HashMap"%>
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
	
	 HashMap<String, UserProfile> userProfilesMap = (HashMap<String, UserProfile>)request.getSession().getAttribute("userProfilesMap");
	 if(userProfilesMap == null){
		 userProfilesMap = new  HashMap<String, UserProfile>();
	 }
%>
<html lang="en">
<link rel="stylesheet" href="./css/modal.css">
<script type="text/javascript">

//Get the modal
var modal = document.getElementById('myModal');
//Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
span.onclick = function() {
    modal.style.display = "none";
}
function loadDefectForEdit(defectId) {
// 	alert(defectId);
// 	 $.post("./UpdateDefectServlet",
// 	    	  	{
// 		 			defectId:defectId
// 	    	    },
// 	    	    function(data,status){
// 	    	   		if(status == "success"){
// 	    	   			defectDetailsDiv
// 	    	        	console.log("Data: " + data + " Status: " + status);
// 	    	   		}
// 	    	    });
// 	    $( "#defectDetailsDiv").load("./UpdateDefectServlet?defectId="+defectId, function() {
//     		console.log("defects details are  loaded");
//     });
//     $( "#defectDetailsDiv").load("./UpdateDefectServlet?defectId="+defectId, function() {
//     		console.log("defects list loaded");
//     });
//   	modal.style.display = "block";
	document.location.href = './UpdateDefectServlet?defectId='+defectId;
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
	<link rel="stylesheet" type="text/css" href="css/modal.css">
<script type="text/javascript">
	console.log("all defects list response : " + "<%=resp%>");
</script>
</head>
<body>
	
	<div class="limiter">
				<div class="table100 ver2 m-b-110" style="overflow:scroll; max-height:500px; min-height:0px; overflow-x: hidden;">
					<table data-vertable="ver2">
						<thead>
							<tr class="row100 head">
								<th class="column100 column2" data-column="column1">Defect Id</th>
								<th class="column100 column1" data-column="column3">Project</th>
								<th class="column100 column1" data-column="column4">Module</th>
								<th class="column100 column3" data-column="column5">Status</th>
								<th class="column100 column4" data-column="column6">Identified By</th>
								<th class="column100 column5" data-column="column7">Assigned To</th>
								<th class="column100 column6" data-column="column8">ETA</th>
								<th class="column100 column7" data-column="column9">Date</th>
							</tr>
						</thead>
						<tbody>
						<% for(Defect defect:defects){ %>
							<tr class="row100">
								<td class="column100 column2" data-column="column1"><a href="javascript:loadDefectForEdit(<%= defect.getId()%>);"><%= defect.getId()%></a></td>
								<td class="column100 column1" data-column="column3"><%= defect.getProjectName()%></td>
								<td class="column100 column1" data-column="column4"><%= defect.getModuleName()%></td>
								<td class="column100 column3" data-column="column5"><%= defect.getStatus()%></td>
								<td class="column100 column4" data-column="column6"><%= userProfilesMap.get(defect.getIdentifiedBy()).getFirstName() + "  " +userProfilesMap.get(defect.getIdentifiedBy()).getLastName() %></td>
								<td class="column100 column5" data-column="column7"><%= userProfilesMap.get(defect.getAssignedTo()).getFirstName() + "  " + userProfilesMap.get(defect.getAssignedTo()).getLastName()%></td>
								<td class="column100 column6" data-column="column8"><%= defect.getEta() == null ? "" : defect.getEta() %></td>
								<td class="column100 column7" data-column="column9"><%= defect.getDefectDate()%></td>
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