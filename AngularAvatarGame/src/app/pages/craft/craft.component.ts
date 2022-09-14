import { Component, OnInit } from "@angular/core";
import { UserService } from "src/app/config/services/user.service";
import { Avatars } from "src/app/entities/avatars";
import { Items } from "src/app/entities/items";

@Component({
  selector: "app-craft",
  templateUrl: "./craft.component.html",
  styleUrls: ["./craft.component.css"],
})
export class CraftComponent implements OnInit {
  // LIST OF ALL ITEMS NO CRAFTED OF CURRENT USER
  private _userItemsNoCraftList: Items[] = [];

  // CRAFT NEW AVATAR INFORMATIONS
  private _newAvatarItems: Items[] = [];
  private _newAvatarItemsImage: string[] = [];
  private _newAvatarName: string = "";

  constructor(private userService: UserService) {}

  imgPath: string = "assets/items/";
  imgSufix: string = ".png";
  newCraftAvatarNameList: string[] = [
    "Automne-Hiver de JP Gautier",
    "Victoria's secret full suit",
  ];

  ngOnInit() {
    this.craftNewAvatarNameInputRandomValue();
    // ALLS ITEMS NO CRAFTED OF CURRENT USER
    this.userService.userItemsNoCraftedList().subscribe((result) => {
      this.userItemsNoCraftList = result.items;
    });
  }

  // ALLS ITEMS NO CRAFTED OF CURRENT USER
  public get userItemsNoCraftList(): Items[] {
    return this._userItemsNoCraftList;
  }
  public set userItemsNoCraftList(value: Items[]) {
    this._userItemsNoCraftList = value;
  }

  // CRAFT NEW AVATAR INFORMATIONS
  public get newAvatarItems(): Items[] {
    return this._newAvatarItems;
  }
  public set newAvatarItems(value: Items[]) {
    this._newAvatarItems = value;
  }

  public get newAvatarName(): string {
    return this._newAvatarName;
  }
  public set newAvatarName(value: string) {
    this._newAvatarName = value;
  }

  public get newAvatarItemsImage(): string[] {
    return this._newAvatarItemsImage;
  }
  public set newAvatarItemsImage(value: string[]) {
    this._newAvatarItemsImage = value;
  }

  public craftNewAvatarNameInputRandomValue() {
    this.newAvatarName =
      this.newCraftAvatarNameList[
        Math.floor(Math.random() * this.newCraftAvatarNameList.length)
      ];
  }
  public craftNewAvatarNameInput() {
    console.log(this.newAvatarName);
  }

  public craftAddSelectedImg(av: Items, i: number) {
    this.newAvatarItems[i] = av;
    this.newAvatarItemsImage[i] = this.imgPath + av.image! + this.imgSufix;
  }

  public craftNewAvatar() {
    /*let newAvatar: Avatars = new Avatars(
      this._newAvatarItems,
      this.newAvatarName,
      JSON.parse(sessionStorage.getItem("user")!).users.id
    );*/
  }
}
