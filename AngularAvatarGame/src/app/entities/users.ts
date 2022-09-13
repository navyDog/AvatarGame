import { Avatars } from "./avatars";
import { Items } from "./items";

export class Users {
    constructor(
        private _id?: number,
        private _solde?: number,
        private _items?: Items[],
        private _avatar?: Avatars[]
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

}
