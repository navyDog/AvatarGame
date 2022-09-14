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
  private _userAvatarsList: Avatars[] = [];

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
      this.userAvatarsList = result.avatar;

      this.userAvatarsList.forEach(
        (value) => (
          (this.userService.localId = value.id),
          console.log(this.userService.localId)
        ),
        this.userService
          .userAvatarList3()
          .subscribe((result) => console.log(result.compose))
      );

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

  public get userAvatarMainItems(): Items[] {
    return this._userAvatarMainItems;
  }
  public set userAvatarMainItems(value: Items[]) {
    this._userAvatarMainItems = value;
  }

  //
  public get userAvatarsList(): Avatars[] {
    return this._userAvatarsList;
  }
  public set userAvatarsList(value: Avatars[]) {
    this._userAvatarsList = value;
  }
}
