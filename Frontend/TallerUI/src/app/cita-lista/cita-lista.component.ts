import { Component, OnInit } from '@angular/core';
import { Cita } from '../model/cita';
import { Router } from '@angular/router';
import { CitaService } from '../cita.service';
import { AuthenticationService } from '../service/authentication.service';

@Component({
  selector: 'app-cita-lista',
  templateUrl: './cita-lista.component.html',
  styleUrls: ['./cita-lista.component.css']
})
export class CitaListaComponent implements OnInit {

  citaupdate:Cita;
  placaselect:string="";
  citas:Cita[];
  dialog:boolean=false;
  dialogact:boolean=false;
  constructor(private citaService:CitaService,private router: Router, private autenticar:AuthenticationService) { }

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
  done(cita:Cita){
    cita.estado_cita=1;
    this.citaService.updateCita(cita).subscribe(a=>{this.loadData});
  }
  estado(cita:Cita){
    return (cita.estado_cita==0)?"pendiente":"terminado";
  }
  goservicio(id:number){
    this.router.navigate(['/servicio',id]);
  }
}
