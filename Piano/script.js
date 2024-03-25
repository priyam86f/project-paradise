//add a querySelector to all the key elements
//write business logic to map audio to respective keys
//then write logic to reduce the current playtime to 0 so that we can press the same key
//multiple times

const WHITE_KEYS = ['z', 'x', 'c', 'v', 'b', 'n', 'm']
const BLACK_KEYS = ['s', 'd', 'g', 'h', 'j']
const blackKeys = document.querySelectorAll('.key.black')
const whiteKeys = document.querySelectorAll('.key.white')


 let keys = document.querySelectorAll('.key')

 keys.forEach(key => {
    key.addEventListener('click',()=>playSound(key))
 })


 function playSound(key){
const noteAudio = document.getElementById(key.dataset.note)
noteAudio.currentTime=0
noteAudio.play()

//to play the piano with respect to keyboard keys,
document.addEventListener('keydown', e =>{
const key = e.key //this gets us the key pressed on the keyboard
const WhiteKeyIndex = WHITE_KEYS.indexOf(key)
const BlackKeyIndex = BLACK_KEYS.indexOf(key)

if(WhiteKeyIndex>-1) playSound(whiteKeys[WhiteKeyIndex])
if(BlackKeyIndex>-1) playSound(blackKeys[BlackKeyIndex])
})

//now we need to add a click effect to know that we are pressing the key

key.classList.add('active')
noteAudio.addEventListener('ended',()=>{
    key.classList.remove('active')
})
 }

//now we need to add eventListeners to each key, 
//and map the corresponding audio with its respective key.
