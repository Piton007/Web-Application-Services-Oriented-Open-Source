import { Component, OnInit } from '@angular/core';
import { Cliente } from '../model/cliente';
import { ClienteService } from '../cliente.service';

@Component({
  selector: 'app-clientes-lista',
  templateUrl: './clientes-lista.component.html',
  styleUrls: ['./clientes-lista.component.css']
})
export class ClientesListaComponent implements OnInit {

  apellidos: string ='';
  clientes:Cliente[];

  constructor(private clienteService:ClienteService) { }

  ngOnInit() {
    this.loadData();
  }

  loadData(){
    this.clienteService.getClientesList()
    .subscribe(clientes=>this.clientes=clientes);
  }
}
