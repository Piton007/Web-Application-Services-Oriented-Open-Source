import { Component, OnInit } from '@angular/core';
import { Servicio } from '../model/servicio';
import { ServicioService } from '../servicio.service';
import { ActivatedRoute } from '@angular/router';
import {AuthenticationService} from '../service/authentication.service'

@Component({
  selector: 'app-servicio-listar',
  templateUrl: './servicio-listar.component.html',
  styleUrls: ['./servicio-listar.component.css']
})
export class ServicioListarComponent implements OnInit {

  id:number;
  servicioupdate:Servicio;
  public servicios:Servicio[] = new Array(0);
  servselect:string;
  dialog:boolean=false;
  dialogact:boolean=false;

  constructor(private servicioService:ServicioService,private router: ActivatedRoute
    ,private autenticar:AuthenticationService) { }

  ngOnInit() {
    this.id= parseInt(this.router.snapshot.paramMap.get('id'));
    this.loadData();
  }
  loadData(){
    this.servicioService.getServicioList()
    .subscribe(servicios=>this.servicios=servicios.filter(rep=>rep.cita_Id.id==this.id));
   
    console.log(this.id);
    
    
  }
  // Buscar(){
  //   if (this.servselect.length>0) {
  //     this.servicios=this.servicios.filter(rep=>rep.cita_Id.trim().toLowerCase().includes(this.repselect.trim().toLocaleLowerCase()));
  //   }
  //   else{
  //     this.loaddata();
  //   }
    
  // }

  eliminar(id:number){
    this.servicioService.delete(id).subscribe(a=>{this.loadData()});
  }
  openact(ser:Servicio){
    this.servicioupdate=ser;
    this.dialogact=true;

  }



}
