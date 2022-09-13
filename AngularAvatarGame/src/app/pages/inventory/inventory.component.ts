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
  private _suerAvatarsItemsList: Avatars[] = [];
  imgPath: string = "assets/items/";

  constructor(private userService: UserService) {}

  ngOnInit() {
    // ALLS ITEMS NO CRAFTED OF CURRENT USER
    this.userService.userItemsNoCraftedList().subscribe((result) => {
      this._userItemsNoCraftList = result.items;
    });
    // ALLS ITEMS OF ALL AVATARS OF CURRENT USER
    this.userService.userAvatarList().subscribe((result) => {
      this._suerAvatarsItemsList = result;
      console.log(result);
    });
  }

  public get userItemsNoCraftList(): Items[] {
    return this._userItemsNoCraftList;
  }

  public get suerAvatarsItemsList(): Avatars[] {
    return this._suerAvatarsItemsList;
  }
}
