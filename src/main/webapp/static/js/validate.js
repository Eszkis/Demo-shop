init()

function init() {
  eventlistenerToSubmit()
}

function validate() {
  let phoneNumber = document.getElementById("phone").value
  let zipCode = document.getElementById("zipcode").value

  if (isNaN(phoneNumber) || isNaN(zipCode)) {
    alert("Wrong input")
  } else {
    document.querySelector(".personal").submit()
  }
}

function eventlistenerToSubmit() {
  let button = document.querySelector(".submit")

  button.addEventListener("click", () => {
    validate()
  })
}