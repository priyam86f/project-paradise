

/*localStorage is used to persistently store the leads data in the browser's local storage. This
 enables the application to retain the leads even after the user refreshes the page or closes the browser. */



let myLeads = [];
let listItems = "";
const saveInput = document.getElementById("save-btn"); //this will store the leads in the myLeads array
const inputEl = document.getElementById("input-el") //this is where the leads will be saved
const ulEl = document.getElementById("ul-el") //to display the leads
const leadsFromLocalStorage = JSON.parse(localStorage.getItem("myLeads"))
let deleteBtn = document.getElementById("del-btn");
let saveBtn = document.getElementById("save-tab");


//this just checks the truthy or falsy values
if (leadsFromLocalStorage) {
    myLeads = leadsFromLocalStorage 
    //this line retrieves an array of strings from the local storage of the browser
    //and assigns it to the currrent myleads array.
    //this is primarily done to make sure that whenever the page loads, the leads are still available in the local storage.
 
}



//save, whenever we click on this, the leads should be displayed on the 
//page as well as stored in localStorage
saveInput.addEventListener('click',function(){
   myLeads.push(inputEl.value)
   inputEl.value=" "
   localStorage.setItem("myLeads",JSON.stringify(myLeads));
   render(myLeads)
})


 //we are using the chrome API to interact with chrome and get the URL of the current tab.
saveBtn.addEventListener('click',function(){
    chrome.tabs.query({ active: true, currentWindow: true }, function (tabs) {
        /*to save the leads in the local storage, we carry out the below operations. */
        myLeads.push(tabs[0].url);
        localStorage.setItem("myLeads",JSON.stringify(myLeads))
        render(myLeads)
      });
  
})

//clear the leads 
deleteBtn.addEventListener('click',function(){
    localStorage.clear();
    myLeads=[];
    ulEl.innerHTML=""   
})



//display the saved leads
function render(leads){
    listItems=""
for(let i=0;i<leads.length;i++){
    listItems+= "<li> <a target='_blank' href='"+leads[i]+"'>" + " "+ leads[i] + " </a></li>" //innerHTML
}
ulEl.innerHTML = listItems;
}