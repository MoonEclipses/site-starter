let list = document.querySelector('#list'); //Берем лист
const toChange = document.querySelector('.toChange'); //Берем текст, который будем менять

list.addEventListener("change", change) //При изменении в листе меняем текст

function change() {
    toChange.style.fontFamily = list.options[list.selectedIndex].text;
}