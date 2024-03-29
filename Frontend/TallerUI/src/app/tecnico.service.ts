import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TecnicoService {
  private baseURL = 'http://localhost:8080/api/tecnico';
  constructor(private http:HttpClient) { }
  getAll():Observable<any>{
    return this.http.get(`${this.baseURL}`);
  }
}
