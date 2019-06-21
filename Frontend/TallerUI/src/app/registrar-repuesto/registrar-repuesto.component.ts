import { Component, OnInit } from '@angular/core';
import { RepuestosService } from '../repuestos.service';
import { AlmacenService } from '../almacen.service';
import { Proveedor } from '../model/proveedor';
import { ProveedorService } from '../proveedor.service';
import { Repuestos } from '../model/repuestos';
import { Almacen } from '../model/almacen';
import { Repprovalm } from '../model/repprovalm';
import { RepuestoProvAlmService } from '../repuesto-prov-alm.service';

@Component({
  selector: 'app-registrar-repuesto',
  templateUrl: './registrar-repuesto.component.html',
  styleUrls: ['./registrar-repuesto.component.css']
})
export class RegistrarRepuestoComponent implements OnInit {
  registro: Repprovalm=new Repprovalm();
  proveedores:Proveedor[];
  repuestos:Repuestos[];
  almacenes:Almacen[];
  repuestoselected:Repuestos=new Repuestos();
  provselected:Proveedor=new Proveedor();
  almacenselected:Almacen=new Almacen();
  constructor(private repuestoservice:RepuestosService, private almacenService:AlmacenService,
    private proveedorService:ProveedorService ,private RepProvAlm: RepuestoProvAlmService) { }

  ngOnInit() {
    this.loaddata();
  }

  loaddata(){
  
    this.repuestoservice.getAll().subscribe(reps=>this.repuestos=reps);
    this.proveedorService.getProveedor().subscribe(provs=>this.proveedores=provs);
    this.almacenService.getAll().subscribe(alm=>this.almacenes=alm);

  }
  Submit(){
    let hoy= new Date(Date.now());
    this.registro.almacen=this.almacenselected;
    this.registro.provedor=this.provselected;
    this.registro.repuesto=this.repuestoselected;
    this.registro.fecha_ingreso=hoy;
    this.RepProvAlm.post(this.registro).subscribe(datos=>console.log(datos), error=>console.log(error));
    this.registro=new Repprovalm();
    this.loaddata();
    
  }

}
