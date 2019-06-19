import { Cliente } from './cliente';
import { Modelo } from './modelo';

export class Vehiculo {
    ano:number;
    cod_cliente:Cliente= new Cliente();
    cod_modelo:Modelo = new Modelo();
    color:string;
    id:number;
    numero_placa:string;
    numero_serie_motor:string;
    tipo_vehiculo:string;
}
