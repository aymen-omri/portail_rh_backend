import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CongeService {


  constructor(private http: HttpClient) { }

  postFormData(formData: any): Observable<any> {
    const url = 'http://localhost:8082/demande_conge';
    return this.http.post(url, formData);
  }
}