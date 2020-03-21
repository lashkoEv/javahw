'use strict';

let checked = false;
let input = document.getElementById('input');
input.addEventListener('keydown', function (e) {
    if (e.code === 'Enter') {
        let style = window.getComputedStyle(document.getElementsByTagName('div')[0]).height;
        let height = parseInt(style);
        document.getElementsByTagName('div')[0].style.height = (height + 40) + 'px';
        let li = document.getElementById('items').appendChild(document.createElement('li'));
        let label = li.appendChild(document.createElement('label'));
        input = label.appendChild(document.createElement('input'));
        input.setAttribute('type', 'checkbox');
        input.id = 'checked';
        let span = li.appendChild(document.createElement('span'));
        span.appendChild(document.createTextNode(this.value));
        let a = li.appendChild(document.createElement('a'));
        a.setAttribute('href', '#');
        a.append(document.createTextNode("Delete"));
        checked = true;
        a.addEventListener('click', function () {
            let style = window.getComputedStyle(document.getElementsByTagName('div')[0]).height;
            let height = parseInt(style);
            this.parentNode.remove();
            document.getElementsByTagName('div')[0].style.height = (height - 40) + 'px';
        });
        input.addEventListener('click', function () {
            span.classList.toggle('checked');
        });
    }
});

