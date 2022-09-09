import { Personne } from "./personne";

export class Fournisseur extends Personne {

  public constructor(_prenom?: string,
                      _nom?: string) {
    super(_prenom,_nom);
  }
}
