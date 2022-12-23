let tagBtns = document.querySelectorAll('.createptag');
let boxes = document.querySelector('.boxes');
let propTemplates = document.querySelector(".htmlPropTeml");

function createElement(template,elementName){
    let deleteTagBox = template.querySelector('.deleteTagBox');
    let txt = document.createTextNode("<"+ elementName +">");
    deleteTagBox.parentNode.insertBefore(txt,deleteTagBox);
    let elem = document.createElement(elementName);
    return elem;
}
function createNewBox(elementName = "p") {
    let template = document.querySelector('.template').cloneNode(true);
    template.className = "box";
    template.style = "";
    if (this.value != null && this.value!=undefined){
        elementName = this.value;
    }
    let elem = createElement(template,elementName);
    template.querySelector(".val").appendChild(elem);
    boxes.appendChild(template);
    elem.className = "toChange";
    elem.style = "font-family: Roboto;";
    elem.innerText = "Cozy sphinx waves quart jug of bad milk";
    let panel = template.querySelector(".panel");
    tags.forEach((tag)=>{
        if(tag.name === elementName) {
            tag.props.forEach((prop) => {
                let propElem = document.getElementById("prop" + prop.id).cloneNode(true);
                panel.append(propElem);
            })
        }
    });
    let styles = window.getComputedStyle(elem);
    let fontSize = template.querySelector(".fontSize");
    fontSize.value = parseInt(styles.fontSize);
    if(styles.fontWeight >= 700){
        let bold = template.querySelector('.boldChange')
        bold.checked = true;
    }

    lastAccordSet();
    lastChangerSet();
    closeModal();
}
tagBtns.forEach(tagBtn => {
    tagBtn.addEventListener('click', createNewBox);
});

