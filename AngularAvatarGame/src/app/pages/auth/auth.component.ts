import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { AuthService } from "src/app/config/services/auth.service";
import { UserService } from "src/app/config/services/user.service";

@Component({
  selector: "app-auth",
  templateUrl: "./auth.component.html",
  styleUrls: ["./auth.component.css"],
})
export class AuthComponent implements OnInit {
  login = "";
  password = "";
  authError = false;

  constructor(
    private authService: AuthService,
    private router: Router,
//    private userService: UserService,
    private httpClient: HttpClient
  ) {}

  ngOnInit(): void {}

  submit(form: any) {
    this.authService.auth(this.login, this.password).subscribe({
      next: (result) => {
        sessionStorage.setItem("token", btoa(this.login + ":" + this.password));
        this.authError = false;
        sessionStorage.setItem("user", JSON.stringify(result));
        console.log(JSON.parse(sessionStorage.getItem("user")!).users.id);

//        this.userService._sessionUserId = JSON.parse(
//          sessionStorage.getItem("user")!
//        ).users.id;
//        this.userService._sessionUserHeader = new HttpHeaders({
//          "Content-Type": "application/json",
//          Authorization: "Basic " + sessionStorage.getItem("token"),
//        });

        this.router.navigateByUrl("/inventory");
      },
      error: (err) => {
        this.authError = true;
      },
    });
  }
}
