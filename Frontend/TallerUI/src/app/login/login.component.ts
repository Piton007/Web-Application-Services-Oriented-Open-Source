import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../service/authentication.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  private _username = ''
  password = ''
  invalidLogin = false

  constructor(private router: Router,private loginservice: AuthenticationService) { }


  
  public isError = false;
  
  set username(v : string) {
    this._username= v;
    if (this._username.length>0) {
      this.isError=false;
    }
  }
  
   get username() : string {
    return this._username 
  }
  
  
  ngOnInit() {
  }

  

  checkLogin() {
    if (this.loginservice.authenticate(this._username, this.password)) {
      this.invalidLogin = false;
      if (this.loginservice.isClientLoggedIn()) {
        this.router.navigate(['citas']);
      }
      else{
      if (this.loginservice.isAdminLoggedIn()) {
        this.router.navigate(['servicio']);
      }
      else{
       
          this.router.navigate(['repuestos']);
        
      }
    }
     
      
      
    } else{
      this.invalidLogin = true;
      this.isError=true;
     
    }
    this._username="";
    this.password='';
      
  }

}