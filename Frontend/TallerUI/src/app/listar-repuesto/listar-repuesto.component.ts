import { Component, OnInit } from '@angular/core';
import { Repuestos } from '../model/repuestos';
import { Repprovalm } from '../model/repprovalm';
import { RepuestoProvAlmService } from '../repuesto-prov-alm.service';


@Component({
  selector: 'app-listar-repuesto',
  templateUrl: './listar-repuesto.component.html',
  styleUrls: ['./listar-repuesto.component.css']
})
export class ListarRepuestoComponent implements OnInit {

  dialog:boolean=false;
  repuestos: Repprovalm[];
  repselect:string;
  constructor(private repservice:RepuestoProvAlmService ) { }

  ngOnInit() {
    this.loaddata();
  }
  loaddata(){
    this.repservice.getAll().subscribe(reps=>this.repuestos=reps);
  }
  Buscar(){
    if (this.repselect.length>0) {
      this.repuestos=this.repuestos.filter(rep=>rep.repuesto.nombre.trim().toLowerCase().includes(this.repselect.trim().toLocaleLowerCase()));
    }
    else{
      this.loaddata();
    }
    
  }

  eliminar(id:number){
    this.repservice.delete(id).subscribe(a=>{this.loaddata()});
  }
  Dialog(){
    this.dialog=(this.dialog)?false:true;
  }
}
