import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, AsyncValidatorFn, AbstractControl, ValidationErrors, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { map, Observable } from 'rxjs';
import { RegisService } from 'src/app/config/services/regis.service';

@Component({
  selector: 'app-regis',
  templateUrl: './regis.component.html',
  styleUrls: ['./regis.component.css'],
})
export class RegisComponent implements OnInit {
  form: FormGroup;
  password: FormControl;

  constructor(
    private inscriptionService: RegisService,
    private router: Router

  ) {
    this.password = new FormControl('', [
      Validators.required,
      Validators.pattern(
        /^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[*?.@!=+#]).{4,20}$/
      ),
    ]);

    this.form = new FormGroup({
      nomCtrl: new FormControl('', Validators.required),
      prenomCtrl: new FormControl('', Validators.required),
      mailCtrl: new FormControl('', Validators.required),
      loginCtrl: new FormControl('', Validators.required, this.checkLogin()),
      passwordGroup: new FormGroup(
        {
          passwordCtrl: this.password,
          confirmCtrl: new FormControl(''),
        },
        this.equals
      ),
    });


  }


  checkLogin(): AsyncValidatorFn {
    return (control: AbstractControl): Observable<ValidationErrors | null> => {
      return this.inscriptionService.checkUtilisateurExist(control.value).pipe(
        map((result) => {
          return result ? { notUnique: true } : null;
        })
      );
    };
  }

  equals(control: AbstractControl): ValidationErrors | null {
    let group = control as FormGroup;
    return group.get('passwordCtrl')?.value == group.get('confirmCtrl')?.value
      ? null
      : { notequals: true };
  }


  ngOnInit(): void {}

  submit() {
    let utilisateur = {
      nom: this.form.get('nomCtrl')?.value ,
      prenom: this.form.get('prenomCtrl')?.value,
      email: this.form.get('mailCtrl')?.value,
      login: this.form.get('loginCtrl')?.value,
      pass: this.form.get('passwordGroup.passwordCtrl')?.value
    };
    console.log(utilisateur)
    this.inscriptionService.inscription(utilisateur).subscribe({
      next: (result) => {
        this.router.navigateByUrl('/home');
      },
      error: (err: HttpErrorResponse) => {
        console.log(err);
        this.form.get('loginCtrl')?.setErrors({ notUnique: true });
      },
    });
  }
  
}
