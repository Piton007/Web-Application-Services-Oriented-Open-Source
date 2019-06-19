import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CitaService {

  private baseURL = 'http://localhost:8080/api/cita';

  constructor(private http:HttpClient) { }

  getCitaList():Observable<any>{
    return this.http.get(`${this.baseURL}`);
  }
}
