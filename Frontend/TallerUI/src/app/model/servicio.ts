import { Cita } from './cita';

export class Servicio {
    cod_servicio:number;
    descripcion:string;
    cost_serv:number;
    Cita_Id:Cita=new Cita();
}
