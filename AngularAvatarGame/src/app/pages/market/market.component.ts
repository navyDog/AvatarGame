import { Component, OnInit } from "@angular/core";
import { Items } from "src/app/entities/items";

@Component({
  selector: "app-market",
  templateUrl: "./market.component.html",
  styleUrls: ["./market.component.css"],
})
export class MarketComponent implements OnInit {
  private _itemToBuy: Items = new Items();

  constructor() {}

  ngOnInit() {
    // GET ALL ITEMS ON SALE OF ALL PLAYERS
  }

  public get itemToBuy(): Items {
    return this._itemToBuy;
  }
  public set itemToBuy(value: Items) {
    this._itemToBuy = value;
  }

  public eraseItemToBuy() {
    this.itemToBuy = new Items();
  }

  public addItemToBuy(item: Items) {
    this.itemToBuy = item;
  }
}
