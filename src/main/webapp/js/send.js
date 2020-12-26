

export function sendData(requestType,url,dataToSend)
{
    var request = new XMLHttpRequest();
    request.open(requestType,url,true);
    request.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
	if(requestType === "POST" || requestType === "PUT")
    {
      request.send(JSON.stringify(dataToSend));
    }
    else
    {
      request.send();
    }
	return request; 

}
