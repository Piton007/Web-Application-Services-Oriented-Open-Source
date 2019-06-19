import { Component, OnInit } from '@angular/core';
import { Servicio } from '../model/servicio';
import { ServicioService } from '../servicio.service';
import { Cita } from '../model/cita';
import { CitaService } from '../cita.service';

@Component({
  selector: 'app-servicio-crear',
  templateUrl: './servicio-crear.component.html',
  styleUrls: ['./servicio-crear.component.css']
})
export class ServicioCrearComponent implements OnInit {

  servicio: Servicio = new Servicio();
  citas:Cita[];
  citasSelect:Cita=new Cita();

  constructor(private citaService:CitaService,private ServicioService:ServicioService) { }

  ngOnInit() {
    this.listarCitasXServ();
  }
  registrarServicio(){
    this.servicio.Cita_Id.id=this.citasSelect.id;
    this.servicio.Cita_Id.cod_vehiculo=this.citasSelect.cod_vehiculo;
    this.servicio.Cita_Id.cod_asistente=this.citasSelect.cod_asistente;
    this.ServicioService.createServicio(this.servicio)
    .subscribe(datos=>console.log(datos), error=>console.log(error));
    this.servicio = new Servicio();
  }
  listarCitasXServ(){
    this.citaService.getCitaList().subscribe(citas=>this.citas=citas);
  }

}
