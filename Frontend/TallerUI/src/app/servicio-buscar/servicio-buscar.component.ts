import { Component, OnInit } from '@angular/core';
import { Servicio } from '../model/servicio';
import { ServicioService } from '../servicio.service';

@Component({
  selector: 'app-servicio-buscar',
  templateUrl: './servicio-buscar.component.html',
  styleUrls: ['./servicio-buscar.component.css']
})
export class ServicioBuscarComponent implements OnInit {

  id:number;
  servicio:Servicio;

  constructor(private servicioService:ServicioService) { }

  ngOnInit() {
    
  }
  buscarServicioById(){
    this.servicioService.getServicio(this.id)
     .subscribe(servicio=>this.servicio=servicio);
  }

}
