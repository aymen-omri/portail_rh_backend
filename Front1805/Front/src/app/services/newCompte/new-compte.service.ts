import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from 'src/app/models/employee';

@Injectable({
  providedIn: 'root'
})
export class NewCompteService {

  private apiUrl = 'http://localhost:8090/api/v1/auth';

  constructor(private http: HttpClient) { }

  getEmployees(): Observable<Employee[]> {
    return this.http.get<Employee[]>(this.apiUrl + "/all");
  }

  getDemandeById(id: number) {
    return this.http.get<Employee[]>(this.apiUrl + "/byid/" + id);
  }

  acceptDemande(id: number) {
    return this.http.post(this.apiUrl + "/accept/" + id, {});
  }

  declineDemande(id: number) {
    return this.http.post(this.apiUrl + "/decline/" + id, {});
  }

  getUserByMatricule(matricule: string) {
    return this.http.get(this.apiUrl + "/bymat/" + matricule);
  }

}
