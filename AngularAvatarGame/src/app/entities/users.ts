import { Avatars } from "./avatars";
import { Items } from "./items";
import { Utilisateur } from "./utilisateur";

export class Users {
  constructor(
    private _avatar?: Avatars[],
    private _id?: number,
    private _solde?: number,
    private _items?: Items[],
    private _utilisateurs?: Utilisateur
  ) {}

  public get id(): number | undefined {
    return this._id;
  }
  public set id(value: number | undefined) {
    this._id = value;
  }

  public get solde(): number | undefined {
    return this._solde;
  }
  public set solde(value: number | undefined) {
    this._solde = value;
  }

  public get items(): Items[] | undefined {
    return this._items;
  }
  public set items(value: Items[] | undefined) {
    this._items = value;
  }

  public get avatar(): Avatars[] | undefined {
    return this._avatar;
  }
  public set avatar(value: Avatars[] | undefined) {
    this._avatar = value;
  }

  public get utilisateur(): Utilisateur | undefined {
    return this._utilisateurs;
  }
  public set utilisateur(value: Utilisateur | undefined) {
    this._utilisateurs = value;
  }
}
