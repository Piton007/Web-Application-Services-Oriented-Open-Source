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
  vehiculoselected:Vehiculo= new Vehiculo();
  asistentes:Asistente[];
  asistenteselected:Asistente= new Asistente();

  constructor(private vehiculoservice:VehiculoService,
    private asistenteservice:AsistenteService,private CitaService:CitaService) { }
  ngOnInit() {
  }
  registrarCliente(){

    this.cita.cod_vehiculo.numero_placa=this.vehiculoselected.numero_placa;
    this.cita.cod_asistente.nombre_asistente=this.asistenteselected.nombre_asistente;
    this.CitaService.createCita(this.cita)
    .subscribe(datos=>console.log(datos), error=>console.log(error));
    this.cita= new Cita();
  }

}
