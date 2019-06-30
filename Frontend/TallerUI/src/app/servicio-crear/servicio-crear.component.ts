import { Component, OnInit,Input } from '@angular/core';
import { Servicio } from '../model/servicio';
import { ServicioService } from '../servicio.service';
import { Cita } from '../model/cita';
import { CitaService } from '../cita.service';
import { ServicioListarComponent } from '../servicio-listar/servicio-listar.component';
import { __core_private_testing_placeholder__ } from '@angular/core/testing';
import {AuthenticationService} from '../service/authentication.service'

@Component({
  selector: 'app-servicio-crear',
  templateUrl: './servicio-crear.component.html',
  styleUrls: ['./servicio-crear.component.css']
})
export class ServicioCrearComponent implements OnInit {
  
  @Input() cita_id:number;
  servicio: Servicio = new Servicio();
  

  constructor(private ServicioService:ServicioService
    ,private servList:ServicioListarComponent,private autenticar:AuthenticationService) { }

  ngOnInit() {
  
  }
  registrarServicio(){
    this.servicio.cita_Id.id=this.cita_id;
    this.ServicioService.createServicio(this.servicio)
    .subscribe(datos=>console.log(datos), error=>console.log(error));
    this.servicio = new Servicio();
  }
  
  control(){
    let myDialog:any=<any>document.getElementById("dialogo");
    this.servList.loadData();
    this.servList.dialog=false;
    myDialog.close();
  }

}
