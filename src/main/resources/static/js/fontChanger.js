let list = document.querySelectorAll('.selectedFont'); //Берем лист
let cursive = document.querySelectorAll('.cursiveChange')
let bold = document.querySelectorAll('.boldChange')
let fontsize = document.querySelectorAll('.fontSize')
let panel = document.querySelectorAll('.panel')
let language = document.querySelectorAll('.changeLanguage')
let toChange = document.querySelectorAll('.toChange'); //Берем текст, который будем менять

for( let i = 0; i < list.length; i++) {
    list[i].addEventListener("click", function () {
        list[i].value = "";
    });
    list[i].addEventListener("change", function () {
        toChange[i].style.fontFamily = list[i].value;
    }); //При изменении в листе меняем текст
    cursive[i].addEventListener('change', function () {
        if (cursive[i].checked === true) {
            toChange[i].style.fontStyle = "italic";
        } else {
            toChange[i].style.fontStyle = "";
        }
    });
    bold[i].addEventListener('change', function () {
        if (bold[i].checked === true) {
            toChange[i].style.fontWeight = "bold";
        } else {
            toChange[i].style.fontWeight = "normal";
        }
    });
    fontsize[i].addEventListener('change', function () {
        toChange[i].style.fontSize = fontsize[i].value + "px";
    });
    language[i].addEventListener('click', function () {
        if (language[i].textContent === "eng") {
            toChange[i].textContent = "Поешь этих сладких булок, да выпей же чаю";
            language[i].textContent = "rus";
        } else if(language[i].textContent === "rus") {
            toChange[i].textContent = "Cozy sphinx waves quart jug of bad milk";
            language[i].textContent = "eng";
        }
    })
}
