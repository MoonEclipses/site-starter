let backgroundColor = document.querySelectorAll('.toChangeBackgroundColor');
let divVal = document.getElementById('content');
backgroundColor[0].addEventListener('input', function () {
    divVal.style.backgroundColor = backgroundColor[0].value;
});
function lastChangerSet() {
    let boxes = document.querySelector('.boxes'); //Все боксы тегов
    let box =  boxes.querySelectorAll(".box");
    let actBox = box[box.length - 1];
    let list = boxes.querySelectorAll('.selectedFont'); //Изменяемый текст
    let cursive = boxes.querySelectorAll('.cursiveChange') //Курсив
    let bold = boxes.querySelectorAll('.boldChange') //Жирный
    let fontSize = boxes.querySelectorAll('.fontSize') //Размер текста
    let panel = boxes.querySelectorAll('.panel') //Панель
    let language = boxes.querySelectorAll('.changeLanguage')
    let toChange = boxes.querySelectorAll('.toChange');
    let deleteTagBox = boxes.querySelectorAll('.deleteTagBox');
    let tagBox = boxes.querySelectorAll('.box');
    let fontColor = boxes.querySelectorAll('.toChangeFontColor');
    let classCheckbox = boxes.querySelectorAll('.needToDownload');
    let labelClassName = boxes.querySelectorAll('.labelClassName');
    let colCon = boxes.querySelectorAll('.colConnected');
    let copyToClipboard = boxes.querySelectorAll('.copyToClipboard');
    let codeContainer = boxes.querySelectorAll('.codeContainer');
    let className = boxes.querySelectorAll('.className');
    let codeClassName = boxes.querySelectorAll('.codeClassName');
    let codeFontSize = boxes.querySelectorAll('.codeFontSize');
    let codeFontColor = boxes.querySelectorAll('.codeFontColor');
    let codeFontFamily = boxes.querySelectorAll('.codeFontFamily');
    let codeFontStyle = boxes.querySelectorAll('.codeFontStyle');
    let codeFontWeight = boxes.querySelectorAll('.codeFontWeight');
    let codeTag = boxes.querySelectorAll('.language-html')
    colCon[list.length - 1].addEventListener('change', function () {
        toChange[toChange.length - 1].style.color = colCon[list.length - 1].value;
        let value = colCon[list.length - 1].value;
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
    fontSize[list.length - 1].addEventListener('change', function () {
        toChange[toChange.length - 1].style.fontSize = fontSize[list.length - 1].value + "px";
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
    fontColor[list.length - 1].addEventListener('input', function () {
        toChange[toChange.length - 1].style.color = fontColor[list.length - 1].value;
        let value = fontColor[list.length - 1].value;
        colCon[list.length - 1].value = value;
    });

    $(classCheckbox[classCheckbox.length - 1]).change(function () {
        if(classCheckbox[list.length - 1].checked) {
            $(labelClassName[list.length - 1]).fadeIn(300);
        } else {
            $(labelClassName[list.length - 1]).fadeOut(300);
        }
    });
    $(deleteTagBox[deleteTagBox.length - 1]).click(function() {
        $(tagBox[tagBox.length - 1]).slideUp();
        setTimeout(() => { $(tagBox[tagBox.length - 1]).remove(); }, 1000);
    });
    copyToClipboard[list.length - 1].addEventListener('click', function () {
        let copyText = createCodeText();
        navigator.clipboard.writeText(copyText);
    });
    function createCodeText () {
        if (classCheckbox[list.length - 1].checked) {
            let codeText = '.' + className[list.length - 1].value + ' {\n'
                + '\tfont-size: ' + fontSize[list.length - 1].value + ';\n'
                + '\tfont-color: ' + fontColor[list.length - 1].value + ';\n'
                + '\tfont-family: ' + list[list.length - 1].value + ';\n';
            if (cursive[list.length - 1].checked === true) {
                codeText += '\tfont-style: italic' + ';\n';
            }
            if (bold[list.length - 1].checked === true) {
                codeText += '\tfont-weight: bold' + ';\n';
            }
            codeText += '}'
            /*codeTag[list.length - 1].innerHTML = codeText;*/
            return codeText;
        }
    }
    /*actBox.addEventListener('change', function (){
        createCodeText();
    });*/
/*        function createCodeText () {
        if (classCheckbox[list.length - 1].checked) {
            codeClassName[list.length - 1].textContent = '.' + className[list.length - 1].value + ' {';
            codeFontSize[list.length - 1].textContent = '\tfont-size: ' + fontSize[list.length - 1].value + ';';
            codeFontColor[list.length - 1].textContent = '\tfont-color: ' + fontColor[list.length - 1].value + ';';
            codeFontFamily[list.length - 1].textContent = '\tfont-family: ' + list[list.length - 1].value + ';';
            if (cursive[list.length - 1].checked === true) {
                codeFontStyle[list.length - 1].style.display = '';
                codeFontStyle[list.length - 1].textContent =  '\tfont-style: cursive' + ';';
            } else {
                codeFontStyle[list.length - 1].style.display = 'none';
            }

            if (bold[list.length - 1].checked === true) {
                codeFontWeight[list.length - 1].style.display = '';
                codeFontWeight[list.length - 1].textContent = '\tfont-weight: bold' + ';';
            } else {
                codeFontWeight[list.length - 1].style.display = 'none';
            }
        }
    }*/
}
lastChangerSet();
