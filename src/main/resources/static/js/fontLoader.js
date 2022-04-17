document.addEventListener("DOMContentLoaded", ready)

function ready() {
    let xhr = new XMLHttpRequest();
    xhr.open('GET', '/fonts/get');
    xhr.responseType = 'json';
    xhr.send();

    xhr.onload = function () {
        let responseObj = xhr.response;
        let fonts = JSON.parse(responseObj);
        alert(fonts.items[0].family);
    };
}
