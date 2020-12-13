init()

function init() {
  addEventlistenerOnButtons()
  removeEventlistenerOnButtons()
  showTotalPrice(getTotalPrice())
}

function addEventlistenerOnButtons() {
  let button = document.querySelectorAll(".add")

  for (let btn of button) {
    btn.addEventListener("click", () => {
      let url = "/cart?action=add&id=" + btn.id
      fetchData(url)
    })
  }
}

function fetchData(url) {
  fetch(url)
  .then((response) => response.json())
  .then((data) => {
    return data
  })
}

function removeEventlistenerOnButtons() {
  let button = document.querySelectorAll(".remove")

  for (let btn of button) {
    btn.addEventListener("click", () => {
      let url = "/cart?action=remove&id=" + btn.id
      console.log(url)
      fetchData(url)
    })
  }
}

function getTotalPrice() {
  let cards = document.querySelectorAll(".card")
  let totalPrice = 0

  for (let card of cards) {
    if (card.dataset.price !== undefined) {
      totalPrice += parseFloat(card.dataset.price)
    }
  }
  return Math.round(totalPrice * 100) / 100
}

function showTotalPrice(price) {
  let priceDiv = document.querySelector(".price")

  console.log(priceDiv)

  if (priceDiv !== undefined) {
    priceDiv.innerHTML += `<div class="lead price-tag">${price} USD</div>`
  }
}
