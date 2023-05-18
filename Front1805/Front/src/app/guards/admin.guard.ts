import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable, map, of } from 'rxjs';
import { NewCompteService } from '../services/newCompte/new-compte.service';
import { AuthService } from '../services/auth.service';

@Injectable({
  providedIn: 'root'
})
export class AdminGuard implements CanActivate {
  constructor(private compteService: NewCompteService, private authService: AuthService) { }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    return this.compteService.getUserByMatricule(this.authService.extractMatricule()).pipe(map((value: any) => {
      if (value.role == "ROLE_ADMIN") {
        return true;
      }
      window.location.replace("/dashboard/profile")
      return false;
    }));
  }

}
