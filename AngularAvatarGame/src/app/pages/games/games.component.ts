import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Route, Router } from "@angular/router";
import { UserService } from "src/app/config/services/user.service";
import { JeuUn } from "src/app/entities/jeu-un";

@Component({
  selector: "app-games",
  templateUrl: "./games.component.html",
  styleUrls: ["./games.component.css"],
})
export class GamesComponent implements OnInit {
  game1: JeuUn;


  constructor(
    private ar: ActivatedRoute,
    private userService: UserService,
    private router: Router
  ) {
    this.game1=new JeuUn();
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
}
