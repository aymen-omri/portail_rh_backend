import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { DemandeConge } from 'src/app/models/demande-conge';


@Injectable({
  providedIn: 'root'
})
export class GetCongeService {
  private baseUrl = 'http://localhost:8082/demande_conge';

  constructor(private http: HttpClient) { }

  getAllDemandeConge(): Observable<DemandeConge[]> {
    return this.http.get<DemandeConge[]>(this.baseUrl);
  }
 
  deleteDemandeConge(id: number): Observable<void> {
    const url = `${this.baseUrl}/${id}`;
    return this.http.delete<void>(url);
  }
}