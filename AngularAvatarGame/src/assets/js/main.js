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
