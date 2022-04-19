let list = document.querySelector('.selectedFont'); //Берем лист
const toChange = document.querySelector('.toChange'); //Берем текст, который будем менять



list.addEventListener("click", function () {
    list.value = "";

})
list.addEventListener("change", change) //При изменении в листе меняем текст

function change() {
    toChange.style.fontFamily = list.value;
}