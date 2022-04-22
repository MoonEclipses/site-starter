let btnSendJSON = document.querySelectorAll('.JSONbtn');
let xhr = new XMLHttpRequest();


for (let i = 0; i < btnSendJSON.length; i++) {
    btnSendJSON[i].addEventListener("click", function () {
        let toChange = document.querySelectorAll('.toChange');

        let styles = {
            fontFamily: toChange[i].style.fontFamily,
            fontSize: toChange[i].style.fontSize,
            fontWeight: toChange[i].style.fontWeight,
            fontStyle: toChange[i].style.fontStyle
        }


        let jsonStyle = JSON.stringify(styles);

        xhr.open("POST", '../../../java');
        xhr.setRequestHeader('Content-type', 'applictaion/json; charset=utf-8')

        xhr.send(jsonStyle);
        console.log("Отправлено");
    });
}