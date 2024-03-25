


let sum = 0;
let hasBlackJack = false;
let cards = [];
let isAlive = false;
let message = ""
let messageEl = document.getElementById("msg");
let sumEl = document.getElementById("sum");
let cardEl = document.getElementById("cards");

let player = {
    playerName: "Priyam",
    money: 145
}

playerEl = document.getElementById("player-el");
playerEl.textContent = player.playerName + ": $" + player.money;

//logic

function startGame() {
    isAlive = true
    let firstCard = randomCard()
    let secondCard = randomCard()
    cards = [firstCard, secondCard]
    sum = firstCard + secondCard
    renderGame()
}
function renderGame() {

    cardEl.textContent = "Cards: " + " ";
    for (let i = 0; i < cards.length; i++) {
        cardEl.textContent += cards[i] + " "
    }
    if (sum <= 20) {

        message = "Do you want to draw a New Card?🤨"
    } else if (sum === 21) {
        message = "Wohooo! It's a BlackJack!🥳"
        hasBlackJack = true
    } else {
        isAlive = false;
        message = "Oops! You are out of the game!😔"
    }
    messageEl.textContent = message;
    sumEl.textContent = "Sum: " + sum;

}

function newCard() {
    if (hasBlackJack === false && isAlive === true) {
        let newCard = randomCard();
        message = "Drawing a new card from the Deck...🃏🃏"
        messageEl.innerText = message;
        cards.push(newCard)
        sum += newCard
        renderGame()
    } else {
        message = "NAN"
    }
    renderGame()
}

function randomCard() {
    let randomNumber = Math.floor(Math.random() * 13) + 1
    if (randomNumber === 1) {
        return 11
    } else if (randomNumber > 10) {
        return 10
    }
    return randomNumber
}

