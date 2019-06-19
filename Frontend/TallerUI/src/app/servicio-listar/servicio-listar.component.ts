import { Component, OnInit } from '@angular/core';
import { Servicio } from '../model/servicio';
import { ServicioService } from '../servicio.service';

@Component({
  selector: 'app-servicio-listar',
  templateUrl: './servicio-listar.component.html',
  styleUrls: ['./servicio-listar.component.css']
})
export class ServicioListarComponent implements OnInit {

  id:number;
  servicio:Servicio;
  servicios:Servicio[];

  constructor(private servicioService:ServicioService) { }

  ngOnInit() {
    this.loadData();
  }
  loadData(){
    this.servicioService.getServicioList()
    .subscribe(servicios=>this.servicios=servicios);
  }
  deleteServicio(){
    this.servicioService.deleteServicio(this.servicio.cod_servicio)
    .subscribe(datos=>{this.loadData();})
  }

}
