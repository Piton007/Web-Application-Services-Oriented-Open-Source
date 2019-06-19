import { Component, OnInit } from '@angular/core';
import { VehiculoService } from '../vehiculo.service';
import { Vehiculo } from '../model/vehiculo';

@Component({
  selector: 'app-listar-vehiculo',
  templateUrl: './listar-vehiculo.component.html',
  styleUrls: ['./listar-vehiculo.component.css']
})
export class ListarVehiculoComponent implements OnInit {

  vehiculos:Vehiculo[];

  constructor(private vehiculoservice:VehiculoService) { }

  ngOnInit() {
    this.loaddata();
  }
  loaddata(){
    this.vehiculoservice.getvehiculos().subscribe(vehiculos=>this.vehiculos=vehiculos);
  }
}
