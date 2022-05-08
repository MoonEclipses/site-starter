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
    let backgroundColor = boxes.querySelectorAll('.toChangeBackgroundColor');
    let divVal = boxes.querySelectorAll('.val');
    let classCheckbox = boxes.querySelectorAll('.needToDownload');
    let labelClassName = boxes.querySelectorAll('.labelClassName');
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

        });
        fontColor[list.length - 1].addEventListener('input',function () {
            toChange[list.length - 1].style.color = fontColor[list.length - 1].value;
        });
        backgroundColor[list.length - 1].addEventListener('input',function () {
            divVal[list.length - 1].style.backgroundColor = backgroundColor[list.length - 1].value;
        });
        $(classCheckbox[list.length - 1]).change(function () {
            if(classCheckbox[list.length - 1].checked) {
                $(labelClassName[list.length - 1]).fadeIn(300);
            } else {
                $(labelClassName[list.length - 1]).fadeOut(300);
            }
        });
        $(deleteTagBox[list.length - 1]).click(function() {
            $(tagBox[list.length - 1]).slideUp();
        });
}
lastChangerSet();