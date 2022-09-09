export abstract class Personne {

  public constructor(private _prenom?: string,private _nom?: string) {}

  public set prenom(value: string | undefined) {
    this._prenom=value;
  }

  public get prenom() : string | undefined {
    return this._prenom;
  }

  public set nom(value: string | undefined) {
    this._nom=value;
  }

  public get nom() : string | undefined {
    return this._nom;
  }
}
