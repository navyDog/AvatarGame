import { Component, OnInit } from "@angular/core";
import { Router } from "@angular/router";
import { ConverterService } from "src/app/config/services/converter.service";
import { UserService } from "src/app/config/services/user.service";
import { Avatars } from "src/app/entities/avatars";
import { Items } from "src/app/entities/items";
import { Param } from "src/app/entities/param";
import { Users } from "src/app/entities/users";

@Component({
  selector: "app-craft",
  templateUrl: "./craft.component.html",
  styleUrls: ["./craft.component.css"],
})
export class CraftComponent implements OnInit {
  // LIST OF ALL ITEMS NO CRAFTED OF CURRENT USER
  private _userItemsNoCraftList: Items[] = [];

  // CRAFT NEW AVATAR INFORMATIONS
  private _newAvatarItems: Items[] = [];
  private _newAvatarItemsImage: string[] = [];
  private _newAvatarName: string = "";
  param: Param;
  private _userBalance: any;

  constructor(
    private userService: UserService,
    private router: Router,
    private convertor: ConverterService
    ) {
    this.param = new Param();
  }

  imgPath: string = "assets/items/";
  imgSufix: string = ".png";
  newCraftAvatarNameList: string[] = [
    "Automne-Hiver de JP Gautier",
    "Victoria's secret full suit",
  ];

  ngOnInit() {
    this.craftNewAvatarNameInputRandomValue();
    // ALLS ITEMS NO CRAFTED OF CURRENT USER
    this.userService.userItemsNoCraftedList().subscribe((result) => {
      this.userItemsNoCraftList = result.items;
    });
    // USER BALANCE
    this.userService.userBalance().subscribe((result) => {
      this._userBalance = result.solde;
    });
  }

  // ALLS ITEMS NO CRAFTED OF CURRENT USER
  public get userItemsNoCraftList(): Items[] {
    return this._userItemsNoCraftList;
  }
  public set userItemsNoCraftList(value: Items[]) {
    this._userItemsNoCraftList = value;
  }

  // CRAFT NEW AVATAR INFORMATIONS
  public get newAvatarItems(): Items[] {
    return this._newAvatarItems;
  }
  public set newAvatarItems(value: Items[]) {
    this._newAvatarItems = value;
  }

  public get newAvatarName(): string {
    return this._newAvatarName;
  }
  public set newAvatarName(value: string) {
    this._newAvatarName = value;
  }

  public get newAvatarItemsImage(): string[] {
    return this._newAvatarItemsImage;
  }
  public set newAvatarItemsImage(value: string[]) {
    this._newAvatarItemsImage = value;
  }
  public get userBalance() {
    return this._userBalance;
  }


  public craftNewAvatarNameInputRandomValue() {
    this.newAvatarName =
      this.newCraftAvatarNameList[
        Math.floor(Math.random() * this.newCraftAvatarNameList.length)
      ];
  }
  public craftNewAvatarNameInput() {
    console.log(this.newAvatarName);
  }

  public craftAddSelectedImg(av: Items, i: number) {
    this.newAvatarItems[i] = av;
    this.newAvatarItemsImage[i] = this.imgPath + av.image! + this.imgSufix;
  }

  public craftNewAvatar() {
    
    let newAvatar: Avatars = new Avatars();
    newAvatar.nom=this.newAvatarName;
    this.param.avatar=newAvatar;
    this.param.h=this.newAvatarItems[0];
    this.param.b=this.newAvatarItems[2];
    this.param.lh=this.newAvatarItems[3];
    this.param.rh=this.newAvatarItems[1];
    this.param.ll=this.newAvatarItems[5];
    this.param.rl=this.newAvatarItems[4];
    this.param.users=new Users();
    this.param.users.solde=this.userBalance;
    this.param.users.id=JSON.parse(sessionStorage.getItem("user")!).users.id;
    console.log(this.param);
    console.log(this.convertor.paramToJson(this.param))
    this.userService.createAvatar(this.param).subscribe((result) => {
  
      console.log(result);
      this.router.navigateByUrl('/inventory');
    });

  }
}
