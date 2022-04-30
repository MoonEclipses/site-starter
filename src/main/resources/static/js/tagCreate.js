let tagBtn = document.querySelector('.createptag');
let boxes = document.querySelector('.boxes');

function createElement(template,elementName){
    template.querySelector('.accordion').innerText = "<"+ elementName +">";
    let elem = document.createElement(elementName);
    elem.className = "toChange";
    elem.innerText = "Cozy sphinx waves quart jug of bad milk";
    return elem;
}

tagBtn.addEventListener('click', function () {
    let template = document.querySelector('.template').cloneNode(true);
    template.className = "box";
    template.style = "";
    let elem = createElement(template,tagBtn.value);
    let deleteTagBox = document.createElement('span')
    deleteTagBox.className = "deleteTagBox";
    deleteTagBox.innerHTML = "&times;";
    template.querySelector(".panel").appendChild(deleteTagBox);
    template.querySelector(".val").appendChild(elem);
    boxes.appendChild(template);
    lastaccordset();
    lastchangerset();
    closeModal();
});

