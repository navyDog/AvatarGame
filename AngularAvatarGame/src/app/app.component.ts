import { Component } from '@angular/core';
import { Client } from './formation/class/client';
import { DemoClass } from './formation/class/demo-class';
import { Fournisseur } from './formation/class/fournisseur';
import { Personne } from './formation/class/personne';
import { Produit } from './formation/class/produit';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
})
export class AppComponent {
<<<<<<< HEAD
  title = 'AngularAvatarGame';

  produits:Array<Produit> = new Array();

  couleur = ''; nom1=''; nom2:number |undefined;



  click(value : string, value2 : number | undefined) {
    this.produits.push(new Produit(value,value2));
    this.nom1='';
    this.nom2=undefined;


  }

=======
  title = 'AvatarGame';
>>>>>>> e2b43961bb96e1f4928780112a49b95f335738c7
}
