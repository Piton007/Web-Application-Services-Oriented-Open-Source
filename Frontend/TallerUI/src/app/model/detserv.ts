import { Servicio } from './servicio';
import { Tecnico } from './tecnico';
import { Repprovalm } from './repprovalm';

export class Detserv {
    cod_det_serv: number;
    servicio: Servicio=new Servicio();
    repuestoDet: Repprovalm=new Repprovalm();
    tecnico: Tecnico=new Tecnico();
    cost_detalle: number;
    fech_serv: Date;
    cant_rep: number;
}
