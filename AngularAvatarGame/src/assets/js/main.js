let otherPlayer = "";

// CRAFT -- DISPLAY CONFIRMATION BOX AND BLUR BACKGROUND
function craftOverlay(p) {
  let x1 = document.querySelector("#craftContent");
  let x2 = document.querySelector("#note");
  let y = document.querySelector("#craftConfirm");

  if (p == "on") {
    x1.style.filter = "blur(4px)";
    x2.style.filter = "blur(4px)";
    y.style.display = "flex";
  } else if (p == "off") {
    x1.style.filter = "blur(0px)";
    x2.style.filter = "blur(0px)";
    y.style.display = "none";
  }
}

// CRAFT -- CLEAR ALL POSITIONS OF THE CRAFTED AVATAR
function craftErase() {
  let img1 = document.querySelector("#craftAvatarHead");
  let img2 = document.querySelector("#craftAvatarHandRight");
  let img3 = document.querySelector("#craftAvatarBody");
  let img4 = document.querySelector("#craftAvatarHandLeft");
  let img5 = document.querySelector("#craftAvatarFeetRight");
  let img6 = document.querySelector("#craftAvatarFeetLeft");

  img1.src = "assets/items/empty.png";
  img2.src = "assets/items/empty.png";
  img3.src = "assets/items/empty.png";
  img4.src = "assets/items/empty.png";
  img5.src = "assets/items/empty.png";
  img6.src = "assets/items/empty.png";
}

//
function craftAccordion(p) {
  let x1 = document.getElementById("invBotItemsHead");
  let x2 = document.getElementById("invBotItemsHandRight");
  let x3 = document.getElementById("invBotItemsBody");
  let x4 = document.getElementById("invBotItemsHandLeft");
  let x5 = document.getElementById("invBotItemsFeetRight");
  let x6 = document.getElementById("invBotItemsFeetLeft");
  let y = document.getElementsByClassName("invBotItems");

  for (let i = 0; i < y.length; i++) {
    y[i].style.display = "none";
  }

  if (p == "head") {
    x1.style.display = "flex";
  } else if (p == "handRight") {
    x2.style.display = "flex";
  } else if (p == "body") {
    x3.style.display = "flex";
  } else if (p == "handLeft") {
    x4.style.display = "flex";
  } else if (p == "feetRight") {
    x5.style.display = "flex";
  } else if (p == "feetLeft") {
    x6.style.display = "flex";
  }
}
