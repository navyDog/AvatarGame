import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-inventory",
  templateUrl: "./inventory.component.html",
  styleUrls: ["./inventory.component.css"],
})
export class InventoryComponent implements OnInit {
  private _navDisplay: boolean = true;

  constructor() {}

  public get navDisplay(): boolean {
    return this._navDisplay;
  }

  ngOnInit(): void {}
}
