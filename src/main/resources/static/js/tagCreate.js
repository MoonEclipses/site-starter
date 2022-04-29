let pTagBtn = document.querySelector('.createptag');
let boxes = document.querySelector('.boxes');

pTagBtn.addEventListener('click', function () {


    let tagBox = document.createElement('div')
    let accordBtn = document.createElement('button');
    let panelDiv = document.createElement('div');
    let pTag = document.createElement('p');
    let fontStyle = document.createElement('input');
    let cursiveStyle = document.createElement('input');
    let boldStyle = document.createElement('input');
    let fontSizeStyle = document.createElement('input');
    let fontChangeLanguage = document.createElement('button');
    let pCutter = document.createElement('p');
    let labelCurs = document.createElement('label');
    let labelBold = document.createElement('label');
    let labelSize = document.createElement('label');
    let labelFontStyle = document.createElement('label');

    let deleteTagBox = document.createElement('span')

    tagBox.className = "box";

    accordBtn.className = "accordion";
    accordBtn.innerHTML = "&lt;p&gt;"
    panelDiv.className = "panel";

    fontStyle.type = "text";
    fontStyle.setAttribute('list', 'fontlist');
    fontStyle.className = "selectedFont";
    fontStyle.autocomplete = "off";

    pTag.className = "toChange";
    pTag.innerHTML = "Cozy sphinx waves quart jug of bad milk";

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

    deleteTagBox.className = "deleteTagBox";
    deleteTagBox.innerHTML = "&times;";

    boxes.append(tagBox);
    tagBox.append(accordBtn);


    tagBox.append(panelDiv);
    panelDiv.append(deleteTagBox);
    panelDiv.append(fontStyle);
    panelDiv.append(pCutter);
    pCutter.append(labelCurs);
    labelCurs.append("Курсив");
    labelCurs.append(cursiveStyle);
    pCutter.append(labelBold);
    labelBold.append("Жирный");
    labelBold.append(boldStyle);
    pCutter.append(labelSize);
    labelSize.append("Размер текста");
    labelSize.append(fontSizeStyle);
    pCutter.append(fontChangeLanguage);
    panelDiv.append(pTag);

    lastaccordset();
    lastchangerset();
    closeModal();
});

