import { Component, OnInit } from '@angular/core';
import { Cita } from '../model/cita';
import { CitaService } from '../cita.service';
import { Vehiculo } from '../model/vehiculo';
import { Asistente } from '../model/asistente';
import { VehiculoService } from '../vehiculo.service';
import { AsistenteService } from '../asistente.service';

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
    private asistenteservice:AsistenteService,private citaService:CitaService) { }
  ngOnInit() {
    this.loaddata();
  }

 
  registrarCliente(){
    let hoy= new Date(Date.now());
    this.cita.cod_vehiculo.numero_placa=this.vehiculoselected.numero_placa;
    this.cita.cod_asistente.nombre_asistente=this.asistenteselected.nombre_asistente;
    this.cita.fecha_reserva=hoy;
    this.citaService.createCita(this.cita).subscribe(datos=>console.log(datos), error=>console.log(error));
    this.cita= new Cita();
    }
    loaddata(){
  
      this.vehiculoservice.getvehiculos().subscribe(vehs=>this.vehiculos=vehs);
      this.asistenteservice.getasistente().subscribe(asis=>this.asistentes=asis);
      
  
    }

}
