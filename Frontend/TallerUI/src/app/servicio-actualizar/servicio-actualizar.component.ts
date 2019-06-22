import { Component, OnInit, Input } from '@angular/core';
import { Servicio } from '../model/servicio';
import { Cita } from '../model/cita';
import { CitaService } from '../cita.service';
import { ServicioService } from '../servicio.service';
import { ServicioListarComponent } from '../servicio-listar/servicio-listar.component';

@Component({
  selector: 'app-servicio-actualizar',
  templateUrl: './servicio-actualizar.component.html',
  styleUrls: ['./servicio-actualizar.component.css']
})
export class ServicioActualizarComponent implements OnInit {

  @Input() servicio:Servicio;
  citas:Cita[];
  citaselected:Cita=new Cita();
  constructor(private citaservice:CitaService,private servicioService: ServicioService, private servList:ServicioListarComponent) { }

  ngOnInit() {
  }

  loaddata(){
    this.citaservice.getCitaList().subscribe(ci=>this.citas=ci);

  }

  Submit(){
    this.servicio.cita_Id.id=this.citaselected.id;
    this.servicioService.update(this.servicio).subscribe(datos=>console.log(datos), error=>console.log(error));
    this.loaddata();
    let myDialog:any=<any>document.getElementById("dialogo");
    this.servList.loadData();
    this.servList.dialogact=false;
    this.servicio=new Servicio();
    myDialog.close();
    
  }
}
