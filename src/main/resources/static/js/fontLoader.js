document.addEventListener("DOMContentLoaded", ready)

function ready() {
    let xhr = new XMLHttpRequest();
    //ссылка https://www.googleapis.com/webfonts/v1/webfonts?key=AIzaSyCpITb3IwHT5c99X-0Cj54hp8iL_D8-fAE
    xhr.open('GET', '/font/getarr');
    //вместо ссылки при запуске серва должно стоять /fonts/get
    xhr.responseType = 'json';
    xhr.send();
    let datalist = document.getElementById('fontlist');

    xhr.onload = function () {
        let fonts = xhr.response;
        for (let i = 0; i < fonts.items.length; i++){
            let option = document.createElement('option');
            option.value = fonts[i];
            datalist.appendChild(option);
        }
    };
}
