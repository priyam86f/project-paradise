let rangeEl = document.getElementById('charRange');
let numberEl = document.getElementById('charNum');
let form = document.getElementById('password-gen')
let isUppercaseSelected = document.getElementById('incUpperCase');
let isSymbolSelected = document.getElementById('incSymbols')
let isNumberSelected = document.getElementById('incNumbers')
let random_password = document.getElementById('password-display')

//4. arraysfromLowToHigh to get the ascii range
const LOWER_CASE_CHAR_CODES = arrayfromLowToHigh(97,122)
const UPPERCASE_CHAR_CODES = arrayfromLowToHigh(65,90)
const NUMBERS_CHAR_CODES = arrayfromLowToHigh(48,57)
//we need to concat multiple arrays as the ASCII range of symbols is distributed
let SYMBOL_CHAR_CODES = arrayfromLowToHigh(33,47).concat(
    arrayfromLowToHigh(58,64)
).concat(
    arrayfromLowToHigh(91,96)
).concat(
    arrayfromLowToHigh(123,126)
)

//now sync them

rangeEl.addEventListener('input',syncFunction);
numberEl.addEventListener('input',syncFunction);

function syncFunction(e){
    const value = e.target.value;
    rangeEl.value=value;
    numberEl.value=value;
}

//2 now we need to know which inputs were selected

form.addEventListener('submit',e=>{
e.preventDefault();
let getPasswordRange = rangeEl.value;
let upper = isUppercaseSelected.checked;
let num = isNumberSelected.checked;
let symbol = isSymbolSelected.checked;

const password = generatedPassword(getPasswordRange,upper,num,symbol)
random_password.innerText = password
})


function generatedPassword(getPasswordRange,upper,num,symbol){
    let chars = LOWER_CASE_CHAR_CODES

    if(upper){
        chars=chars.concat(UPPERCASE_CHAR_CODES)
    }if(symbol){
        chars=chars.concat(SYMBOL_CHAR_CODES)
    }if(num){
        chars=chars.concat(NUMBERS_CHAR_CODES)
    }

    let passwordArray = []
    for(let i=0;i<getPasswordRange;i++){
        const char = chars[Math.floor(Math.random() * chars.length)]
        passwordArray.push(String.fromCharCode(char))
    }
    return passwordArray.join('')
}

function arrayfromLowToHigh(low,high){
    let chars = []
    for(let i=low;i<=high;i++){
        chars.push(i);
    }
    return chars;
}