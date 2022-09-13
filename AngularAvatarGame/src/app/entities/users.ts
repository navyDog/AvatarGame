import { Avatars } from "./avatars";
import { Items } from "./items";

export class Users {
    constructor(
        private _avatar: Avatars[],
        private _id?: number,
        private _solde?: number,
        private _items?: Items[]
        
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

public get avatar(): Avatars[] {
    return this._avatar;
    }
public set avatar(value: Avatars[]) {
    this._avatar = value;
}

}
