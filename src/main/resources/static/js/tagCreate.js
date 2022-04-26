let btnptag = document.querySelector('.createptag');
let boxes = document.querySelector('.boxes');

btnptag.addEventListener('click', function () {

    let accordbtn = document.createElement('button');
    let paneldiv = document.createElement('div');
    let ptag = document.createElement('p');
    let fontStyle = document.createElement('input');
    let cursiveStyle = document.createElement('input');
    let boldStyle = document.createElement('input');
    let fontSizeStyle = document.createElement('input');
    let fontChangeLanguage = document.createElement('button');
    let pCutter = document.createElement('p');
    let labelcurs = document.createElement('label');
    let labelbold = document.createElement('label');
    let labelsize = document.createElement('label');
    let labelfontStyle = document.createElement('label');

    accordbtn.className = "accordion";
    accordbtn.innerHTML = "&lt;p&gt;"
    paneldiv.className = "panel";

    fontStyle.type = "text";
    fontStyle.setAttribute('list', 'fontlist');
    fontStyle.className = "selectedFont";
    fontStyle.autocomplete = "off";

    ptag.className = "toChange";
    ptag.innerHTML = "Cozy sphinx waves quart jug of bad milk";

    cursiveStyle.className = "cursiveChange";
    cursiveStyle.type = "checkbox";

    boldStyle.className = "boldChange";
    boldStyle.type = "checkbox";

    fontSizeStyle.className = "fontSize";
    fontSizeStyle.type = "number";
    fontSizeStyle.min = "1";
    fontSizeStyle.value = "16";
    fontSizeStyle.step = "1";
    fontSizeStyle.max = "36";

    fontChangeLanguage.className = "changeLanguage";
    fontChangeLanguage.innerHTML = "eng";

    boxes.append(accordbtn);
    boxes.append(paneldiv);

    paneldiv.append(fontStyle);
    paneldiv.append(pCutter);
    pCutter.append(labelcurs);
    labelcurs.append("Курсив");
    labelcurs.append(cursiveStyle);
    pCutter.append(labelbold);
    labelbold.append("Жирный");
    labelbold.append(boldStyle);
    pCutter.append(labelsize);
    labelsize.append("Размер текста");
    labelsize.append(fontSizeStyle);
    pCutter.append(fontChangeLanguage);
    paneldiv.append(ptag);

    lastaccordset();
    lastchangerset();
    closeModal();
});

