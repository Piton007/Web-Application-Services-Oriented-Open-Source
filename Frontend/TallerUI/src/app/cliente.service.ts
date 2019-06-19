import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {
  private baseURL = 'http://localhost:8080/api/cliente';

  constructor(private http:HttpClient) { }

  createCliente(cliente:Object):Observable<Object>{
    return this.http.post(`${this.baseURL}`,cliente);
  }

  updateCliente(cliente:Object):Observable<Object>{
    return this.http.put(`${this.baseURL}`,cliente);
  }

  deleteCliente(id:number):Observable<any>{
    return this.http.delete(`${this.baseURL}/${id}`,{responseType:'text'});
  }

  getClientesList():Observable<any>{
    return this.http.get(`${this.baseURL}`);
  }

  getCliente(id:number):Observable<any>{
    return this.http.get(`${this.baseURL}/${id}`);
  }
}
