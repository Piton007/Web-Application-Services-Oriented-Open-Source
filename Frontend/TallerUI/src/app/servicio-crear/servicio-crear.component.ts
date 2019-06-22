﻿import { Component, OnInit } from '@angular/core';
import { Servicio } from '../model/servicio';
import { ServicioService } from '../servicio.service';
import { Cita } from '../model/cita';
import { CitaService } from '../cita.service';
import { ServicioListarComponent } from '../servicio-listar/servicio-listar.component';

@Component({
  selector: 'app-servicio-crear',
  templateUrl: './servicio-crear.component.html',
  styleUrls: ['./servicio-crear.component.css']
})
export class ServicioCrearComponent implements OnInit {

  servicio: Servicio = new Servicio();
  citas:Cita[];
  citasSelect:Cita=new Cita();

  constructor(private citaService:CitaService,private ServicioService:ServicioService
    ,private servList:ServicioListarComponent) { }

  ngOnInit() {
    this.listarCitasXServ();
  }
  registrarServicio(){
    this.servicio.cita_Id.id=this.citasSelect.id;
    this.ServicioService.createServicio(this.servicio)
    .subscribe(datos=>console.log(datos), error=>console.log(error));
    this.servicio = new Servicio();
  }
  listarCitasXServ(){
    this.citaService.getCitaList().subscribe(citas=>this.citas=citas);
  }
  control(){
    let myDialog:any=<any>document.getElementById("dialogo");
    this.servList.loadData();
    this.servList.dialog=false;
    myDialog.close();
  }

}
