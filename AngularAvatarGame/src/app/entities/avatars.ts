export class Avatars {
  constructor(
    private _itemCraftStat?: boolean,
    private _itemId?: number,
    private _itemPicture?: string,
    private _itemLimb?: string,
    private _itemName?: string,
    private _itemprice?: number,
    private _itemRarity?: number,
    private _itemAvatarId?: number,
    private _itemUserId?: number
  ) {}
}
/* -------------------------------------------- GETTERS -------------------------------------------- */
public get id(): number | undefined {
    return this._itemId;
  }

/* -------------------------------------------- SETTERS -------------------------------------------- */
