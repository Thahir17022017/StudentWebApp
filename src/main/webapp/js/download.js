"use strict";

var searchStd = document.getElementById("searchBox");
var error = document.getElementById("error");
var downloadLink = document.getElementById("download");

function clearMessage()
{
    error.innerText = "";
    searchStd.value = "";
	download.style.visibility = "hidden";
}

function searchStudent()
{
   
    console.log("searchStudent",searchStd.value);
    if(searchStd.value.trim() === "" || searchStd.value.trim() === "null")
    {
        error.innerText = "Student cannot be null or empty";
    }
    else{
        import('./send.js?v=1717022017201717').then((transport) => {
            var request = transport.sendData("GET", "./webapi/download?search="+searchStd.value.trim(), "");
			searchStd.value = "";
            request.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) {
                    console.log("request sent status : ", "pass");
					var response = JSON.parse(this.responseText);
					if(response["status"] === "fail")
					{
						error.innerText = "Student is not onboarded yet !!!";
					}
					else
					{
						console.log("Response Download",response["student"][0]);
						var downloadData = "text/json;charset=utf-8," + encodeURIComponent(JSON.stringify(response["student"][0]));
						downloadLink.href="data:" + downloadData;
						downloadLink.download=response["student"][0].firstName+".json";
						downloadLink.innerText=response["student"][0].firstName+".json";
						download.style.visibility = "visible";
					}
                }};

        }).catch((err)=>{
            console.log("Error in transport", err);
        });

    }
    
}