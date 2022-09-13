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
  private _userItemsNoCraftList: Items[] = []; // LIST OF ALL ITEMS NO CRAFTED OF CURRENT USER
  private _userAvatarsItemsIDList: Avatars[] = []; //

  private _userAvatarsMain: number | undefined;
  private _userAvatarMainItems: Items[] = [];
  imgPath: string = "assets/items/";

  constructor(private userService: UserService) {}

  ngOnInit() {
    // ALLS ITEMS NO CRAFTED OF CURRENT USER
    this.userService.userItemsNoCraftedList().subscribe((result) => {
      this._userItemsNoCraftList = result.items;
    });
    // ALLS ITEMS OF ALL AVATARS OF CURRENT USER
    this.userService.userAvatarList().subscribe((result) => {
      this.userAvatarsMain = result.avatar[0].id;
      /* console.log(result.avatar[0].id);
      console.log(this.userAvatarsMain);*/
      this._userAvatarsItemsIDList = result;

      // LIST OF ITEMS OF MAIN AVATAR OF CURRENT USER
      this.userService.localId = this.userAvatarsMain;
      /*console.log(this.userService.localId);
      console.log(this.userAvatarsMain);*/
      this.userService.userAvatarList2().subscribe((result) => {
        this.userAvatarMainItems = result.compose;
        console.log(result.compose);
      });
    });
  }

  public get userItemsNoCraftList(): Items[] {
    return this._userItemsNoCraftList;
  }

  public get userAvatarsItemsIdList(): Avatars[] {
    return this._userAvatarsItemsIDList;
  }
  public set userAvatarsItemsIdList(value: Avatars[]) {
    this._userAvatarsItemsIDList = value;
  }

  public get userAvatarsMain(): number | undefined {
    return this._userAvatarsMain;
  }
  public set userAvatarsMain(value: number | undefined) {
    this._userAvatarsMain = value;
  }

  public get userAvatarMainItems(): Items[] {
    return this._userAvatarMainItems;
  }
  public set userAvatarMainItems(value: Items[]) {
    this._userAvatarMainItems = value;
  }
}
