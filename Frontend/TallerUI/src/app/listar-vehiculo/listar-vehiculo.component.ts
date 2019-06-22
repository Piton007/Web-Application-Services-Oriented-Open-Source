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
  vehselect:string;
  constructor(private vehiculoservice:VehiculoService) { }

  ngOnInit() {
    this.loaddata();
  }
  loaddata(){
    this.vehiculoservice.getvehiculos().subscribe(vehiculos=>this.vehiculos=vehiculos);
  }
  Buscar(){
    if (this.vehselect.length>0) {
      this.vehiculos=this.vehiculos.filter(rep=>rep.numero_placa.trim().toLowerCase().includes(this.vehselect.trim().toLocaleLowerCase()));
    }
    else{
      this.loaddata();
    }
    
  }
}
