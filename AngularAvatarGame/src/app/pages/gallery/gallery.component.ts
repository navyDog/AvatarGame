import { ThisReceiver } from "@angular/compiler";
import { Component, OnInit } from "@angular/core";
import { UserService } from "src/app/config/services/user.service";
import { Avatars } from "src/app/entities/avatars";
import { Items } from "src/app/entities/items";
import { Users } from "src/app/entities/users";
import { __values } from "tslib";

@Component({
  selector: "app-gallery",
  templateUrl: "./gallery.component.html",
  styleUrls: ["./gallery.component.css"],
})
export class GalleryComponent implements OnInit {
  private _listUsers?: Users[] = [];
  private _listAvatars?: Avatars[] = [];

  public temp: Avatars = new Avatars();

  imgPath: string = "assets/items/";
  imgSufix: string = ".png";
  constructor(private userService: UserService) {}

  ngOnInit(): void {
    // ALLS ITEMS NO CRAFTED OF CURRENT USER

    this.userService.usersAvatar().subscribe((result) => {
      this.listUsers = result; //list of Users
<<<<<<< HEAD
  
      console.log(this.listUsers); 
      this.listUsers?.forEach(value => (
       //first Avatar of each Users
        
        this.userService.localId = value.avatar[0].id, 
        this.userService.userAvatarList2().subscribe((result) =>
          
          this.listAvatars?.push(result),
          
         //items list of each avatar
        )
      ));
      this.listAvatars!.forEach(avatar => {
        avatar.compose?.forEach(item => {
          item.nom?.replace("body","hgfd")
        })
      })
      console.log(this.listAvatars)
      //list of all firstavatar of each
    });
=======
>>>>>>> origin/main

      /*console.log(this.listUsers);*/
      this.listUsers?.forEach((value) => {
        //first Avatar of each Users

        this.userService.localId = value.avatar[0].id;
        this.userService.userAvatarList2().subscribe((result) => {
          this.listAvatars?.push(result);
          this.temp = result.compose.sort((a: Items, b: Items) => {
            return (
              "" +
              a.membre?.localeCompare("" + b.membre, "en", {
                sensitivity: "base",
              })
            );
          });
          //list of all firstavatar of each
        });
      });
    });
  }

  public get listUsers(): Users[] | undefined {
    return this._listUsers;
  }

  public set listUsers(value: Users[] | undefined) {
    this._listUsers = value;
  }

  public get listAvatars(): Avatars[] | undefined {
    return this._listAvatars;
  }

  public set listAvatars(value: Avatars[] | undefined) {
    this._listAvatars = value;
  }
}
