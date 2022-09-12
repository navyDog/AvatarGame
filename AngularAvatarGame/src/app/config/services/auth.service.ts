import { Injectable } from "@angular/core";
import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
  providedIn: "root",
})
export class AuthService {
  constructor(private httpClient: HttpClient) {}

  public auth(login: string, password: string): Observable<any> {
    let header: HttpHeaders = new HttpHeaders({
      "Content-Type": "application/json",
      Authorization: "Basic " + btoa(login + ":" + password),
    });
    return this.httpClient.get("http://localhost:8080/avatar/api/auth/", {
      headers: header,
    });
  }
  public get authenticated(): boolean {
    return sessionStorage.getItem("token") ? true : false;
  }
}
