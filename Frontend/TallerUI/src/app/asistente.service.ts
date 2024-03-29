import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AsistenteService {

  private baseURL = 'http://localhost:8080/api/asistente';
  constructor(private http:HttpClient) { }

  getasistente():Observable<any>{
    return this.http.get(`${this.baseURL}`);
  }
}
