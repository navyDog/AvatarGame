import { Component, OnInit } from "@angular/core";
import { UserService } from "src/app/config/services/user.service";
import { Items } from "src/app/entities/items";

@Component({
  selector: "app-inventory",
  templateUrl: "./inventory.component.html",
  styleUrls: ["./inventory.component.css"],
})
export class InventoryComponent implements OnInit {
  private _userItemsNoCraftList: Items[] = []; // LIST OF ALL ITEMS NO CRAFTED OF CURRENT USER
  imgPath: string = "assets/items/";

  constructor(private userService: UserService) {}

  ngOnInit() {
    // ALLS ITEMS NO CRAFTED OF CURRENT USER
    this.userService.userItemsNoCraftedList().subscribe((result) => {
      this._userItemsNoCraftList = result.items;
    });
  }

  public get userItemsNoCraftList(): Items[] {
    return this._userItemsNoCraftList;
  }
}
