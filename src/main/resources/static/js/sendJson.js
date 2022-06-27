let btnSendJSON = document.querySelectorAll('.JSONbtn');
let xhr = new XMLHttpRequest();


for (let i = 0; i < btnSendJSON.length; i++) {
    btnSendJSON[i].addEventListener("click", function () {

        let jsonStyle = '[{"tagName":"p","fontFamily":"Roboto","fontSize":"10","bold":true,"italic":false,"color":"#AFF0FF","className":"jopka"}]'
        let name = //...
        xhr.open("POST", '/getJSON?name='+name);
        xhr.setRequestHeader('Content-type', 'applictaion/json; charset=utf-8')

        xhr.send(jsonStyle);
        console.log("Отправлено");
    });
}