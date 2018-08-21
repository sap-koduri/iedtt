function login() {

	// get inputs
	try {
		var user = new Object();
		user.emailId = $('#loginId').val();
		user.password = $('#pwd').val();

		$.ajax({
			url : "./LoginServlet",
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
					$("#loginDiv").hide(1000);
					// Check browser support for session storage
					if (typeof(Storage) !== "undefined") {
						// Store
						var responseObject =JSON.parse(JSON.stringify(data.responseObject));
						sessionStorage.setItem("emailId", responseObject.emailId);
						console.log("Email Id stored in session storage. " + sessionStorage.getItem("emailId"));
					} else {
						console.log("Sorry, your browser does not support Web Storage...");
					}
					alert("User Login Success.");
					window.location="./message.html"
				}else{
					alert("User login Failed.\n please verify credentials");
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
