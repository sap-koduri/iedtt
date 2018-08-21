function registration() {

	// get inputs
	try {
		var user = new Object();
		user.firstName = $('#firstName').val();
		user.lastName = $('#lastName').val();
		user.mobile = $('#mobile').val();
		user.address = $('#address').val();
		user.emailId = $('#emailId').val();
		user.password = $('#password').val();

		$.ajax({
			url : "./RegistrationServlet",
			type : 'POST',
			dataType : 'json',
			data : JSON.stringify(user),
			contentType : 'application/json',
			mimeType : 'application/json',

			success : function(data) {
				var respJSONString = JSON.stringify(data);
				console.log(respJSONString);
				var jsonObj = JSON.parse(respJSONString);
				console.log(jsonObj.status + " : " + jsonObj.statusMessage);
				if(jsonObj.status == "Success"){
					$("#regDiv").hide(1000);
					alert("User Registration Success.");
					window.location="./index.html"
				}else{
					alert("User Registration Failed.\n please verify details");
				}
			},

			error : function(data, status, er) {
				alert("error: " + data + " status: " + status + " er:" + er);
			}
		});
	} catch (ex) {
		alert(ex);
	}
}