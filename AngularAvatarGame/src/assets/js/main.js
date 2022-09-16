/* -------------------------------------------- --------- -------------------------------------------- */
/* -------------------------------------------- INVENTORY -------------------------------------------- */
/* -------------------------------------------- --------- -------------------------------------------- */
function invtAccordion(p) {
  let a1 = "marContentTop";
  let a2 = "marContentBot";

  let x1 = document.getElementById("invBotItemsHead");
  let x2 = document.getElementById("invBotItemsHandRight");
  let x3 = document.getElementById("invBotItemsBody");
  let x4 = document.getElementById("invBotItemsHandLeft");
  let x5 = document.getElementById("invBotItemsFeetRight");
  let x6 = document.getElementById("invBotItemsFeetLeft");
  let y1 = document.getElementById("invBotItemsHeadBtn");
  let y2 = document.getElementById("invBotItemsHandRightBtn");
  let y3 = document.getElementById("invBotItemsBodyBtn");
  let y4 = document.getElementById("invBotItemsHandLeftBtn");
  let y5 = document.getElementById("invBotItemsFeetRightBtn");
  let y6 = document.getElementById("invBotItemsFeetLeftBtn");
  let z1 = document.getElementsByClassName("invItemBotBtn");
  let z2 = document.getElementsByClassName("invBotItemsBot");

  for (let i = 0; i < z1.length; i++) {
    z1[i].classList.remove("active");
    z2[i].style.display = "none";
  }
  if (p == "head") {
    x1.style.display = "flex";
    y1.classList.add("active");
  } else if (p == "handRight") {
    x2.style.display = "flex";
    y2.classList.add("active");
  } else if (p == "body") {
    x3.style.display = "flex";
    y3.classList.add("active");
  } else if (p == "handLeft") {
    x4.style.display = "flex";
    y4.classList.add("active");
  } else if (p == "feetRight") {
    x5.style.display = "flex";
    y5.classList.add("active");
  } else if (p == "feetLeft") {
    x6.style.display = "flex";
    y6.classList.add("active");
  } else if (p == "avatars") {
    x7.style.display = "flex";
    y7.classList.add("active");
  }
}
// ITEMS -- DISPLAY / HIDE THE ITEMS CONTENT
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

// INVENTORY -- DISPLAY SOLD CONFIRMATION BOX
function inventorySold(p) {
  let x1 = document.querySelector("#invTop");
  let x2 = document.querySelector("#invBottom");
  let y = document.querySelector("#invSoldItem");
  let z = document.querySelector("#PriceItemInput");

  if (p == "on") {
    x1.style.filter = "blur(4px)";
    x2.style.filter = "blur(4px)";
    y.style.display = "flex";
    //z.value = "";
  } else if (p == "off") {
    x1.style.filter = "blur(0px)";
    x2.style.filter = "blur(0px)";
    y.style.display = "none";
    //z.value = "";
  }
}

/* -------------------------------------------- ----- -------------------------------------------- */
/* -------------------------------------------- CRAFT -------------------------------------------- */
/* -------------------------------------------- ----- -------------------------------------------- */

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

  img1.src = "assets/items/empty_head.png";
  img2.src = "assets/items/empty_hand_right.png";
  img3.src = "assets/items/empty_body.png";
  img4.src = "assets/items/empty_hand_left.png";
  img5.src = "assets/items/empty_feet_right.png";
  img6.src = "assets/items/empty_feet_left.png";
}

// CRAFT -- DISPLAY / HIDE THE CONTENT ITEMS SELECT
function craftItemSelect(p) {
  let x;
  if (p == "head") {
    x = document.getElementById("crafItemsHead");
  } else if (p == "hand_right") {
    x = document.getElementById("crafItemsHandRight");
  } else if (p == "body") {
    x = document.getElementById("crafItemsBody");
  } else if (p == "hand_left") {
    x = document.getElementById("crafItemsHandLeft");
  } else if (p == "feet_right") {
    x = document.getElementById("crafItemsFeetRight");
  } else if (p == "feet_left") {
    x = document.getElementById("crafItemsFeetLeft");
  }
  let y = document.getElementsByClassName("crafItems");
  let z = document.getElementById("craftItemSelect");

  for (let i = 0; i < y.length; i++) {
    y[i].style.display = "none";
  }

  if (typeof p != "undefined") {
    z.style.display = "flex";
    x.style.display = "flex";
  } else {
    z.style.display = "none";
  }
}

