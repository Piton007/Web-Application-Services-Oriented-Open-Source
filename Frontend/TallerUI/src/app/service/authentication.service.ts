import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthenticationService {

  constructor() { }

  authenticate(username, password) {
    if ((username === "cliente"&& password === "cliente123")||
        (username === "admin"&& password === "admin123")||
        (username === "almacen"&& password === "almacen123")
    
    ) {
      sessionStorage.setItem('username', username)
      return true;
    } else {
      return false;
    }
  }
  
  isUserLoggedIn(){
    let user=sessionStorage.getItem('username');
    return (!(user==null))
  }

  isClientLoggedIn() {
    let user = sessionStorage.getItem('username')
    if (user=='cliente') {
      return true;
    }
    else{
      return false;
    }
    
  }
  isAdminLoggedIn() {
    let user = sessionStorage.getItem('username')
    if (user=='admin') {
      return true;
    }
    else{
      return false;
    }
  }
  isAlmacenLoggedIn() {
    let user = sessionStorage.getItem('username')
    if (user=='almacen') {
      return true;
    }
    else{
      return false;
    }
  }

  logOut() {
    sessionStorage.removeItem('username')
  }
}