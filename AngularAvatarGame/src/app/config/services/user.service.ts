import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Items } from "src/app/entities/items";
import { ConverterService } from "./converter.service";

@Injectable({
  providedIn: "root",
})
export class UserService {
  constructor(
    private httpClient: HttpClient,
    private converter: ConverterService
  ) {}
  private _localId?: number | undefined;
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

  public userBalance(): Observable<any> {
    return this.httpClient.get(
      "http://localhost:8080/avatar/api/users/" + this.sessionUserId,
      {
        headers: this.sessionUserHeader,
      }
    );
  }

  public userItemsList(): Observable<any> {
    return this.httpClient.get(
      "http://localhost:8080/avatar/api/users/" + this.sessionUserId + "/items",
      {
        headers: this.sessionUserHeader,
      }
    );
  }

  public userItemsNoCraftedList(): Observable<any> {
    return this.httpClient.get(
      "http://localhost:8080/avatar/api/users/" +
        this.sessionUserId +
        "/items/crafted",
      {
        headers: this.sessionUserHeader,
      }
    );
  }

  public userAvatarList(): Observable<any> {
    return this.httpClient.get(
      "http://localhost:8080/avatar/api/users/" +
        this.sessionUserId +
        "/avatars",
      {
        headers: this.sessionUserHeader,
      }
    );
  }

  public usersItemsNoCraftedList(): Observable<any> {
    return this.httpClient.get("http://localhost:8080/avatar/api/users/items", {
      headers: this.sessionUserHeader,
    });
  }

  public users(): Observable<any> {
    return this.httpClient.get("http://localhost:8080/avatar/api/users", {
      headers: this.sessionUserHeader,
    });
    return this.httpClient.get("http://localhost:8080/avatar/api/users", {
      headers: this.sessionUserHeader,
    });
  }

  public usersAvatar(): Observable<any> {
    return this.httpClient.get(
      "http://localhost:8080/avatar/api/users/avatars",
      {
        headers: this.sessionUserHeader,
      }
    );
  }

  public userAvatarList2(): Observable<any> {
    return this.httpClient.get(
      "http://localhost:8080/avatar/api/avatar/" + this.localId + "/items",
      {
        headers: this.sessionUserHeader,
      }
    );
  }
  public userAvatarList3(): Observable<any> {
    // test
    return this.httpClient.get(
      "http://localhost:8080/avatar/api/avatar/" + this.localId + "/items",
      {
        headers: this.sessionUserHeader,
      }
    );
  }

  public getById(id: number): Observable<Items> { //getItemByID
    return this.httpClient.get<Items>(
      'http://localhost:8080/avatar/api/item/' + id,
      {
        headers: this.sessionUserHeader,
      }
    );
  }

  public updateItem(item: Items): Observable<Items> {
    return this.httpClient.put<Items>(
  
      "http://localhost:8080/avatar/api/item/" + item.id, this.converter.itemToJson(item),
      {
        headers: this.sessionUserHeader,
      }
    ); console.log(item.prix)
  }

  public get localId(): number | undefined {
    return this._localId;
  }
  public set localId(value: number | undefined) {
    this._localId = value;
  }
}
