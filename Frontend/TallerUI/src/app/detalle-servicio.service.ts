import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Detserv } from './model/detserv';

@Injectable({
  providedIn: 'root'
})
export class DetalleServicioService {
  private baseURL = 'http://localhost:8080/api/detservicio';
  constructor(private http:HttpClient) { }

  getAll():Observable<any>{
    return this.http.get(`${this.baseURL}`);
  }

  post(detalle:Detserv):Observable<Object>{
    return this.http.post(`${this.baseURL}`,detalle);
  }
}
