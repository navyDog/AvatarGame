import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Router } from "@angular/router";
import { AnyCatcher } from "rxjs/internal/AnyCatcher";
import { UserService } from "src/app/config/services/user.service";
import { JeuUn } from "src/app/entities/jeu-un";

@Component({
  selector: "app-games",
  templateUrl: "./games.component.html",
  styleUrls: ["./games.component.css"],
})
export class GamesComponent implements OnInit {
  game1: JeuUn;
  random : Object;


  constructor(
    private ar: ActivatedRoute,
    private userService: UserService,
    private router: Router
  ) {
    this.game1=new JeuUn();
    this.random= new Object();
  }

  ngOnInit(): void {
    /*var coin = require('coin-toss');
    console.log(coin.toss());*/
  }

  public jouer() {
    this.ar.paramMap.subscribe((params) => {
      this.userService.game1().subscribe((result) => {
        this.game1=result;
        console.log(result)
        this.router.navigateByUrl('/games');
      })
    })
  }

  public random_item(){
    this.userService.randomItem().subscribe((result) => {
      this.random = result;
      console.log(result)
      this.router.navigateByUrl('/games');
    })
  }

  public random_set(){
    this.userService.randomSet().subscribe((result) => {
      this.random = result;
      console.log(result)
      this.router.navigateByUrl('/games');
    })
  }
}
