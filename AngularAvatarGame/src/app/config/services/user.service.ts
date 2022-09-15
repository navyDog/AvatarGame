import { HttpClient, HttpHeaders } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { Observable } from "rxjs";
import { Items } from "src/app/entities/items";
import { JeuUn } from "src/app/entities/jeu-un";
import { Param } from "src/app/entities/param";
import { Users } from "src/app/entities/users";
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
  }

  public usersInfo(): Observable<any> {
    return this.httpClient.get(
      "http://localhost:8080/avatar/api/users/" + this.localId + "/information",
      {
        headers: this.sessionUserHeader,
      }
    );
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
    return this.httpClient.get(
      "http://localhost:8080/avatar/api/avatar/" +
        this.sessionUserId +
        "/items",
      {
        headers: this.sessionUserHeader,
      }
    );
  }

  public getById(id: number): Observable<Items> {
    //getItemByID
    return this.httpClient.get<Items>(
      "http://localhost:8080/avatar/api/item/" + id,
      {
        headers: this.sessionUserHeader,
      }
    );
  }

  public updateItem(item: Items): Observable<Items> {
    return this.httpClient.put<Items>(
      "http://localhost:8080/avatar/api/item/" + item.id,
      this.converter.itemToJson(item),
      {
        headers: this.sessionUserHeader,
      }
    );
  }

  public updateUsers(user: Users): Observable<Users> {
    return this.httpClient.put<Users>(
      "http://localhost:8080/avatar/api/users/" + user.id,
      this.converter.usersToJson(user),
      {
        headers: this.sessionUserHeader,
      }
    );
  }

  public createAvatar(param: Param): Observable<Param> {
    return this.httpClient.post<Param>(
      "http://localhost:8080/avatar/api/avatar/" +
        this.sessionUserId +
        "/" +
        param.h!.id +
        "/" +
        param.b!.id +
        "/" +
        param.lh!.id +
        "/" +
        param.rh!.id +
        "/" +
        param.ll!.id +
        "/" +
        param.rl!.id,
      this.converter.paramToJson(param),
      {
        headers: this.sessionUserHeader,
      }
    );
  }

  public game1(): Observable<JeuUn> {
    return this.httpClient.get<JeuUn>(
      "http://localhost:8080/avatar/api/users/" + this.sessionUserId + "/game1",
      {
        headers: this.sessionUserHeader,
      }
    );
  }

  public randomItem() : Observable<any>{
    return this.httpClient.post<any>(
      "http://localhost:8080/avatar/api/item/" + this.sessionUserId,
      {
        headers: this.sessionUserHeader,
      }
    );
  }

  public randomSet() : Observable<any>{
    return this.httpClient.post<any>(
      "http://localhost:8080/avatar/api/item/" + this.sessionUserId +
      "/set",
      {
        headers: this.sessionUserHeader,
      }
    );
  }

  public get localId(): number | undefined {
    return this._localId;
  }
  public set localId(value: number | undefined) {
    this._localId = value;
  }

  public getAllItemsSaleable(): Observable<any> {
    return this.httpClient.get<any>(
      "http://localhost:8080/avatar/api/item/saleable",
      {
        headers: this.sessionUserHeader,
      }
    );
  }
}
