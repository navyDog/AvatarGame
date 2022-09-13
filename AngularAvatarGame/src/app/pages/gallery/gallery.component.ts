import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/config/services/user.service';
import { Users } from 'src/app/entities/users';

@Component({
  selector: 'app-gallery',
  templateUrl: './gallery.component.html',
  styleUrls: ['./gallery.component.css']
})
export class GalleryComponent implements OnInit {
  private _usersItemsNoCraftList: any[] = [];

 
  constructor(private userService: UserService) {}

  ngOnInit(): void {
     // ALLS ITEMS NO CRAFTED OF CURRENT USER
     this.userService.usersItemsNoCraftedList().subscribe((result) => {
      this._usersItemsNoCraftList = result.users;
      console.log(result);
    });
  }

  public get usersItemsNoCraftList(): any[] {
    return this._usersItemsNoCraftList;
  }

}
