import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Servicio } from './model/servicio';

@Injectable({
  providedIn: 'root'
})
export class ServicioService {

  private baseURL = 'http://localhost:8080/api/servicio';

  constructor(private http:HttpClient) { }

  createServicio(servicio:Object):Observable<Object>{
    return this.http.post(`${this.baseURL}`,servicio);
  }
  getServicioList():Observable<any>{
    return this.http.get(`${this.baseURL}`);
  }
  delete(id:number):Observable<any>{
    return this.http.delete(`${this.baseURL}/${id}`,{responseType:'text'});
  }
  update(servicio:Servicio):Observable<Object>{
    return this.http.put(`${this.baseURL}`,servicio);
  }
}
