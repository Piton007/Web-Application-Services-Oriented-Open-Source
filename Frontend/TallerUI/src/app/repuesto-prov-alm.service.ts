import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Repprovalm} from './model/repprovalm'
@Injectable({
  providedIn: 'root'
})
export class RepuestoProvAlmService {
  private baseURL = 'http://localhost:8080/api/repuesto_proveedor_almacen';

  constructor(private http:HttpClient) { }

  getAll():Observable<any>{
    return this.http.get(`${this.baseURL}`);
  }

  post(repuesto:Repprovalm):Observable<Object>{
    return this.http.post(`${this.baseURL}`,repuesto);
  }
  delete(id:number):Observable<any>{
    return this.http.delete(`${this.baseURL}/${id}`,{responseType:'text'});
  }
}
