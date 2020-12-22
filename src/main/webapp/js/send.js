
let response;
export function sendData(requestType,url,dataToSend)
{
    var request = new XMLHttpRequest();
    let response;
    request.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
          console.log("response is received");
          response = this.responseText;
            
        }
      };
      
    request.open(requestType,url,true);
    if(requestType === "Post")
    {
      request.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
      request.send(JSON.stringify(dataToSend));
    }
    else
    {
      request.send();
    }
    return request;
    
}
