window.onload = function() {
    var choiceAmount = document.getElementsByClassName("choiceAmount");

    for( var i = 0; i < choiceAmount.length; i++ ) {
        choiceAmount[i].onclick = function () {
            var amount = this.value;
            var detail = this.dataset.detail;
            document.getElementById("choiceAmount").value = amount;
            document.getElementById("choiceDetail").innerHTML = detail;
        }
    }
};