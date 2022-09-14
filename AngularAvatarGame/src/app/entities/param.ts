import { Avatars } from "./avatars";
import { Items } from "./items";
import { Users } from "./users";

export class Param {
    constructor(
        private _users?: Users,
        private _avatar?: Avatars,
        private _h?: Items,
        private _b?: Items,
        private _lh?: Items,
        private _rh?: Items,
        private _ll?: Items,
        private _rl?: Items,

    ) {}

    public get users(): Users | undefined {
        return this._users;
        }
    public set users(value: Users | undefined) {
        this._users = value;
    }

    public get avatar(): Avatars | undefined {
        return this._avatar;
        }
    public set avatar(value: Avatars | undefined) {
        this._avatar = value;
    }

    public get h(): Items | undefined {
        return this._h;
        }
    public set h(value: Items | undefined) {
        this._h = value;
    }

    public get b(): Items | undefined {
        return this._b;
        }
    public set b(value: Items | undefined) {
        this._b = value;
    }

    public get lh(): Items | undefined {
        return this._lh;
        }
    public set lh(value: Items | undefined) {
        this._lh = value;
    }

    public get rh(): Items | undefined {
        return this._rh;
        }
    public set rh(value: Items | undefined) {
        this._rh = value;
    }

    public get ll(): Items | undefined {
        return this._ll;
        }
    public set ll(value: Items | undefined) {
        this._ll = value;
    }

    public get rl(): Items | undefined {
        return this._rl;
        }
    public set rl(value: Items | undefined) {
        this._rl = value;
    }
}
