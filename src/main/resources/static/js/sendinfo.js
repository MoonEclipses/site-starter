function sendI() {
    let headers =document.getElementsByClassName("headers");
    let radios = headers[0].querySelectorAll(".headerRadio");
    let hid;
    radios.forEach(elem=>{
        if(elem.checked){
            hid = elem.id;
        }
    })
    let footers =document.getElementsByClassName("footers");
    radios = footers[0].querySelectorAll(".footerRadio");
    let fid;
    radios.forEach(elem=>{
        if(elem.checked){
            fid = elem.id;
        }
    })
    window.location.replace("/downloadPage?hid="+hid+"&fid="+fid);
}

//get через строку пользователя, но не оч 
//post - пользователь не видит