
function ready() {
    let xhr = new XMLHttpRequest();
    //ссылка https://www.googleapis.com/webfonts/v1/webfonts?key=AIzaSyCpITb3IwHT5c99X-0Cj54hp8iL_D8-fAE
    xhr.open('GET', 'https://www.googleapis.com/webfonts/v1/webfonts?key=AIzaSyCpITb3IwHT5c99X-0Cj54hp8iL_D8-fAE&sort=popularity');
    //вместо ссылки при запуске серва должно стоять /fonts/get
    xhr.responseType = 'json';
    xhr.send(null);
    let datalist = document.querySelectorAll('.selectedFont');

    xhr.onload = function () {
        let fonts = xhr.response.items;
        fonts.forEach((element) => {
            let option = document.createElement('option');
            option.value = element.family;
            option.innerText = element.family;
            datalist[datalist.length-1].appendChild(option);})
        createNewBox();
    };
}
