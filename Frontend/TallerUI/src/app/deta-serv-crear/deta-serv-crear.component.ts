import { Component, OnInit } from '@angular/core';
import { Detserv } from '../model/detserv';
import { Repuestos } from '../model/repuestos';
import { Servicio } from '../model/servicio';
import { Tecnico } from '../model/tecnico';
import { RepuestosService } from '../repuestos.service';
import { TecnicoService } from '../tecnico.service';
import { ServicioService } from '../servicio.service';
import { DetalleServicioService } from '../detalle-servicio.service';

@Component({
  selector: 'app-deta-serv-crear',
  templateUrl: './deta-serv-crear.component.html',
  styleUrls: ['./deta-serv-crear.component.css']
})
export class DetaServCrearComponent implements OnInit {
  detaserv: Detserv=new Detserv();
  repuestos:Repuestos[];
  servicios:Servicio[];
  tecnicos:Tecnico[];
  repuestoselected:Repuestos=new Repuestos();
  servicioselected:Servicio=new Servicio();
  tecnicoselected:Tecnico=new Tecnico();
  constructor(private repuestoservice:RepuestosService, private tecnicoservice:TecnicoService, 
    private servicioservice:ServicioService, private DetServ: DetalleServicioService) { }

  ngOnInit() {
    this.loaddata();
  }
  loaddata(){
  
    this.repuestoservice.getAll().subscribe(reps=>this.repuestos=reps);
    this.tecnicoservice.getAll().subscribe(tecns=>this.tecnicos=tecns);
    this.servicioservice.getServicioList().subscribe(serv=>this.servicios=serv);

  }
  Submit(){
    let hoy= new Date(Date.now());
    this.detaserv.servicio=this.servicioselected;
    this.detaserv.tecnico=this.tecnicoselected;
    this.detaserv.repuesto=this.repuestoselected;
    this.detaserv.Fech_serv=hoy;
    this.DetServ.post(this.detaserv).subscribe(datos=>console.log(datos), error=>console.log(error));
    this.detaserv=new Detserv();
    this.loaddata();
    
  }

}
