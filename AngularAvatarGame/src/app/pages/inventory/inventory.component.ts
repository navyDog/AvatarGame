import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
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
  item: Items;
  //
  private _userAvatarsList: Avatars[] = [];
  private _userAvatarsListId: number[] = [];
  private _userAvatarsListsItems: Avatars[] = [];

  imgPath: string = "assets/items/";
  imgSufix: string = ".png";

  constructor(
    private ar: ActivatedRoute,
    private userService: UserService,
    private router: Router
  ) {
    this.item = new Items();
  }

  ngOnInit() {
    // ALLS ITEMS NO CRAFTED OF CURRENT USER
    this.userService.userItemsNoCraftedList().subscribe((result) => {
      this.userItemsNoCraftList = result.items;
      /*console.log(this.userItemsNoCraftList);*/
    });

    // ALLS ITEMS OF ALL AVATARS OF CURRENT USER
    this.userService.userAvatarList().subscribe((result) => {
      this.userAvatarsList = result.avatar;
      /*console.log(this.userAvatarsList);*/
      this.userAvatarsList.forEach((value) => {
        this.userService.localId = value.id;

        this.userService.userAvatarList2().subscribe((result) => {
          this._userAvatarsListsItems?.push(result);
          result.compose.sort((a: Items, b: Items) => {
            return (
              "" +
              a.membre?.localeCompare("" + b.membre, "en", {
                sensitivity: "base",
              })
            );
          });
          /*console.log(this.userAvatarsListsItems);*/
        });
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
  public get userAvatarsListsItems(): Avatars[] {
    return this._userAvatarsListsItems;
  }
  public set userAvatarsListsItems(value: Avatars[]) {
    this._userAvatarsListsItems = value;
  }

  public get userAvatarsListId(): number[] {
    return this._userAvatarsListId;
  }
  public set userAvatarsListId(value: number[]) {
    this._userAvatarsListId = value;
  }

  public inventoryId(id: number) {
    /*console.log(id);*/
    this.ar.params.subscribe((params) => {
      this.userService.getById(id).subscribe((result) => {
        /*console.log(result);*/
        this.item = result;
      });
    });
  }

  public inventorySend() {
    this.userService.updateItem(this.item).subscribe((result) => {
      /*console.log(this.item.prix);
      console.log(result.prix);*/
      this.router.navigateByUrl("/inventory");
    });
  }
}
