export class DemoClass {

  public constructor(private _nom?: string, private _presenter?: string) {}

  public get nom(): string | undefined { //getter
    return this._nom;
  }

  public set nom(value: string | undefined) { //seter
    this._nom = value;
  }

  public get presenter(): string | undefined { //getter
    return this._presenter;
  }

  public set presenter(value: string | undefined) { //seter
    this._presenter= value;
  }

  public sayHello(): string | undefined{
    return this._presenter+' '+this._nom;
  }

}
