import { Injectable } from '@angular/core';
import {
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpInterceptor
} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

  
  constructor() {}

  intercept(request: HttpRequest<unknown>, next: HttpHandler): Observable<HttpEvent<unknown>> {
    if(request.url.includes("api/v1/auth/authenticate") || request.url.includes("api/v1/auth/register")){
      return next.handle(request)
    }
    let token= localStorage.getItem("token")
    if(token){
      let requete= request.clone({headers: request.headers.set("Authorization", "Bearer " + token)})
      return next.handle(requete)
    }
    return next.handle(request)
    
  }
}
