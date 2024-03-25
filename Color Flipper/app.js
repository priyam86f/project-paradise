let lightblue = document.getElementById("box2");
function changeToLightBlue(){
    let currentColor = document.body;
    lightblue.addEventListener('click',function(){
        currentColor.style.background = 'linear-gradient(to bottom, #26a0da, #314755)';
    })
}

let brightBlue = document.getElementById("box4")
function changeToBrightBlue(){
    let currentColor = document.body;
    brightBlue.addEventListener('click',function(){
        currentColor.style.background = 'linear-gradient(to bottom, #00CDAC, #02AAB0)';
    })
}

let chirpyRed = document.getElementById("box1")
function changeToChirpyRed(){
    let currentColor = document.body;
    chirpyRed.addEventListener('click',function(){
        currentColor.style.background = 'linear-gradient(to bottom, #EA384D, #D31027)'
    })
}

let crazyOrange = document.getElementById("box3")
function changeToCrazyOrange(){
    let currentColor = document.body;
    crazyOrange.addEventListener('click',function(){
        currentColor.style.background = 'linear-gradient(to bottom, #F9D423, #e65c00)';
    })
}