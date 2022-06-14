let backgroundColor = document.querySelectorAll('.toChangeBackgroundColor');
let divVal = document.getElementById('content');
backgroundColor[0].addEventListener('input', function () {
    divVal.style.backgroundColor = backgroundColor[0].value;
});
function lastChangerSet() {
    let boxes = document.querySelector('.boxes'); //Все боксы тегов
    let list = boxes.querySelectorAll('.selectedFont'); //Изменяемый текст
    let cursive = boxes.querySelectorAll('.cursiveChange') //Курсив
    let bold = boxes.querySelectorAll('.boldChange') //Жирный
    let fontsize = boxes.querySelectorAll('.fontSize') //Размер текста
    let panel = boxes.querySelectorAll('.panel') //Панель
    let language = boxes.querySelectorAll('.changeLanguage')
    let toChange = boxes.querySelectorAll('.toChange');
    let deleteTagBox = boxes.querySelectorAll('.deleteTagBox');
    let tagBox = boxes.querySelectorAll('.box');
    let fontColor = boxes.querySelectorAll('.toChangeFontColor');
    let classCheckbox = boxes.querySelectorAll('.needToDownload');
    let labelClassName = boxes.querySelectorAll('.labelClassName');
    var colCon = boxes.querySelectorAll('.colConnected');

    fontColor[list.length - 1].addEventListener('input', function (e) {

    });

    colCon[list.length - 1].addEventListener('change', function () {
        toChange[toChange.length - 1].style.color = colCon[list.length - 1].value;
        var value = colCon[list.length - 1].value;
        fontColor[list.length - 1].value = value;
    });
    list[list.length - 1].addEventListener("change", function () {
        inject(list[list.length - 1].value);
        toChange[toChange.length - 1].style.fontFamily = list[list.length - 1].value;
    }); //При изменении в листе меняем текст
    cursive[list.length - 1].addEventListener('change', function () {
        if (cursive[list.length - 1].checked === true) {
            toChange[toChange.length - 1].style.fontStyle = "italic";
        } else {
            toChange[toChange.length - 1].style.fontStyle = "";
        }
    });
    bold[list.length - 1].addEventListener('change', function () {
        if (bold[list.length - 1].checked === true) {
            toChange[toChange.length - 1].style.fontWeight = "bold";
        } else {
            toChange[toChange.length - 1].style.fontWeight = "normal";
        }
    });
    fontsize[list.length - 1].addEventListener('change', function () {
        toChange[toChange.length - 1].style.fontSize = fontsize[list.length - 1].value + "px";
    });
    language[list.length - 1].addEventListener('click', function () {
        if (language[list.length - 1].textContent === "eng") {
            toChange[toChange.length - 1].textContent = "Поешь этих сладких булок, да выпей же чаю";
            language[list.length - 1].textContent = "rus";
        } else if (language[list.length - 1].textContent === "rus") {
            toChange[toChange.length - 1].textContent = "Cozy sphinx waves quart jug of bad milk";
            language[list.length - 1].textContent = "eng";
        }
    });
    deleteTagBox[deleteTagBox.length - 1].addEventListener('click', function () {
        tagBox[tagBox.length - 1].remove();
    });
    fontColor[list.length - 1].addEventListener('input', function () {
        toChange[toChange.length - 1].style.color = fontColor[list.length - 1].value;
        var value = fontColor[list.length - 1].value;
        colCon[list.length - 1].value = value;
    });

    classCheckbox[list.length - 1].addEventListener('change', function () {
        if (classCheckbox[list.length - 1].checked) {
            labelClassName[list.length - 1].style.display = "inline";
        } else {
            labelClassName[list.length - 1].style.display = "none";
        }
    });
}
lastChangerSet();