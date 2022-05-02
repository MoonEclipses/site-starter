function lastAccordSet() {
    let boxes = document.querySelector('.boxes');
    let acc = boxes.getElementsByClassName("accordion");
    acc[acc.length - 1].addEventListener("click", function() {
        this.classList.toggle("active");
        let panel = this.nextElementSibling;
        if (panel.style.maxHeight){
            panel.style.maxHeight = null;
        } else {
            panel.style.maxHeight = panel.scrollHeight + "px";
        }
    });
}
lastAccordSet();
