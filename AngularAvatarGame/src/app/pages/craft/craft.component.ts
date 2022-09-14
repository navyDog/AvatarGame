import { Component, OnInit } from "@angular/core";
import { UserService } from "src/app/config/services/user.service";
import { Items } from "src/app/entities/items";

@Component({
  selector: "app-craft",
  templateUrl: "./craft.component.html",
  styleUrls: ["./craft.component.css"],
})
export class CraftComponent implements OnInit {
  // LIST OF ALL ITEMS NO CRAFTED OF CURRENT USER
  private _userItemsNoCraftList: Items[] = [];

  constructor(private userService: UserService) {}

  imgPath: string = "assets/items/";
  imgSufix: string = ".png";

  ngOnInit() {
    // ALLS ITEMS NO CRAFTED OF CURRENT USER
    this.userService.userItemsNoCraftedList().subscribe((result) => {
      this.userItemsNoCraftList = result.items;
      console.log(this.userItemsNoCraftList);
    });
  }

  // ALLS ITEMS NO CRAFTED OF CURRENT USER
  public get userItemsNoCraftList(): Items[] {
    return this._userItemsNoCraftList;
  }
  public set userItemsNoCraftList(value: Items[]) {
    this._userItemsNoCraftList = value;
  }
}
