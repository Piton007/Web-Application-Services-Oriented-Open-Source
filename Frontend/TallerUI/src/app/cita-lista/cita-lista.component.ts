import { Component, OnInit } from '@angular/core';
import { Cita } from '../model/cita';
import { CitaService } from '../cita.service';

@Component({
  selector: 'app-cita-lista',
  templateUrl: './cita-lista.component.html',
  styleUrls: ['./cita-lista.component.css']
})
export class CitaListaComponent implements OnInit {

  
  citas:Cita[];

  constructor(private citaService:CitaService) { }

  ngOnInit() {
    this.loadData();
  }

  loadData(){
    this.citaService.getCitaList()
    .subscribe(citas=>this.citas=citas);
  }

}
