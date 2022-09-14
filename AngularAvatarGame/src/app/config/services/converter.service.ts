import { Injectable } from "@angular/core";
import { Avatars } from "src/app/entities/avatars";
import { Items } from "src/app/entities/items";
import { Users } from "src/app/entities/users";

@Injectable({
  providedIn: "root",
})
export class ConverterService {
  constructor() {}

  public JsonToItem(item: Items): any {
    let obj = {
      /*itemPicture: image;*/
    };
  }

  public avatarToJson(avatar: Avatars): any {
    let obj = {
      id: avatar.id,
      nom: avatar.nom,
      price: avatar.price,
    }
    return obj;
  }

  public usersToJson(users: Users): any {
    let obj = {
      id: users.id,
      solde: users.solde
    }
    return obj;
  }

  public itemToJson(item: Items): any {
    let obj = {
      id: item.id,
      membre: item.membre,
      rarity: item.rarity,
      prix: item.prix!,
      crafted: item.crafted,
      nom: item.nom,
      image: item.image
    };
    if (item.avatar) {
      Object.assign(obj, {
        avatar: this.avatarToJson(item.avatar)
      });
    }

    if (item.owner) {
      Object.assign(obj, {
        owner: this.usersToJson(item.owner)
    });

  }
  return obj;
  }
}
