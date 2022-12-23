function redir() {
    const boxes = document.querySelectorAll('.box')
    console.log(boxes) // массивоподобный объект

    var counter = 1;


    let items = new Array();

    boxes.forEach(element => {
            let needToDownload = element.querySelector('.needToDownload').checked;
            if (needToDownload) {
                let fontFamily = element.querySelector('.selectedFont').value;
                let fontSize = element.querySelector('.fontSize').value;
                let bold = element.querySelector('.boldChange').checked;
                let italic = element.querySelector('.cursiveChange').checked;
                let clName = element.querySelector('.className').value; //если пустой - вписываем чтонибудь, неповторимое.
                if (clName === "") {
                    clName = "NameClass" + counter;
                    counter++;

                }

                let color = element.querySelector('.colConnected').value;
                let accordionText = element.querySelector('.accordion').textContent; //функции работы со строками substr, slice одну из них, чтобы выделить p,h1,h3
                var start = accordionText.indexOf("<") + 1;
                var end = accordionText.indexOf(">");
                accordionText = accordionText.substring(start, end);

                // console.log(needToDownload, fontFamily, fontSize, bold, italic, clName, color, accordion)

                var box = {                 // превратить в JSON
                    "type": "TextTag",
                    "tagName": accordionText,
                    "fontFamily": fontFamily,
                    "fontSize": fontSize,
                    "bold": bold,
                    "italic": italic,
                    "color": color,
                    "clName": clName
                };

                items.push(box);

            }

        }
    );
    // console.log(items)

    var biba = {
        "items": items
    };

    var myJSON = JSON.stringify(biba);
    console.log(myJSON)

/////////////////////////////////////////////////////////////
    var date = new Date();

    let name =  date.getFullYear() + date.getMonth() + date.getDay() + date.getHours() + date.getMinutes() + date.getSeconds() + date.getMilliseconds();

    document.cookie = "name=" + name;

    let xhr = new XMLHttpRequest();
    xhr.open("POST", "/getJSON")  //method - post
    xhr.send(myJSON)

    xhr.onload = function () {
        window.location.replace("/questhtml")
    };

    xhr.onerror = function () {

        alert(`Ошибка соединения`);
    };
}