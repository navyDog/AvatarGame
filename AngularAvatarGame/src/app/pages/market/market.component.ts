import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { UserService } from "src/app/config/services/user.service";
import { Items } from "src/app/entities/items";
import { Users } from "src/app/entities/users";
import { Utilisateur } from "src/app/entities/utilisateur";

@Component({
  selector: "app-market",
  templateUrl: "./market.component.html",
  styleUrls: ["./market.component.css"],
})
export class MarketComponent implements OnInit {
  private _itemToBuy: Items = new Items();
  private _ownerItemToBuy: Users = new Users();
  private _marketItemsList: Items[] = [];
  private _marketItemsUsersList: Users[] = [];

  imgPath: string = "assets/items/";
  imgSufix: string = ".png";

  constructor(
    
    router: Router,
    private userService: UserService) {}

  ngOnInit() {
    // GET ALL ITEMS ON SALE OF ALL PLAYERS
    this.userService.getAllItemsSaleable().subscribe((result) => {
      this.marketItemsList = result;
      /* console.log(this.marketItemsList);*/
      this.marketItemsList.forEach((value) => {
        this.userService.localId = value.owner!.id;
        this.userService.usersInfo().subscribe((result) => {
          this.marketItemsUsersList.push(result);
          /*console.log(this.marketItemsUsersList);*/
        });
      });
    });

    // ADD MONEY TO S
  }

  /* -------------------------------------------- GETTERS & SETTERS -------------------------------------------- */
  public get itemToBuy(): Items {
    return this._itemToBuy;
  }
  public set itemToBuy(value: Items) {
    this._itemToBuy = value;
  }
  public get marketItemsList(): Items[] {
    return this._marketItemsList;
  }
  public set marketItemsList(value: Items[]) {
    this._marketItemsList = value;
  }
  public get marketItemsUsersList(): Users[] {
    return this._marketItemsUsersList;
  }
  public set marketItemsUsersList(value: Users[]) {
    this._marketItemsUsersList = value;
  }
  public get ownerItemToBuy(): Users {
    return this._ownerItemToBuy;
  }
  public set ownerItemToBuy(value: Users) {
    this._ownerItemToBuy = value;
  }

  /* -------------------------------------------- METHODS -------------------------------------------- */
  public eraseItemToBuy() {
    this.itemToBuy = new Items();
    this.ownerItemToBuy = new Users();
    /*console.log(this.itemToBuy);*/
  }

  public addItemToBuy(item: Items, user: Users) {
  
    this.itemToBuy = item;
    this.ownerItemToBuy = user;


    this.itemToBuy.prix=0;
    this.itemToBuy.owner!.id=this.ownerItemToBuy.id;
    this.userService.updateItem(this.itemToBuy).subscribe((result) => {
      console.log(result);
    });
    this.ownerItemToBuy.solde=-100;
    this.userService.updateUsers(this.ownerItemToBuy).subscribe((result) => {
      console.log(result);
    });

    let me = {
      id: JSON.parse(sessionStorage.getItem("user")!).users.id,
      solde: 400
    }

    this.userService.updateUsers(me).subscribe((result) => {
      console.log(result);
    });


    /*console.log(this.itemToBuy);*/
  }

  public searchByUserId(id: number): Users {
    let temp = this.marketItemsUsersList.filter((x) => (x.id = id));
    return temp[0];
  }
}
