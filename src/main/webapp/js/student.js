"use strict";

// read the respective field references
var fName = readRef("firstname");
var mName = readRef("middlename");
var lName = readRef("lastname");
var age = readRef("age");

// read the respective mark field references
var mark1 = readRef("mark1");
var mark2 = readRef("mark2");
var mark3 = readRef("mark3");

//read the submit and clear button
var submitBtn = readRef("submit");
var clearBtn = readRef("clear");

//read error label ref
var errorLabel = readRef("errorLabel");

function readRef(val)
{
    return document.getElementById(val);
}

function enableButtons()
{
    if(fName.length>0 || mName.length>0 ||lName.length>0 ||age.toString().length>0 
    || mark1.toString().length>0 || mark2.toString().length>0 || mark3.toString().length>0)
    {
        submitBtn.disabled = false;
        clearBtn.disabled = false;
    }
}

function clearValues()
{
    resetfields(fName,mName,lName,age,mark1,mark2,mark3);
    clearBtn.disabled = true;
    submitBtn.disabled = true;
    errorLabel.style.visibility = "hidden";
}

function resetfields(...reset)
{
    for(var i=0;i<reset.length;i++)
    {
                    reset[i].value = "";
    }
}

function sendData()
{
    var ele = document.getElementsByTagName("input");
    var genderValue;
    for(var i=0;i<ele.length;i++)
    {
        if(ele[i].type === "radio" && ele[i].checked === true)
        {
            genderValue = ele[i].value;    
        }
    }
    
    if(fName.value === "" || lName.value === "" || age.value === "" || mark1.value === "" || mark2.value === "" || mark3.value === "" )
    {
        errorLabel.style.visibility = "visible";
    }
    else
    {
        errorLabel.style.visibility = "hidden";
        var jsonPayload = {};
        jsonPayload["fName"] = fName.value;
		jsonPayload["mName"] = mName.value;
        jsonPayload["lName"] = lName.value;
        jsonPayload["gender"] = genderValue;
		jsonPayload["age"] = age.value;
		jsonPayload["mark1"] = mark1.value;
		jsonPayload["mark2"] = mark2.value;
		jsonPayload["mark3"] = mark3.value;
        console.log("jsonPayload",jsonPayload);
        resetfields(fName,mName,lName,age,mark1,mark2,mark3);
        import('./send.js').then((tranport) => {
            // Do something with the module.
            tranport.sendData("GET","https://webhook.site/fbb36875-1b53-4775-a454-4ab8335a91c7","");
        }).catch((err)=>{
            console.log("Error in transport",err);
        });
    }


}