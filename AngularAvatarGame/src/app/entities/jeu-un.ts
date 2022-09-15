export class JeuUn {

    constructor(
        private _coin?: String
    ) {}

    public get coin(): String | undefined {
        return this._coin;
    }

    public set coin(value: String | undefined) {
        this._coin = value;
    }
}
