export class Utilisateur {
  constructor(private _login: string) {}

  public get login(): string {
    return this._login;
  }

  public set login(value: string) {
    this._login = value;
  }
}
