import { ThisReceiver } from '@angular/compiler';
import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/config/services/user.service';
import { Users } from 'src/app/entities/users';
import { __values } from 'tslib';

@Component({
  selector: 'app-gallery',
  templateUrl: './gallery.component.html',
  styleUrls: ['./gallery.component.css']
})
export class GalleryComponent implements OnInit {
  private _listUsers?: Users[] = [];
  


  imgPath: string = "assets/items/"
 
  constructor(private userService: UserService) {}

  ngOnInit(): void {
     // ALLS ITEMS NO CRAFTED OF CURRENT USER
     this.userService.userItemsNoCraftedList().subscribe((result) => {
        console.log(result)
     })
     this.userService.users().subscribe((result) => {
      this.listUsers = result;
  
      console.log(this.listUsers);
      this.listUsers?.forEach(value => (
       
        this.userService.localId = value.avatar[0].id,
        this.userService.userAvatarList2().subscribe((result) =>
          console.log(result)
        )
       
      ));
    });

  }

  public get listUsers(): Users[] | undefined {
    return this._listUsers;
  }

  public set listUsers(value: Users[] | undefined) {
    this._listUsers = value;
  }

}
