import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class UserService {
  constructor(private httpClient: HttpClient) {}
  private sessionUserId = JSON.parse(sessionStorage.getItem("user")!).users.id;
  private sessionUserHeader = new HttpHeaders({
    "Content-Type": "application/json",
    Authorization: "Basic " + sessionStorage.getItem("token"),
  });

  public userId(): string {
    return JSON.parse(sessionStorage.getItem("user")!).id;
  }

  public userLogin(): string {
    return JSON.parse(sessionStorage.getItem("user")!).login;
  }

  public userBalance() {
    return this.httpClient.get(
      "http://localhost:8080/avatar/api/users/" + this.sessionUserId,
      {
        headers: this.sessionUserHeader,
      }
    );
  }
}
