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
  private _userAvatarsItemsList: Avatars[] = []; //
  private _userAvatarsMain: Avatars = new Avatars();
  imgPath: string = "assets/items/";

  constructor(private userService: UserService) {}

  ngOnInit() {
    // ALLS ITEMS NO CRAFTED OF CURRENT USER
    this.userService.userItemsNoCraftedList().subscribe((result) => {
      this._userItemsNoCraftList = result.items;
    });
    // ALLS ITEMS OF ALL AVATARS OF CURRENT USER
    this.userService.userAvatarList().subscribe((result) => {
      this._userAvatarsMain = result.avatar[0];
      this._userAvatarsItemsList = result;
      this._userAvatarsItemsList.shift();
      console.log(result.avatar[0]);
    });
  }

  public get userItemsNoCraftList(): Items[] {
    return this._userItemsNoCraftList;
  }

  public get userAvatarsItemsList(): Avatars[] {
    return this._userAvatarsItemsList;
  }
  public set userAvatarsItemsList(value: Avatars[]) {
    this._userAvatarsItemsList = value;
  }

  public get userAvatarsMain(): Avatars {
    return this._userAvatarsMain;
  }
}
