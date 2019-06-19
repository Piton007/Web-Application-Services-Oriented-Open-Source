import { Marca } from './marca';

export class Modelo {
    id:number;
    nombre_modelo:string;
    cod_marca:Marca=new Marca();
   
}
