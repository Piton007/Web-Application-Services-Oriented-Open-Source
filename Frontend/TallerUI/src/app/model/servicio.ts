import { Cita } from './cita';

export class Servicio {
    cod_servicio:number;
    descripcion:string;
    cost_serv:number;
    cita_Id:Cita=new Cita();
}
