let startGameButton = document.getElementById('start-btn')
let questionContainer = document.getElementById('question-container')
let nextButton = document.getElementById('next-btn')
startGameButton.addEventListener('click',startGame)

let questionElement = document.getElementById('question')
let answerButtons = document.getElementById('answer-buttons')

let currentQuestionIndex
let shuffledQuestions


nextButton.addEventListener('click',() =>{
  currentQuestionIndex++
  nextQuestion()
})

function startGame(){
  startGameButton.classList.add('hide')
  questionContainer.classList.remove('hide')
  shuffledQuestions = questionsList.sort(() => Math.random() - .5) 
  /*shuffledQuestions is essentially a shuffled version of the questionsList,
   and it's used to present questions to the user in a random order when the game starts. */
  currentQuestionIndex = 0
  nextQuestion()
}
function resetState() {
  clearStatusClass(document.body)
  nextButton.classList.add('hide')
  while (answerButtons.firstChild) {
    answerButtons.removeChild(answerButtons.firstChild)
  }
}
function nextQuestion(){
  resetState()
showQuestion(shuffledQuestions[currentQuestionIndex])
}

/*So, essentially, showQuestion() expects a single question object as an argument, 
and shuffledQuestions[currentQuestionIndex] 
provides exactly that – it provides the current question object to be displayed. */

function showQuestion(question){
  questionElement.innerText = question.question
  question.answer.forEach(answer => {
    const button = document.createElement('button')
    button.innerText = answer.text
    button.classList.add('btn')
    if(answer.correct){
      button.dataset.correct = answer.correct
    }
    button.addEventListener('click',selectAnswer)
    answerButtons.appendChild(button)
  })
}

function selectAnswer(e){
const selectedButton = e.target
const correct = selectedButton.dataset.correct
setStatusClass(document.body,correct)
Array.from(answerButtons.children).forEach(button => {
  setStatusClass(button, button.dataset.correct)
})
if(shuffledQuestions.length > currentQuestionIndex+1){
  nextButton.classList.remove('hide')
}else{
  startGameButton.innerText = 'Restart'
  startGameButton.classList.remove('hide')
}
}

function setStatusClass(element,correct){
  clearStatusClass(element)
  if(correct){
    element.classList.add('correct')
  }else{
    element.classList.add('wrong')
  }
}

function clearStatusClass(element){
  element.classList.remove('correct')
  element.classList.remove('wrong')
}
const questionsList = [
  { question : "What is 2+2?",
    answer : [
      {text:'4',correct:true},
      {text:'6',correct:false},
      {text:'8',correct:false},
      {text:'22',correct:false}
    ]
  },
  { question : "What is 4/2?",
  answer : [
    {text:'2',correct:true},
    {text:'1',correct:false},
    {text:'4',correct:false},
    {text:'20',correct:false}
  ]
},
{
  question: 'Who is the best YouTuber?',
  answer: [
    { text: 'Web Dev Simplified', correct: true },
    { text: 'Traversy Media', correct: true },
    { text: 'Dev Ed', correct: true },
    { text: 'Fun Fun Function', correct: true }
  ]
},
{
  question: 'Is web development fun?',
  answer: [
    { text: 'Kinda', correct: false },
    { text: 'YES!!!', correct: true },
    { text: 'Um no', correct: false },
    { text: 'IDK', correct: false }
  ]
},
{
  question: 'What is 4 * 2?',
  answer: [
    { text: '6', correct: false },
    { text: '8', correct: true }
  ]
}

]