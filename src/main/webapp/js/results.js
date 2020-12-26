function getResults()
{
    import('./send.js?v=1717').then((transport) => {
        // Do something with the module.
       var request = transport.sendData("GET","./webapi/students","");
       request.onreadystatechange = function() {
        	if (this.readyState == 4 && this.status == 200) {
            var response = JSON.parse(this.responseText);
			if(Array.isArray(response))
            {
                console.log("json array received",response);
				var parentNode = document.getElementById("tbody");
				for(var i=0;i<response.length;i++)
				{
					var row = parentNode.insertRow(i);
					var cell1 = row.insertCell(0);
					cell1.innerHTML = i+1;
					var cell2 = row.insertCell(1);
					cell2.innerHTML = response[i].firstName;
					var cell3 = row.insertCell(2);
					cell3.innerHTML = response[i].middleName;
					var cell4 = row.insertCell(3);
					cell4.innerHTML = response[i].lastName;
					var cell5 = row.insertCell(4);
					cell5.innerHTML = response[i].age;
					var cell6 = row.insertCell(5);
					cell6.innerHTML = response[i].gender;
					var cell7 = row.insertCell(6);
					cell7.innerHTML = response[i].mark1;
					var cell8 = row.insertCell(7);
					cell8.innerHTML = response[i].mark2;
					var cell9 = row.insertCell(8);
					cell9.innerHTML = response[i].mark3;
					var cell10 = row.insertCell(9);
					cell10.innerHTML = response[i].total;
					var cell11 = row.insertCell(10);
					cell11.innerHTML = "<i class='fas fa-trash-alt'></i>";
							
				}
				
				
            }
		}
		};
               
    }).catch((err)=>{
        console.log("Error in transport",err);
    });
}

