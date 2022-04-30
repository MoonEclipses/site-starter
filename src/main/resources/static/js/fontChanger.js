
let list = document.querySelectorAll('.selectedFont'); //Берем лист
let cursive = document.querySelectorAll('.cursiveChange')
let bold = document.querySelectorAll('.boldChange')
let fontsize = document.querySelectorAll('.fontSize')
let panel = document.querySelectorAll('.panel')
let language = document.querySelectorAll('.changeLanguage')
let toChange = document.querySelectorAll('.toChange'); //Берем текст, который будем менять
let deleteTagBox = document.querySelectorAll('.deleteTagBox');


function changerset() {
    for (let i = 0; i < list.length; i++) {
        list[i].addEventListener("click", function () {
            list[i].value = "";
        });
        list[i].addEventListener("change", function () {
            inject(list[i].value);
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
            } else if (language[i].textContent === "rus") {
                toChange[i].textContent = "Cozy sphinx waves quart jug of bad milk";
                language[i].textContent = "eng";
            }
        });
        deleteTagBox[list.length - 1].addEventListener('click', function () {
            let tagBox = document.querySelectorAll('.box');
            tagBox[list.length - 1].remove();
        });
    }
}
function lastchangerset() {
    let boxes = document.querySelector('.boxes');
    let list = boxes.querySelectorAll('.selectedFont'); //Берем лист
    let cursive = boxes.querySelectorAll('.cursiveChange')
    let bold = boxes.querySelectorAll('.boldChange')
    let fontsize = boxes.querySelectorAll('.fontSize')
    let panel = boxes.querySelectorAll('.panel')
    let language = boxes.querySelectorAll('.changeLanguage')
    let toChange = boxes.querySelectorAll('.toChange'); //Берем текст, который будем менять
    let deleteTagBox = boxes.querySelectorAll('.deleteTagBox');
        list[list.length - 1].addEventListener("click", function () {
            list[list.length - 1].value = "";
        });
        list[list.length - 1].addEventListener("change", function () {
            inject(list[list.length - 1].value);
            toChange[list.length - 1].style.fontFamily = list[list.length - 1].value;
        }); //При изменении в листе меняем текст
        cursive[list.length - 1].addEventListener('change', function () {
            if (cursive[list.length - 1].checked === true) {
                toChange[list.length - 1].style.fontStyle = "italic";
            } else {
                toChange[list.length - 1].style.fontStyle = "";
            }
        });
        bold[list.length - 1].addEventListener('change', function () {
            if (bold[list.length - 1].checked === true) {
                toChange[list.length - 1].style.fontWeight = "bold";
            } else {
                toChange[list.length - 1].style.fontWeight = "normal";
            }
        });
        fontsize[list.length - 1].addEventListener('change', function () {
            toChange[list.length - 1].style.fontSize = fontsize[list.length - 1].value + "px";
        });
        language[list.length - 1].addEventListener('click', function () {
            if (language[list.length - 1].textContent === "eng") {
                toChange[list.length - 1].textContent = "Поешь этих сладких булок, да выпей же чаю";
                language[list.length - 1].textContent = "rus";
            } else if (language[list.length - 1].textContent === "rus") {
                toChange[list.length - 1].textContent = "Cozy sphinx waves quart jug of bad milk";
                language[list.length - 1].textContent = "eng";
            }
        });
        deleteTagBox[list.length - 1].addEventListener('click', function () {
           let tagBox = document.querySelectorAll('.box');
           tagBox[list.length - 1].remove();
        });

}
changerset();