function formatDate(inputStr) {
    var timestamp = parseInt(inputStr, 10);
    var date = new Date(timestamp);
    return date.getDate() + '/' + (date.getMonth() + 1) + '/' +  date.getFullYear();
}