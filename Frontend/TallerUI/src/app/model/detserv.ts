import { Servicio } from './servicio';
import { Repuestos } from './repuestos';
import { Tecnico } from './tecnico';

export class Detserv {
    cod_det_serv: number;
    servicio: Servicio=new Servicio();
    repuesto: Repuestos=new Repuestos();
    tecnico: Tecnico=new Tecnico();
    cost_detalle: number;
    fech_serv: Date;
    cant_rep: number;
}
