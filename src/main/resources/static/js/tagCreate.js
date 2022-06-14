let tagBtn = document.querySelector('.createptag');
let boxes = document.querySelector('.boxes');

function createElement(template,elementName){
    let deleteTagBox = template.querySelector('.deleteTagBox');
    let txt = document.createTextNode("<"+ elementName +">");
    deleteTagBox.parentNode.insertBefore(txt,deleteTagBox);
    let elem = document.createElement(elementName);
    elem.className = "toChange";
    elem.style = "font-family: Roboto;";
    elem.innerText = "Cozy sphinx waves quart jug of bad milk";
    return elem;
}
function createNewBox(elementName = "p") {
    let template = document.querySelector('.template').cloneNode(true);
    template.className = "box";
    template.style = "";
    if (tagBtn.value != null && tagBtn.value!=undefined){
        elementName = tagBtn.value;
    }
    let elem = createElement(template,elementName);
    template.querySelector(".val").appendChild(elem);
    boxes.appendChild(template);
    lastAccordSet();
    lastChangerSet();
    closeModal();
}
tagBtn.addEventListener('click', createNewBox);

