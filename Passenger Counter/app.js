
let count=0;
let counter = document.getElementById("cntr")
function increase(){
counter.innerHTML++;
}

function decrease(){
    counter.innerHTML--;
    if(counter.innerHTML<0){
        console.error("Count cannot go below 0");
    }
}

function reset(){
    counter.innerHTML=0;
}

let saveEl = document.getElementById("save-el")
function save(){
    let countStr = counter.innerHTML + " - "
    saveEl.innerText+=countStr
}