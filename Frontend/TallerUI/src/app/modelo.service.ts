import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class ModeloService {

  private baseURL = 'http://localhost:8080/api/modelo';

  constructor(private http:HttpClient) { }
  
  getModelos():Observable<any>{
    return this.http.get(`${this.baseURL}`);
  }
}
