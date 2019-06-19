import { Component, OnInit, Input } from '@angular/core';
import { Cliente } from '../model/cliente';
import { ClienteService } from '../cliente.service';
import { ClientesListaComponent } from '../clientes-lista/clientes-lista.component';

@Component({
  selector: 'app-cliente-detalle',
  templateUrl: './cliente-detalle.component.html',
  styleUrls: ['./cliente-detalle.component.css']
})
export class ClienteDetalleComponent implements OnInit {
  @Input() cliente:Cliente;

  constructor(private clienteService:ClienteService,
    private listado:ClientesListaComponent) { }


  ngOnInit() {
    
  }
  deleteCliente(){
    this.clienteService.deleteCliente(this.cliente.id)
    .subscribe(datos=>{this.listado.loadData();})
  }

}
