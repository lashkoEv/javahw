function isUpperCaseFirstLetter(str) {
    return /^[A-ZА-Я]/.test(str);
}

function isValidEmail(str) {
    return /\w+@\w+\.\w+/.test(str);
}

function trimString(str) {
    str = str.replace(/\s\s+/g, ' ');
    return str.replace(/^\s+|\s+$/g, '');
}

function thousandsSeparators(num) {
    return num.toLocaleString('ru').replace(/,/, '.').replace(/\s/, ',');
}

function formatCurrency(num) {
    return String(num);
}
