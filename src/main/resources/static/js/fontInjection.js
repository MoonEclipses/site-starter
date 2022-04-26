function inject(fontName){
    let style = document.getElementById("fs");
    if (!style){
        style = document.createElement("link");
        style.setAttribute("rel","stylesheet");
        style.setAttribute("href","https://fonts.googleapis.com/css?family=");
        style.setAttribute("id","fs");
        document.head.appendChild(style);
    }
    let curPath = style.getAttribute("href");
    style.setAttribute("href", curPath + fontName + "|");
}