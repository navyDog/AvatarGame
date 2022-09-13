import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Observable } from "rxjs";
import { UserService } from "../services/user.service";

@Component({
  selector: "app-navigation-top",
  templateUrl: "./navigation-top.component.html",
  styleUrls: ["./navigation-top.component.css"],
})
export class NavigationTopComponent implements OnInit {
  private _userBalance: any;
  private _userItemsLength: number = 0;

  constructor(
    private router: Router,
    private httpClient: HttpClient,
    private userService: UserService
  ) {}

  ngOnInit() {
    // USER BALANCE
    this.userService.userBalance().subscribe((result) => {
      this._userBalance = result.solde;
    });
    // ITEMS LENGHT
    this.userService.userItemsList().subscribe((result) => {
      this._userItemsLength = result.items.length;
    });
    this.userItemsLength;
  }

  public logout() {
    sessionStorage.clear();
    this.router.navigateByUrl("/auth");
  }

  public get userLogin() {
    return this.userService.userLogin();
  }

  public get userBalance() {
    return this._userBalance;
  }

  public get userItemsLength() {
    return this._userItemsLength;
  }
}
