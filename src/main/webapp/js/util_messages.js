function displayDiv(divName){
	try{
		$("#addMessageDiv").hide(1000);
//		$("#addMessageDiv").empty();
		$("#updateMessageDiv").hide(1000);
//		$("#updateMessageDiv").empty();
		$("#readMessageDiv").hide(1000);
//		$("#readMessageDiv").empty();
		$("#searchMessageDiv").hide(1000);
//		$("#searchMessageDiv").empty();
		$("#deleteMessageDiv").hide(1000);
//		$("#deleteMessageDiv").empty();
		$("#updateMessageContentDiv").hide(1000);
		$("#" + divName).show(1000);

		if(divName == 'addMessageDiv'){
			$("#owner").val(sessionStorage.getItem("emailId"));
		}else if(divName == 'readMessageDiv'){
			readMessages();
		} else if(divName == 'deleteMessageDiv'){
			deleteMessages();
		}else if(divName == 'searchMessageDiv'){
			$("#searchMessageDiv").show(1000);
		}else if(divName == 'updateMessageDiv'){
			getMessagesForUpdate(false);
		}
	}catch(ex){alert(ex);}
}





