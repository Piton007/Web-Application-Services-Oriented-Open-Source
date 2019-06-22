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
  cliselect:string;
  constructor(private clienteService:ClienteService) { }

  ngOnInit() {
    this.loadData();
  }

  loadData(){
    this.clienteService.getClientesList()
    .subscribe(clientes=>this.clientes=clientes);
  }
  Buscar(){
    if (this.cliselect.length>0) {
      this.clientes=this.clientes.filter(cli=>cli.nombre.trim().toLowerCase().includes(this.cliselect.trim().toLocaleLowerCase()));
    }
    else{
      this.loadData();
    }
    
  }
}
