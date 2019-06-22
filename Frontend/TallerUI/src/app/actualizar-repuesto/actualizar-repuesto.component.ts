import { Component, OnInit,Input } from '@angular/core';
import { RepuestoProvAlmService } from '../repuesto-prov-alm.service';
import { Proveedor } from '../model/proveedor';
import { Repuestos } from '../model/repuestos';
import { Almacen } from '../model/almacen';
import { ListarRepuestoComponent } from '../listar-repuesto/listar-repuesto.component';
import { ProveedorService } from '../proveedor.service';
import { RepuestosService } from '../repuestos.service';
import { AlmacenService } from '../almacen.service';
import { Repprovalm } from '../model/repprovalm';

@Component({
  selector: 'app-actualizar-repuesto',
  templateUrl: './actualizar-repuesto.component.html',
  styleUrls: ['./actualizar-repuesto.component.css']
})
export class ActualizarRepuestoComponent implements OnInit {

  @Input() repuesto:Repprovalm;
  proveedores:Proveedor[];
  repuestos:Repuestos[];
  almacenes:Almacen[];
  repuestoselected:Repuestos=new Repuestos();
  provselected:Proveedor=new Proveedor();
  almacenselected:Almacen=new Almacen();
  constructor(private repuestoservice:RepuestosService, private almacenService:AlmacenService,
    private proveedorService:ProveedorService ,private RepProvAlm: RepuestoProvAlmService,
    private  listreps:ListarRepuestoComponent ) { }

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
    this.repuesto.fecha_ingreso=hoy;
    this.RepProvAlm.update(this.repuesto).subscribe(datos=>console.log(datos), error=>console.log(error));
    this.loaddata();
    let myDialog:any=<any>document.getElementById("dialogo");
    this.listreps.loaddata();
    this.listreps.dialogact=false;
    this.repuesto=new Repprovalm();
    myDialog.close();
    
  }

  

}
