import { Component, OnInit } from '@angular/core';
import { Cita } from '../model/cita';
import { CitaService } from '../cita.service';

@Component({
  selector: 'app-cita-lista',
  templateUrl: './cita-lista.component.html',
  styleUrls: ['./cita-lista.component.css']
})
export class CitaListaComponent implements OnInit {

  citaupdate:Cita;
  placaselect:string;
  citas:Cita[];
  dialog:boolean=false;
  dialogact:boolean=false;
  constructor(private citaService:CitaService) { }

  ngOnInit() {
    this.loadData();
  }

  loadData(){
    this.citaService.getCitaList()
    .subscribe(citas=>this.citas=citas);
  }
  Buscar(){
    if (this.placaselect.length>0) {
      this.citas=this.citas.filter(cita=>cita.cod_vehiculo.numero_placa.trim().toLowerCase().includes(this.placaselect.trim().toLocaleLowerCase()));
    }
    else{
      this.loadData();
    }
    
  }
  eliminar(id:number){
    this.citaService.deleteCita(id).subscribe(a=>{this.loadData});
  }
  openact(cita:Cita){
    this.citaupdate=cita;
    this.dialogact=true;

  }

}
