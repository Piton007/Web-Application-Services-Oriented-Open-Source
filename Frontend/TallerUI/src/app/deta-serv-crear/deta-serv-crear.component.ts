import { Component, OnInit } from '@angular/core';
import { Detserv } from '../model/detserv';
import { Servicio } from '../model/servicio';
import { Tecnico } from '../model/tecnico';
import { RepuestoProvAlmService } from '../repuesto-prov-alm.service';
import { TecnicoService } from '../tecnico.service';
import { ServicioService } from '../servicio.service';
import { DetalleServicioService } from '../detalle-servicio.service';
import { Repprovalm } from '../model/repprovalm';

@Component({
  selector: 'app-deta-serv-crear',
  templateUrl: './deta-serv-crear.component.html',
  styleUrls: ['./deta-serv-crear.component.css']
})
export class DetaServCrearComponent implements OnInit {
  detaserv: Detserv=new Detserv();
  repuestosDet:Repprovalm[];
  servicios:Servicio[];
  tecnicos:Tecnico[];
  repuestosDetselected:Repprovalm=new Repprovalm();
  servicioselected:Servicio=new Servicio();
  tecnicoselected:Tecnico=new Tecnico();
  constructor(private repuestoDetservice:RepuestoProvAlmService, private tecnicoservice:TecnicoService, 
    private servicioservice:ServicioService, private DetServ: DetalleServicioService) { }

  ngOnInit() {
    this.loaddata();
  }
  loaddata(){
  
    this.repuestoDetservice.getAll().subscribe(reps=>this.repuestosDet=reps);
    this.tecnicoservice.getAll().subscribe(tecns=>this.tecnicos=tecns);
    this.servicioservice.getServicioList().subscribe(serv=>this.servicios=serv);

  }
  Submit(){
    let hoy= new Date(Date.now());
    this.detaserv.servicio=this.servicioselected;
    this.detaserv.tecnico=this.tecnicoselected;
    this.detaserv.repuestoDet=this.repuestosDetselected;
    this.detaserv.fech_serv=hoy;
    this.DetServ.post(this.detaserv).subscribe(datos=>console.log(datos), error=>console.log(error));
    this.detaserv=new Detserv();
    this.loaddata();
    
  }

}
