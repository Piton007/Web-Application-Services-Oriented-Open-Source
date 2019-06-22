import { Component, OnInit } from '@angular/core';
import { ClienteService } from '../cliente.service';
import { Cliente } from '../model/cliente';
import { ModeloService } from '../modelo.service';
import { Modelo } from '../model/modelo';
import { Vehiculo } from '../model/vehiculo';
import { VehiculoService } from '../vehiculo.service';

@Component({
  selector: 'app-crear-vehiculo',
  templateUrl: './crear-vehiculo.component.html',
  styleUrls: ['./crear-vehiculo.component.css']
})
export class CrearVehiculoComponent implements OnInit {

  id:number=1;
  cli: Cliente= new Cliente();
  modelos:Modelo[];
  modeloselected:Modelo= new Modelo();
  vehiculo:Vehiculo= new Vehiculo();
  
  constructor(private clienteservice:ClienteService,
    private modeloservice:ModeloService,private vehiculoservice:VehiculoService
    ) { }

  ngOnInit() {
    
    
    this.loaddata();
    }

  registrarVehiculo(){
    this.vehiculo.cod_modelo.id=this.modeloselected.id;
    this.vehiculo.cod_modelo.cod_marca=this.modeloselected.cod_marca;
    this.vehiculo.cod_cliente.id=this.cli.id;
    this.vehiculoservice.postvehiculo(this.vehiculo).subscribe(datos=>console.log(datos), error=>console.log(error));
    this.vehiculo=new Vehiculo();
  }
  loaddata(){
   
    this.modeloservice.getModelos().subscribe(modelos=>this.modelos=modelos);
    this.clienteservice.getCliente(this.id).subscribe(cliente=>this.cli=cliente);

  }

}
