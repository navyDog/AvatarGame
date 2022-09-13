import { Injectable } from "@angular/core";
import { Items } from "src/app/entities/items";

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
}
