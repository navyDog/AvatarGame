export class Items {
  constructor(
    private _itemCraftStat?: boolean,
    private _itemId?: number,
    private _itemPicture?: string,
    private _itemLimb?: number,
    private _itemName?: string,
    private _itemprice?: number,
    private _itemRarity?: number,
    private _itemAvatarId?: number,
    private _itemUserId?: number
  ) {}

  /* -------------------------------------------- GETTERS -------------------------------------------- */
  public get id(): number | undefined {
    return this._itemId;
  }
  public get itemCraftStat(): boolean | undefined {
    return this._itemCraftStat;
  }
  public get image(): string | undefined {
    return this._itemPicture;
  }
  public get itemLimb(): number | undefined {
    return this._itemLimb;
  }
  public get nom(): string | undefined {
    return this._itemName;
  }
  public get itemprice(): number | undefined {
    return this._itemprice;
  }
  public get itemRarity(): number | undefined {
    return this._itemRarity;
  }
  public get itemAvatarId(): number | undefined {
    return this._itemAvatarId;
  }
  public get itemUserId(): number | undefined {
    return this._itemUserId;
  }

  /* -------------------------------------------- SETTERS -------------------------------------------- */
  public set itemId(value: number | undefined) {
    this._itemId = value;
  }
  public set itemCraftStat(value: boolean | undefined) {
    this._itemCraftStat = value;
  }
  public set itemPicture(value: string | undefined) {
    this._itemPicture = value;
  }
  public set itemLimb(value: number | undefined) {
    this._itemLimb = value;
  }
  public set itemName(value: string | undefined) {
    this._itemName = value;
  }
  public set itemprice(value: number | undefined) {
    this._itemprice = value;
  }
  public set itemRarity(value: number | undefined) {
    this._itemRarity = value;
  }
  public set itemAvatarId(value: number | undefined) {
    this._itemAvatarId = value;
  }
  public set itemUserId(value: number | undefined) {
    this._itemUserId = value;
  }
}
