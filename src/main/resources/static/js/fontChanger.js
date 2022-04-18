let list = document.querySelectorAll('.selectedFont'); //Берем лист
const toChange = document.querySelectorAll('.toChange'); //Берем текст, который будем менять

for( let i = 0; i < list.length; i++) {
    list[i].addEventListener("click", function () {
        list[i].value = "";
    });
    list[i].addEventListener("change", function () {
        toChange[i].style.fontFamily = list[i].value;
    }); //При изменении в листе меняем текст
}
