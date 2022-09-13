export class Items {
  constructor(
    private _itemCraftStat?: boolean,
    private _itemId?: number,
    private _itemPicture?: string,
    private _itemLimb?: string,
    private _itemName?: string,
    private _itemprice?: number,
    private _itemRarity?: string,
    private _itemAvatarId?: number,
    private _itemUserId?: number
  ) {}

  /* -------------------------------------------- GETTERS -------------------------------------------- */
  public get id(): number | undefined {
    return this._itemId;
  }
  public get crafted(): boolean | undefined {
    return this._itemCraftStat;
  }
  public get image(): string | undefined {
    return this._itemPicture;
  }
  public get membre(): string | undefined {
    return this._itemLimb;
  }
  public get nom(): string | undefined {
    return this._itemName;
  }
  public get prix(): number | undefined {
    return this._itemprice;
  }
  public get rarity(): string | undefined {
    return this._itemRarity;
  }
  public get avatar(): number | undefined {
    return this._itemAvatarId;
  }
  /*public get itemUserId(): number | undefined {
    return this._itemUserId;
  }*/

  /* -------------------------------------------- SETTERS -------------------------------------------- */
  public set id(value: number | undefined) {
    this._itemId = value;
  }
  public set crafted(value: boolean | undefined) {
    this._itemCraftStat = value;
  }
  public set image(value: string | undefined) {
    this._itemPicture = value;
  }
  public set membre(value: string | undefined) {
    this._itemLimb = value;
  }
  public set nom(value: string | undefined) {
    this._itemName = value;
  }
  public set prix(value: number | undefined) {
    this._itemprice = value;
  }
  public set rarity(value: string | undefined) {
    this._itemRarity = value;
  }
  public set avatar(value: number | undefined) {
    this._itemAvatarId = value;
  }
  /*public set itemUserId(value: number | undefined) {
    this._itemUserId = value;
  }*/
}