/* -------------------------------------------- ------ -------------------------------------------- */
/* -------------------------------------------- MARKET -------------------------------------------- */
/* -------------------------------------------- ------ -------------------------------------------- */
function marketAccordion(p, q) {
  let x1, x2, x3, x4, x5, x6, x7, y1, y2, y3, y4, y5, y6, y7, z1, z2;
  if (p == "top") {
    x1 = document.getElementById("marContentTopHead");
    x2 = document.getElementById("marContentTopBody");
    x3 = document.getElementById("marContentTopHandRight");
    x4 = document.getElementById("marContentTopHandLeft");
    x5 = document.getElementById("marContentTopFeetRight");
    x6 = document.getElementById("marContentTopFeetLeft");
    x7 = document.getElementById("marContentTopAvatar");
    y1 = document.getElementById("marContentTopHeadBtn");
    y2 = document.getElementById("marContentTopBodyBtn");
    y3 = document.getElementById("marContentTopHandRightBtn");
    y4 = document.getElementById("marContentTopHandLeftBtn");
    y5 = document.getElementById("marContentTopFeetRightBtn");
    y6 = document.getElementById("marContentTopFeetLeftBtn");
    y7 = document.getElementById("marContentTopAvatarBtn");
    z1 = document.getElementsByClassName("marContentTopBtn");
    z2 = document.getElementsByClassName("marContentTop");
  } else if (p == "bot") {
    x1 = document.getElementById("marContentBotHead");
    x2 = document.getElementById("marContentBotBody");
    x3 = document.getElementById("marContentBotHandRight");
    x4 = document.getElementById("marContentBotHandLeft");
    x5 = document.getElementById("marContentBotFeetRight");
    x6 = document.getElementById("marContentBotFeetLeft");
    x7 = document.getElementById("marContentBotAvatar");
    y1 = document.getElementById("marContentBotHeadBtn");
    y2 = document.getElementById("marContentBotBodyBtn");
    y3 = document.getElementById("marContentBotHandRightBtn");
    y4 = document.getElementById("marContentBotHandLeftBtn");
    y5 = document.getElementById("marContentBotFeetRightBtn");
    y6 = document.getElementById("marContentBotFeetLeftBtn");
    y7 = document.getElementById("marContentBotAvatarBtn");
    z1 = document.getElementsByClassName("marContentBotBtn");
    z2 = document.getElementsByClassName("marContentBot");
  }
  for (let i = 0; i < z1.length; i++) {
    z1[i].classList.remove("active");
    z2[i].style.display = "none";
  }
  if (q == "head") {
    x1.style.display = "flex";
    y1.classList.add("active");
  } else if (q == "body") {
    x2.style.display = "flex";
    y2.classList.add("active");
  } else if (q == "handRight") {
    x3.style.display = "flex";
    y3.classList.add("active");
  } else if (q == "handLeft") {
    x4.style.display = "flex";
    y4.classList.add("active");
  } else if (q == "feetRight") {
    x5.style.display = "flex";
    y5.classList.add("active");
  } else if (q == "feetLeft") {
    x6.style.display = "flex";
    y6.classList.add("active");
  } else if (q == "avatars") {
    x7.style.display = "flex";
    y7.classList.add("active");
  }
}

// ADD IMAGE TO THE CRAFTED AVATAR
function marketBuyItem(p) {
  /*let x = document.querySelector("#marMarketItems");*/
  let y = document.querySelector("#marUsersItems");
  let z = document.querySelector("#marBuyPopup");

  if (p == "on") {
    /*x.style.filter = "blur(4px)";*/
    y.style.filter = "blur(4px)";
    z.style.display = "flex";
  } else if (p == "off") {
    /*x.style.filter = "blur(0px)";*/
    y.style.filter = "blur(0px)";
    z.style.display = "none";
  }
}
