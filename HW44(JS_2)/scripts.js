'use strict';

var color = "red";
function task1() {
    color = random();
    document.writeln(`<div style="background:${color()};height:100px;width:100px;"></div>`)
    printColor();
    document.write("<a href='index.html'>Назад к списку</a>");
}

function setColor() {
    return function () {
        return "black";
    }
}

function printColor() {
    var color = setColor();
    console.log(`Local color = ${color()} global color = ${window.color}`);
}

function random() {
    return function () {
        if ((Math.random() * 10) <= 5) {
            return "red";
        } else {
            return "black";
        }
    }
}


function task2() {
    let questions = [
        "1. Обнаружив, что любимые джинсы порвались, вы" +
            "\nвыкидываете их — 0" +
            "\nделаете еще несколько художественных разрезов и продолжаете носить — 1",
        "2. Подружка попросила вас побыть с ее ребенком-непоседой. Вы" +
            "\nвключите ему телевизор или видеоигру  — 0" +
            "\nокунетесь в детство и вместе придумаете веселую увлекательную игру — 1",
        "3. Часто ли вам снятся сны? " +
            "\nДа, вы обычно помните сновидения, они яркие и интересные — 1" +
            "\nНет, вы редко запоминаете сны — 0",
        "4. Какую работу вы предпочтете — ту, где известно, что и как делать, или ту, в которой необходимо что-то придумывать?" +
            "\nИнтереснее самостоятельно искать решения проблем, даже если это требует временных затрат — 1 " +
            "\nВам проще работать, когда существует четкий алгоритм — 0",
        "5. Подружка выходит замуж, и вам предстоит организовать выкуп невесты, вы" +
            "\nизучите литературу и подберете конкурсы  — 0 " +
            "\nпостараетесь придумать конкурсы сами, чтобы они были оригинальными — 1",
        "6. Изучая меню в ресторане, вы, скорее всего, остановитесь на" +
            "\nзнакомом блюде — 0" +
            "\nблюде с самым экстравагантным, названием — 1",
        "7. Если в процессе создания стенгазеты потребуется нарисовать какое-то животное, вы" +
            "\nпостараетесь найти фотографию или другое изображение и срисуете — 0" +
            "\nнарисуете животное сами, даже если не очень хорошо имеете — 1",
        "8. Для новогоднего маскарада в детском саду необходимо найти малышу костюм. Вы " +
            "\nсошьете его сами — 1 " +
            "\nкупите в магазине — 0",
        "9. Любили ли вы в детстве читать сказки?" +
            "\nВам интереснее было смотреть мультики — 0" +
            "\nДа, вы любили читать не меньше, чем смотреть телевизор — 1",
        "10. Ваши фотографии в альбоме —" +
            "\nчаше традиционные — 0 " +
            "\nживые позы в необычных ракурсах — 1"
    ];

    let res = 0;
    for (let i = 0; i < questions.length; i++) {
        let pr = +prompt(questions[i]);
        res += pr;
    }

    if (res > 7) {
        alert("7 баллов и более. Вы очень творческий человек. Вы умеете видеть необычные решения, которые незаметны для окружающих. ");
    } else if (res < 4) {
        alert("Менее 4 баллов. Вы придерживаетесь традиционных взглядов на решение проблемных ситуаций.");
    } else {
        alert("От 4 до 6 баллов. Вы достаточно креативны по натуре, но не всегда считаете нужным пользоваться этими способностями. ");
    }
}


function task3() {
    let arr = [3, 'a', 'a', 'a', 2, 3, 'a', 3, 'a', 2, 4, 9, 3];
    let count = 1;
    let maxCount = 0;
    let num;
    for (let i = 0; i < arr.length; i++) {
        for (let j = 0; j < arr.length; j++) {
            if (arr[i] === num) {
                break;
            }
            if (arr[i] === arr[j]) {
                count++;
            }
            if (count > maxCount) {
                maxCount = count;
                num = arr[i];
            }
        }
        count = 1;
    }
    console.log(` ${num} ( ${maxCount} times )`);
}


function task4() {
    console.log(`Изначальный массив:`);
    console.log([1, 2, 4, 0]);
    console.log(`Клон:`);
    console.log(arrClone([1, 2, 4, 0]));
    console.log(`Изначальный массив:`);
    console.log([1, 2, [4, 0]]);
    console.log(`Клон:`);
    console.log(arrClone([1, 2, [4, 0]]));
}

function arrClone(arr) {
    let clone;
    if (Array.isArray(arr)) {
        clone = arr.slice(0);
        for (let i = 0; i < clone.length; i++) {
            clone[i] = arrClone(clone[i]);
        }
        return clone;
    } else {
        return arr;
    }
}


function task5() {
    console.log(first([7, 9, 0, -2]));
    console.log(first([],3));
    console.log(first([7, 9, 0, -2],3));
    console.log(first([7, 9, 0, -2],6));
    console.log(first([7, 9, 0, -2],-3));
}

function first(arr) {
    let res = [];
    let pos = 1;
    if (arr.length >= pos) {
        for (let i = 0; i < pos; i++) {
            res[i] = arr[i];
        }
    } else {
        for (let i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
    }
    return res;
}

function task6() {
    let num = 254681;
    let str = num.toString();
    let arr = str.split('');
    let res = '';
    for (let i = 0; i < arr.length; i++) {
        if (arr[i] % 2 === 0) {
            res += arr[i];
            res += '-';
        } else {
            res += arr[i];
        }
    }
    console.log(`${res}`);
}


function task7() {
    let arr = [1,2,3,4,5];
    let res = 0;
    for (let i = 0; i < arr.length; i++) {
        if (typeof arr[i] == "number") {
            res += Math.pow(arr[i],2);
        }
    }
    console.log(`${res}`);
}


function task8() {
    let arr = [1,2,3,4,5,6,7,8,9,10];
    console.log(`Изначальный массив: ${arr}`);
    let len = arr.length;
    while (len) {
        let i = Math.floor(Math.random() * len--);
        let tmp = arr[len];
        arr[len] = arr[i];
        arr[i] = tmp;
    }
    console.log(`Перемешанный массив: ${arr}`);
}


function task9() {
    console.log(unique([7, 9, 0, -2]));
    console.log(unique([7, 7, 0, -2]));
    console.log(unique([7, 9, 9, -2]));
    console.log(unique([1, 1, 1, 1]));
}

function unique(arr) {
    let tmp = [];
    for (let i = 0; i < arr.length; i++) {
        let count = 1;
        for (let j = i + 1; j < arr.length; j++) {
            if (arr[i] === arr[j]) {
                count++;
                tmp[j] = 0;
            }
        }
        if (tmp[i] !== 0) {
            tmp[i] = count;
        }
    }
    let res = [];
    let j = 0;
    for (let i = 0; i < arr.length; i++) {
        if (tmp[i] === 1) {
            res[j] = arr[i];
            j++;
        }
    }
    return res;
}