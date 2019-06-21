import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CitaService {

  private baseURL = 'http://localhost:8080/api/cita';

  constructor(private http:HttpClient) { }

  createCita(cita:Object):Observable<Object>{
    return this.http.post(`${this.baseURL}`,cita);
  }

  updateCita(cita:Object):Observable<Object>{
    return this.http.put(`${this.baseURL}`,cita);
  }

  deleteCita(id:number):Observable<any>{
    return this.http.delete(`${this.baseURL}/${id}`,{responseType:'text'});
  }

  getCitaList():Observable<any>{
    return this.http.get(`${this.baseURL}`);
  }

  getCita(id:number):Observable<any>{
    return this.http.get(`${this.baseURL}/${id}`);
  }
}
