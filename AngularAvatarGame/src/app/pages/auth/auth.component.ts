import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/config/services/auth.service';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.css'],
})
export class AuthComponent implements OnInit {
  login = '';
  password = '';
  authError = false;
  _navDisplay = false;

  constructor(private authService: AuthService, private router: Router) {}

  public get navDisplay(): boolean {
    return this._navDisplay;
  }

  ngOnInit(): void {}

  submit(form: any) {
    /*this.authService.authentication(this.login, this.password).subscribe({
      next: (result) => {
        sessionStorage.setItem('token', btoa(this.login + ':' + this.password));
        this.authError = false;
        sessionStorage.setItem('user', JSON.stringify(result));
        this.router.navigateByUrl('/home');
      },
      error: (err) => {
        this.authError = true;
      },
    });*/
  }
}
