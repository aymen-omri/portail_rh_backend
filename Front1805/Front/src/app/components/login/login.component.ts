import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';
import { error } from 'console';
import { NewCompteService } from 'src/app/services/newCompte/new-compte.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  myForm = new FormGroup({
    "matricule": new FormControl('', Validators.required),
    "password": new FormControl('', Validators.required),
  })

  constructor(private authService: AuthService, private router: Router ,private  compteService : NewCompteService) { }

  goToDashboard() {
    this.router.navigate(['dashboard/main']);
  }

  goToSignup() {
    this.router.navigate(['signup']);
  }

  ngOnInit() {

  }

  onSubmit() {
    if (this.myForm.valid) {
      this.authService.onLogin(this.myForm.value).subscribe({
        next: (value: any) => {
          console.log(value);
          localStorage.setItem("token", value.body.token)
          alert(this.authService.extractMatricule())
          this.goToDashboard();
        },
        error: (err) => {
          alert("Warning!!!")
        }
      })
    }

  }
}