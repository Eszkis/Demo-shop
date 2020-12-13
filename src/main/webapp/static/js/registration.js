function init() {
    eventListenerToRegister();
}

function eventListenerToRegister() {
    let registerButton = document.querySelector("#register")
    registerButton.addEventListener("click", () => {
        if (passwordsMatch()) {
            document.querySelector("#registration-form").submit();
        } else {
            warnAboutPassword();
        }
    })
}


function warnAboutPassword() {
    let warningField = document.querySelector(".warning");
    warningField.innerHTML = "<h2>Passwords do not match!</h2>";
}


function passwordsMatch() {
    let password = document.getElementById("password");
    let confirmPassword = document.getElementById("confirm");
    return password.value === confirmPassword.value;
}



init()
