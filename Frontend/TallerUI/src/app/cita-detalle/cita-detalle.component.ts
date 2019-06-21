import { Component, OnInit, Input } from '@angular/core';
import { Cita } from '../model/cita';
import { CitaService } from '../cita.service';
import { CitaListaComponent } from '../cita-lista/cita-lista.component';

@Component({
  selector: 'app-cita-detalle',
  templateUrl: './cita-detalle.component.html',
  styleUrls: ['./cita-detalle.component.css']
})
export class CitaDetalleComponent implements OnInit {
  @Input() cita:Cita;
  constructor(private citaService:CitaService,
    private listado:CitaListaComponent) { }

  ngOnInit() {
  }
  deleteCliente(){
    this.citaService.deleteCita(this.cita.id)
    .subscribe(datos=>{this.listado.loadData();})
  }

}
