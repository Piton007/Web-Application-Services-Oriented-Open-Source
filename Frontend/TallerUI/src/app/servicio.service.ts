import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

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
  getServicio(id:number):Observable<any>{
    return this.http.get(`${this.baseURL}/${id}`);
  }
  deleteServicio(id:number):Observable<any>{
    return this.http.delete(`${this.baseURL}/${id}`,{responseType:'text'});
  }
}
