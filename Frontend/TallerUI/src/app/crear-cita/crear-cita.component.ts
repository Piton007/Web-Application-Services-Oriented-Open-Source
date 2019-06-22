import { Component, OnInit } from '@angular/core';
import { Cita } from '../model/cita';
import { CitaService } from '../cita.service';
import { Vehiculo } from '../model/vehiculo';
import { Asistente } from '../model/asistente';
import { VehiculoService } from '../vehiculo.service';
import { AsistenteService } from '../asistente.service';
import { CitaListaComponent } from '../cita-lista/cita-lista.component';

@Component({
  selector: 'app-crear-cita',
  templateUrl: './crear-cita.component.html',
  styleUrls: ['./crear-cita.component.css']
})
export class CrearCitaComponent implements OnInit {

  
  cita: Cita = new Cita();

  vehiculos:Vehiculo[];
  asistentes:Asistente[];
  vehiculoselected:Vehiculo= new Vehiculo();
  asistenteselected:Asistente= new Asistente();

  constructor(private vehiculoservice:VehiculoService,
    private asistenteservice:AsistenteService,private citaService:CitaService,
    private listcitas:CitaListaComponent) { }
  ngOnInit() {
    this.loaddata();
  }

 
  registrarCita(){
    this.cita.cod_vehiculo.id=this.vehiculoselected.id;
    this.cita.cod_asistente.id=this.asistenteselected.id;
    this.citaService.createCita(this.cita).subscribe(datos=>console.log(datos), error=>console.log(error));
    this.cita= new Cita();
    }
    loaddata(){
  
      this.vehiculoservice.getvehiculos().subscribe(vehs=>this.vehiculos=vehs);
      this.asistenteservice.getasistente().subscribe(asis=>this.asistentes=asis);
      
  
    }

    control(){
      let myDialog:any=<any>document.getElementById("dialogo");
      this.listcitas.loadData();
      this.listcitas.dialog=false;
      myDialog.close();
    }
}
