import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Observable } from "rxjs";
import { Items } from "src/app/entities/items";
import { UserService } from "../services/user.service";

@Component({
  selector: "app-navigation-top",
  templateUrl: "./navigation-top.component.html",
  styleUrls: ["./navigation-top.component.css"],
})
export class NavigationTopComponent implements OnInit {
  private _userBalance: any;
  private _userItemsNoCraftLength: Items[] = []; // LIST OF ALL ITEMS NO CRAFTED OF CURRENT USER

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
    // ALLS ITEMS NO CRAFTED OF CURRENT USER
    this.userService.userItemsNoCraftedList().subscribe((result) => {
      this._userItemsNoCraftLength = result.items.length;
    });
  }

  public logout() {
    /*this.userService.localId = 0;
    this.userService._sessionUserId = 0;
    this.userService._sessionUserHeader = "";*/
    sessionStorage.clear();
    console.log(sessionStorage);
    this.router.navigateByUrl("/auth");
  }

  public get userLogin() {
    return this.userService.userLogin();
  }

  public get userBalance() {
    return this._userBalance;
  }

  public get userItemsNoCraftLength(): Items[] {
    return this._userItemsNoCraftLength;
  }
}
