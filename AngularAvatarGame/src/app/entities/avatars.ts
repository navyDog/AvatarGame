import { Items } from "./items";

export class Avatars {
  constructor(
    private _avatarItems?: Items[],
    private _avatarId?: number,
    private _avatarName?: string,
    private _avatarPrice?: number
  ) {}
  /* -------------------------------------------- GETTERS -------------------------------------------- */
  public get id(): number | undefined {
    return this._avatarId;
  }

  public get nom(): string | undefined {
    return this._avatarName;
  }

  public get price(): number | undefined {
    return this._avatarPrice;
  }

  public get compose(): Items[] | undefined {
    return this._avatarItems;
  }

  /* -------------------------------------------- SETTERS -------------------------------------------- */
  public set id(value: number | undefined) {
    this._avatarId = value;
  }

  public set nom(value: string | undefined) {
    this._avatarName = value;
  }

  public set price(value: number | undefined) {
    this._avatarPrice = value;
  }

  public set compose(value: Items[] | undefined) {
    this._avatarItems = value;
  }
}
