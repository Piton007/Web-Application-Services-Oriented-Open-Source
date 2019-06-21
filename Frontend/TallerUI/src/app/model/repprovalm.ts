import { Proveedor } from './proveedor';
import { Almacen } from './almacen';
import { Repuestos } from './repuestos';

export class Repprovalm {
    cod_repuesto_prov_alm:number;
    fecha_ingreso:Date;
    cantidad:number;
    provedor:Proveedor= new Proveedor();
    almacen:Almacen= new Almacen();
    repuesto:Repuestos=new Repuestos();
}
