var randomNumber1 = Math.random();
randomNumber1 = Math.floor(randomNumber1*6);
randomNumber1++;
var randomImg1 = "dice" + randomNumber1 + ".png";
let randompng1 = "images/" + randomImg1;
var randomNumber2 = Math.random();
randomNumber2 = Math.floor(randomNumber2*6);
randomNumber2++;
var randomImg2 = "dice" + randomNumber2 + ".png";
let randompng2 = "images/" + randomImg2;
var image1 = document.querySelectorAll("img")[0];
var image2 = document.querySelectorAll("img")[1];
image1.setAttribute("src" , randompng1);
image2.setAttribute("src" , randompng2);
if (randomNumber1 > randomNumber2){
    let text = document.querySelectorAll("h1");
    text[0].innerHTML = 'Player 1 Wins';
}
else if( randomNumber2 > randomNumber1){
    document.querySelectorAll("h1")[0].innerHTML = 'Player 2 Wins';
}
else document.querySelectorAll("h1")[0].innerHTML = 'Draw';