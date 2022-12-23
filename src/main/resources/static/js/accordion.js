function lastAccordSet() {
    let boxes = document.querySelector('.boxes');
    let acc = boxes.getElementsByClassName("accordion");
    let arrow = document.querySelectorAll('.arrow');
    acc[acc.length - 1].addEventListener("click", function () {
        this.classList.toggle("active");
        let panel = this.nextElementSibling;
        if (panel.style.maxHeight) {
            panel.style.maxHeight = null;
        } else {
            panel.style.maxHeight = panel.scrollHeight + "px";
        }
        if (arrow[arrow.length - 1].className == 'arrow') {
            arrow[arrow.length - 1].className = 'arrow active';
        } else {
            arrow[arrow.length - 1].className = 'arrow';
        }
    });
}
