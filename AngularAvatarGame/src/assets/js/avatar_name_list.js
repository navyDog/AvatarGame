const dbAvatarNameList = [
  "Automne-Hiver de JP Gautier",
  "Victoria's secret full suit",
];

/*let dbAvatarNameProp = "";*/

function randomAvatarNameProp() {
  /*dbAvatarNameProp = dbAvatarNameList[Math.random() * dbAvatarNameList.length];
  console.log(dbAvatarNameProp);*/
  document.querySelector("#craftAvatarNameInput").value =
    dbAvatarNameList[Math.random() * dbAvatarNameList.length];
}
