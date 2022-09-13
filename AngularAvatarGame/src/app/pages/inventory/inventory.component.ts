import { Component, OnInit } from "@angular/core";
import { UserService } from "src/app/config/services/user.service";
import { Avatars } from "src/app/entities/avatars";
import { Items } from "src/app/entities/items";

@Component({
  selector: "app-inventory",
  templateUrl: "./inventory.component.html",
  styleUrls: ["./inventory.component.css"],
})
export class InventoryComponent implements OnInit {
  // LIST OF ALL ITEMS NO CRAFTED OF CURRENT USER
  private _userItemsNoCraftList: Items[] = [];

  // CURRENT USER - MAIN AVATAR
  private _userAvatarsIDMain: number | undefined;
  private _userAvatarsMainName: string | undefined;
  private _userAvatarMainItems: Items[] = [];

  //
  /*private _userAvatarsItemsIDList: Avatars[] = [];*/

  imgPath: string = "assets/items/";
  imgSufix: string = ".png";

  constructor(private userService: UserService) {}

  ngOnInit() {
    // ALLS ITEMS NO CRAFTED OF CURRENT USER
    this.userService.userItemsNoCraftedList().subscribe((result) => {
      this.userItemsNoCraftList = result.items;
    });

    // ALLS ITEMS OF ALL AVATARS OF CURRENT USER
    this.userService.userAvatarList().subscribe((result) => {
      this.userAvatarsIDMain = result.avatar[0].id;
      this.userAvatarsMainName = result.avatar[0].nom;
      /*this._userAvatarsItemsIDList = result;*/

      // LIST OF ITEMS OF MAIN AVATAR OF CURRENT USER
      this.userService.localId = this.userAvatarsIDMain;
      this.userService.userAvatarList2().subscribe((result) => {
        this.userAvatarMainItems = result.compose;
      });
    });
  }

  // ALLS ITEMS NO CRAFTED OF CURRENT USER
  public get userItemsNoCraftList(): Items[] {
    return this._userItemsNoCraftList;
  }
  public set userItemsNoCraftList(value: Items[]) {
    this._userItemsNoCraftList = value;
  }

  // CURRENT USER - MAIN AVATAR
  public get userAvatarsMainName(): string | undefined {
    return this._userAvatarsMainName;
  }
  public set userAvatarsMainName(value: string | undefined) {
    this._userAvatarsMainName = value;
  }

  public get userAvatarsIDMain(): number | undefined {
    return this._userAvatarsIDMain;
  }
  public set userAvatarsIDMain(value: number | undefined) {
    this._userAvatarsIDMain = value;
  }

  //
  /*public get userAvatarsItemsIdList(): Avatars[] {
    return this._userAvatarsItemsIDList;
  }
  public set userAvatarsItemsIdList(value: Avatars[]) {
    this._userAvatarsItemsIDList = value;
  }*/

  public get userAvatarMainItems(): Items[] {
    return this._userAvatarMainItems;
  }
  public set userAvatarMainItems(value: Items[]) {
    this._userAvatarMainItems = value;
  }
}
