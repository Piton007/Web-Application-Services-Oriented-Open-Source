import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Vehiculo } from './model/vehiculo';
@Injectable({
  providedIn: 'root'
})
export class VehiculoService {

  private baseURL = 'http://localhost:8080/api/vehiculo';

  constructor(private http:HttpClient) { }
  
  postvehiculo(vehiculo:Vehiculo):Observable<Object>{
    return this.http.post(`${this.baseURL}`,vehiculo);
  }
  getvehiculos():Observable<any>{
    return this.http.get(`${this.baseURL}`);
  }
}
