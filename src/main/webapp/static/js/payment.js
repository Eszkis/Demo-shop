var owner = $('#owner'),
    cardNumber = $('#cardNumber'),
    CVV = $("#cvv"),
    confirmCreditCardButton = $('#confirm-creditcard-purchase'),
    creditCardForm = $(".creditCardForm"),
    paypalForm = $(".paypalForm"),
    paypalButton = $(".paypal-button"),
    confirmPayPalButton = $("#confirm-paypal-purchase"),
    creditcardButton = $(".creditcard-button"),
    url = "/order";


confirmPayPalButton.click(function (e) {
    e.preventDefault();
    window.location = url;
})

paypalButton.click(function (e) {
    e.preventDefault();
    paypalForm.toggle()
})

creditcardButton.click(function (e) {
    e.preventDefault();
    creditCardForm.toggle()
})


confirmCreditCardButton.click(function (e) {
    e.preventDefault();

    var isCardValid = cardNumber.val().length == 12;
    var isCvvValid = CVV.val().length == 3;

    if (owner.val().length < 5) {
        alert("Wrong owner name");
    } else if (!isCardValid) {
        alert("Wrong card number");
    } else if (!isCvvValid) {
        alert("Wrong CVV");
    } else {
        // Everything is correct. Add your form submission code here.
        window.location = url;
    }
});