import { Component, OnInit } from '@angular/core';
import { Cliente } from '../model/cliente';
import { ClienteService } from '../cliente.service';


@Component({
  selector: 'app-crear-cliente',
  templateUrl: './crear-cliente.component.html',
  styleUrls: ['./crear-cliente.component.css']
})
export class CrearClienteComponent implements OnInit {

  cliente: Cliente = new Cliente();

  constructor(private ClienteService:ClienteService) { }

  ngOnInit() {
  }
  registrarCliente(){
    this.ClienteService.createCliente(this.cliente)
    .subscribe(datos=>console.log(datos), error=>console.log(error));
    this.cliente = new Cliente();
  }
}
