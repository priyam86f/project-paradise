//Algorithm to generate passwords

//1. First sync the input password range as well as input number together.
//such that the range increases with increase in number automatically. 

//2. Now check which all fields are selected on clicking the submit attribute.

//3. Now, we need respective arrays with their ASCII codes that they belong to.
//then, write the boilerplate array.

//4. Finally we can now execute the generate password logic by applying all the
//above features.

//variables
let upper = document.getElementById('incUpperCase')
let form = document.getElementById('password-gen')
let num = document.getElementById('incNumbers')
let symbol = document.getElementById('incSymbols')
let passwordDisplay = document.getElementById('password-display')
//arrays 
//4
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

//1.
let rangeEl = document.getElementById('charRange')
let numberEl = document.getElementById('charNum')

rangeEl.addEventListener('input',syncFunction)
numberEl.addEventListener('input',syncFunction)

function syncFunction(e){
    const value = e.target.value;
    rangeEl.value = value
    numberEl.value = value
}

//2. 
form.addEventListener('submit',e=>{
    e.preventDefault()
    const getPasswordRange = numberEl.value
    const isUppercaseSelected = upper.checked
    const isNumberSelected = num.checked
    const isSymbolSelected = symbol.checked

    const password = generatePassword(getPasswordRange,isUppercaseSelected,isNumberSelected,isSymbolSelected )
    passwordDisplay.innerText=password


})

//Setting up the array from where we will pick up the random values

function generatePassword(getPasswordRange,isUppercaseSelected,isNumberSelected,isSymbolSelected){
let charCodes = LOWER_CASE_CHAR_CODES

if(isUppercaseSelected){
    charCodes = charCodes.concat(UPPERCASE_CHAR_CODES);
}
if(isSymbolSelected){
    charCodes = charCodes.concat(SYMBOL_CHAR_CODES);
}
if(isNumberSelected){
    charCodes = charCodes.concat(NUMBERS_CHAR_CODES);
}

//core implementation
let generatedPassword = []
for(let i=0;i<getPasswordRange;i++){
const char = charCodes[Math.floor(Math.random()*charCodes.length)]
generatedPassword.push(String.fromCharCode(char))
}
return generatedPassword.join('')
}

//3
function arrayfromLowToHigh(low,high){
    const array = []
    for(let i=low;i<=high;i++){
        array.push(i)
    }
    return array
}