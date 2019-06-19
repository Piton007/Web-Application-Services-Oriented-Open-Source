import { Vehiculo } from './vehiculo';
import { Asistente } from './asistente';

export class Cita {
    id: number;
    cod_vehiculo:Vehiculo=new Vehiculo();
    cod_asistente:Asistente=new Asistente();
    descripcion:string;
    fecha_reserva:Date;
    estado_cita:number;
}
