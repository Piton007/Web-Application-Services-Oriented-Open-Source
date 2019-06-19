import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import { ClientesListaComponent } from './clientes-lista/clientes-lista.component';
import { CrearClienteComponent } from './crear-cliente/crear-cliente.component';
import {CrearVehiculoComponent} from './crear-vehiculo/crear-vehiculo.component'
import {ListarVehiculoComponent} from './listar-vehiculo/listar-vehiculo.component'

const routes: Routes = [
    {path:'', redirectTo:'cliente', pathMatch:'full'},
    {path:'listar', component:ClientesListaComponent},
    {path:'nuevo', component:CrearClienteComponent},
    {path:'vehiculo/nuevo', component:CrearVehiculoComponent},
    {path:'vehiculo/listar',component:ListarVehiculoComponent}
	
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule{}