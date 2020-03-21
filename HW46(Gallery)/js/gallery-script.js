'use strict';

let images = ["img/1.jpg", "img/2.jpg", "img/3.jpg", "img/4.jpg", "img/5.jpg",
              "img/6.jpg", "img/7.jpg", "img/8.jpg", "img/9.jpg", "img/10.jpg"
             ];

class Gallery {
    constructor(images) {
        this.images = images;
    }

    static doAnimation(elem, t, f) {
        let fps = f || 50;
        let time = t || 500;
        let steps = time / (1000 / fps);
        let op = 0;
        let d0 = 1 / steps;
        let timer = setInterval(function () {
            op += d0;
            elem.style.opacity = op;
            steps--;
            if (steps <= 0) {
                clearInterval(timer);
            }
        }, (1000 / fps));
    }

    static runSlideshow() {
        clearInterval(timer);
        let retention;
        let regExp = /^[0-9]+$/;
        let time = prompt("Введите интервал в секундах: ");
        if (regExp.test(time)) {
            retention = +time * 1000;
            timer = setInterval(function () {
                Gallery.nextImg();
                Gallery.doAnimation(imgElem, 1000, 50);
                Gallery.curImg();
            }, retention);
        } else {
            alert("Введите цифровое значение!")
        }

    }

    static stopSlideshow() {
        clearInterval(timer);
    };

    static curImg() {
        numberNumbers[0].innerHTML = ` ${i} in ${gallery.images.length}`;
    }

    static nextImg() {
        if (i >= gallery.images.length) {
            i = 0;
            imgElem.src = gallery.images[i++];
        } else {
            imgElem.src = gallery.images[i++];
        }
        Gallery.curImg();
    }

    static prevImg() {
        if (i > 0) {
            imgElem.src = gallery.images[i-2];
            i--;
        }
        if (i === 0) {
            i = gallery.images.length;
            imgElem.src = gallery.images[--i];
            ++i;
        }
        Gallery.curImg();
    }
}

let nextBtn = document.getElementById('nextPhoto');
let previousBtn = document.getElementById('previousPhoto');
let runSlide = document.getElementById('runSlideshow');
let stopSlide = document.getElementById('stopSlideshow');
let imgElem = document.getElementById("img");
let numberNumbers = document.getElementsByClassName('curImg');

let gallery = new Gallery(images);
let timer;
let i = 1;
Gallery.curImg();

nextBtn.onclick = Gallery.nextImg;
previousBtn.onclick = Gallery.prevImg;
runSlide.onclick = Gallery.runSlideshow;
stopSlide.onclick = Gallery.stopSlideshow;

