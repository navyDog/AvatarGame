import { Component, OnInit } from "@angular/core";
import { UserService } from "src/app/config/services/user.service";
import { Items } from "src/app/entities/items";

@Component({
  selector: "app-inventory",
  templateUrl: "./inventory.component.html",
  styleUrls: ["./inventory.component.css"],
})
export class InventoryComponent implements OnInit {
  private _userItemsList: Items[] = [];
  imgPath: string = "assets/items/";

  constructor(private userService: UserService) {}

  ngOnInit() {
    this.userService.userItemsList().subscribe((result) => {
      this._userItemsList = result.items;
      console.log(result.items);
    });
    /*this.userItemsList;*/
  }

  public get userItemsList(): Items[] {
    return this._userItemsList;
  }
}
