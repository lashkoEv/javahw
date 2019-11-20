"use strict";

function task1() {
    let start = prompt("Введите начало диапазона:");
    let end = prompt("Введите конец диапазона:");
    if(isNumber(start) && isNumber(end)) {
        start = parseInt(start);
        end = parseInt(end);
        if (start > end) {
            let tmp = start;
            start = end;
            end = tmp;
        }
        let res = 0;
        for (let i = start; i <= end; i++) {
            res += i;
        }
        console.log(`Task 1: ${res}`);
    }else{
        console.log(`${start} или ${end} не является числом.`);
    }
}

function task2() {
    let first = prompt("Введите первое число:");
    let second = prompt("Введите второе число:");
    if(isNumber(first) && isNumber(second)) {
        first = parseInt(first);
        second = parseInt(second);
        first = Math.abs(first);
        second = Math.abs(second);
        while (second !== 0) {
            let tmp = second;
            second = first % second;
            first = tmp;
        }
        console.log(`Task 2: ${first}`);
    }else{
        console.log(`${first} или ${second} не является числом.`);
    }
}

function task3() {
    let number = prompt("Введите число:");
    if(isNumber(number)) {
        number = parseInt(number);
        let arr = [];
        let start = 0;
        let end = number;
        if(start >= end){
            let tmp = start;
            start = end;
            end = tmp;
        }
        for (let i = start; i <= end; i++) {
            if (number % i === 0) {
                arr.push(i);
            }
        }
        console.log(`Task 3: ${arr}`);
    }else{
        console.log(`${number} не является числом.`);
    }
}

function task4() {
    let number = prompt("Введите число:");
    if(isNumber(number)) {
        let res = 0;
        if (number < 0) {
            number = -number;
        }
        do {
            number = number / 10;
            res++;
        } while (number > 1);
        console.log(`Task 4: ${res}`);
    }else{
        console.log(`${number} не является числом.`);
    }
}

function task5() {
    let positive = 0;
    let negative = 0;
    let zero = 0;
    let even = 0;
    let odd = 0;
    let count = 1;
    do {
        let number = prompt(`Введите ${(count)} число:`);
        if (isNumber(number)) {
            if (number > 0) {
                positive++;
            } else if (number < 0) {
                negative++;
            } else {
                zero++;
            }
            if (number % 2 === 0) {
                even++;
            } else {
                odd++;
            }
            count++;
        }else{
            console.log(`${number} не является числом.`);
        }
    } while (count <= 10);
    console.log(`Task 5: положительных - ${positive}, отрицательных - ${negative}, нулей - ${zero}`);
    console.log(`чётных - ${even}, нечётных - ${odd}`);
}

function task6() {
    do {
        let first = prompt("Первое число:");
        if(!isNumber(first)){
            console.log(`${first} не является числом.`);
            continue;
        }
        let second = prompt("Второе число:");
        if(!isNumber(second)){
            console.log(`${second} не является числом.`);
            continue;
        }
        first = parseInt(first);
        second = parseInt(second);
        let operation = prompt("Операция:");
        let res;
        if (operation === '+') {
            res = first + second;
        }else if (operation === '-') {
            res = first - second;
        }else if (operation === '*') {
            res = first * second;
        }else if (operation === '/') {
            res = first / second;
        }else {
            console.log(`${operation} не является стандартной операцией.`);
            continue;
        }
        console.log(`${first} ${operation} ${second} = ${res}`);
        if (!confirm("Продолжить?")) {
            break;
        }
    }while (true);
}

function task7() {
    let number = prompt("Введите число:");
    let shift = prompt("Введите сдвиг:");
    if(isNumber(number) && isNumber(shift)) {
        for (let i = 0; i < shift; i++) {
            number += number.substr(0, 1);
            number = number.substr(1);
        }
        console.log(`Task 2: ${number}`);
    }else {
        console.log(`${number} или ${shift} не является числом.`);
    }
}

function task8() {
    let arr = ["Понедельник", "Вторник", "Среда", "Четверг", "Пятница", "Суббота", "Воскресенье"];
    let i = 0;
    do {
        if (!confirm(arr[i] + ". Хотите увидеть следующий день?")) {
            break;
        }
        i++;
        if (i === 7) {
            i = 0;
        }
    } while (true);
}

function task9() {
    let row = 9;
    let col = 10;
    document.write("<table style='border: 1px solid black;'><tr>");
    for (let i = 1; i <= col; i++) {
        document.write("<td>" + i + "</td>");
    }
    document.write("</tr>");
    for (let i = 2; i <= row; i++) {
        document.write("<tr><td>" + i + "</td>");
        for (let j = 2; j <= col; j++) {
            document.write("<td style='background: lightgray'>" + (i * j) + "</td>");
        }
        document.write("</tr>");
    }
    document.write("</table>");
    document.write("<a href='index.html'>Назад к списку</a>");
}

function task10() {
    prompt(`Введите число от 0 до 100:`);
    let max = 100;
    let min = 0;
    let number;
    let operation;
    let count = 0;
    do {
        number = Math.floor(min + ((max - min) / 2));
        operation = prompt(`Ваше число больше(>), меньше(<) или равно(==) числу ${number}?`);
        if (operation === ">") {
            min = +min + +(max - min) / 2;
        }
        if (operation === "<") {
            max = +max - (max - min) / 2;
        }
        count++;
    } while (operation !== "==");
    alert(`Количество попыток, за которое угадано Ваше число: ${count}`);
}


function isNumber(tmp) {
    return /^-?[\d.]+(?:e-?\d+)?$/.test(tmp);
}