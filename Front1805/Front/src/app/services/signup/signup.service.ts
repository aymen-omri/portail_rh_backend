import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SignupService {

  constructor(private http: HttpClient) { }

  createDemandeCompte(demande : any) {
    return this.http.post('http://localhost:8090/api/v1/auth/register', demande);
  }
}