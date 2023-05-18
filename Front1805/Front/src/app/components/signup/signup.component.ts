import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { SignupService } from 'src/app/services/signup/signup.service';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css'],
})
export class SignupComponent implements OnInit {
  genre : string =""
  disable : string =""
  myForm = new FormGroup({
    "firstName":new FormControl('',Validators.required),
    "lastName":new FormControl('',Validators.required),
    "birthday":new FormControl('',Validators.required),
    "phoneNumber":new FormControl('',Validators.required),
    "adresse":new FormControl('',Validators.required),
    "email":new FormControl('',[Validators.required, Validators.email]),
    "password":new FormControl('',[Validators.required]),
    "cin":new FormControl('',[Validators.required]),
  })

  constructor(private signupService: SignupService) {}

  ngOnInit() {

  }
  
  onFeminin(event: any){
    if(event.target.checked){
      this.genre = event.target.value
      this.disable = "false"
      console.log(event.target.value)
    }
  }

  onMasculin(event : any){
    if(event.target.checked){
      this.genre = event.target.value
      this.disable = "false"
    }
  }

  onSubmit() {
    if(this.myForm.valid){
      let a = {
        "firstName": this.myForm.value.firstName,
        "lastName": this.myForm.value.lastName,
        "birthday":this.myForm.value.birthday,
        "phoneNumber":this.myForm.value.phoneNumber,
        "adresse":this.myForm.value.adresse,
        "email":this.myForm.value.email,
        "password":this.myForm.value.password,
        "cin":this.myForm.value.cin,
        "genre":this.genre,
      }

      this.signupService.createDemandeCompte(a).subscribe(
        (response : any) => {
          console.log(response)
          if(response.body == "Email deja utilisé, votre demande est en cours!"){
            alert("Email deja utilisé, votre demande est en cours!")
          }
          else
          alert("Demande envoyé!")
        },
        error => {
          console.error(error);
        }
      );
  
    }
  }
}