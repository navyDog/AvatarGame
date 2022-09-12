import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-navigation",
  templateUrl: "./navigation.component.html",
  styleUrls: ["./navigation.component.css"],
})
export class NavigationComponent implements OnInit {
  constructor() {}

  ngOnInit(): void {}

  public logged(): boolean {
    if (sessionStorage.getItem("token")) {
      return true;
    } else {
      return false;
    }
  }
}
