<<<<<<< HEAD
import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
=======
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { Observable } from "rxjs";
import { UserService } from "../services/user.service";
>>>>>>> 6c6c19ac95fe4779912c248eb122077170941f7d

@Component({
  selector: "app-navigation-top",
  templateUrl: "./navigation-top.component.html",
  styleUrls: ["./navigation-top.component.css"],
})
export class NavigationTopComponent implements OnInit {
<<<<<<< HEAD
  constructor(private router: Router) {}

  ngOnInit(): void {}

  public logout() {
    sessionStorage.clear();
    this.router.navigateByUrl("/auth");
  }

  public get getUserName(): string {
    return JSON.parse(sessionStorage.getItem("user")!).login;
=======
  private _userBalance: any;

  constructor(
    private router: Router,
    private httpClient: HttpClient /*private profileService = UpdateProfileService*/,
    private userService: UserService
  ) {}

  ngOnInit() {
    this._userBalance = this.userBalance();
  }

  public logout() {
    sessionStorage.clear();
    this.router.navigateByUrl("/auth");
  }

  public userLogin(): string {
    return this.userService.userLogin();
  }

  public userBalance() {
    console.log(this.userService.userBalance().subscribe());
    return this.userService.userBalance().subscribe((result) => {
      /*this.userBalance;*/
      console.log(result);
    });
>>>>>>> 6c6c19ac95fe4779912c248eb122077170941f7d
  }
}
