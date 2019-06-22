import { Component, OnInit } from '@angular/core';
import { Detserv } from '../model/detserv';
import { DetalleServicioService } from '../detalle-servicio.service';

@Component({
  selector: 'app-deta-serv-listar',
  templateUrl: './deta-serv-listar.component.html',
  styleUrls: ['./deta-serv-listar.component.css']
})
export class DetaServListarComponent implements OnInit {
  detservs: Detserv[];
  //detselect:string;

  constructor(private detservice:DetalleServicioService) { }

  ngOnInit() {
    this.loaddata();
  }

  loaddata(){
    this.detservice.getAll().subscribe(reps=>this.detservs=reps);
  }
  // Buscar(){
  //   if (this.detselect.length>0) {
  //     this.repuestos=this.repuestos.filter(rep=>rep.repuesto.nombre.trim().toLowerCase().includes(this.repselect.trim().toLocaleLowerCase()));
  //   }
  //   else{
  //     this.loaddata();
  //   }
    
  // }

}
