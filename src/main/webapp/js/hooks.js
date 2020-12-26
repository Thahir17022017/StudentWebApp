"use strict";

var request;

function hideSpinner() {
	document.getElementById("getSpinner").style.visibility = "hidden";
	document.getElementById("postSpinner").style.visibility = "hidden";
	document.getElementById("putSpinner").style.visibility = "hidden";
	request = import('./send.js?v=1717');
}

function sendHook(requestTypeVal) {
	
	console.log("requestTypeVal",requestTypeVal);
	request.then((transport) => {
	var requestType="";
	switch (requestTypeVal) {
		case "Get":
			requestType = "GET";
			console.log("GET switch ran",requestType);
			document.getElementById("getSpinner").style.visibility = "visible";
			break;

		case "Post":
			requestType = "POST";
			console.log("POST switch ran",requestType);
			document.getElementById("postSpinner").style.visibility = "visible";
			break;

		case "Put":
			requestType = "PUT";
			console.log("PUT switch ran",requestType);
			document.getElementById("putSpinner").style.visibility = "visible";
			break;
		}
		var request = transport.sendData(requestType, "https://webhook.site/e530c4ef-3d5e-407a-bf63-9289cbd26d5e", "");
		request.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				console.log("request sent status : ", "pass");
				if(requestType === "GET")
				{
					document.getElementById("getSpinner").style.visibility = "hidden";
				}
				else if (requestType === "POST")
				{
					document.getElementById("postSpinner").style.visibility = "hidden";
				}
				else
				{
					document.getElementById("putSpinner").style.visibility = "hidden";
				
				}
				
			}
		};
	}).catch((err) => {
		console.log("Error in transport", err);
	});
}



