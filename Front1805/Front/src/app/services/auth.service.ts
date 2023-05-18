import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Buffer } from 'buffer';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  constructor(private http: HttpClient) { }

  onLogin(login : any) {
    return this.http.post('http://localhost:8090/api/v1/auth/authenticate', login);
  }

  decodeJwtToken() {
    let tokenString = localStorage.getItem("token");
    const [headerEncoded, payloadEncoded, signatureEncoded] = tokenString!.split('.');
    const header = JSON.parse(Buffer.from(headerEncoded, 'base64').toString());
    const payload = JSON.parse(Buffer.from(payloadEncoded, 'base64').toString());
    const signature = Buffer.from(signatureEncoded, 'base64');
    return {header , payload , signature}
}
extractMatricule(){
    return this.decodeJwtToken().payload.sub;
  }

}