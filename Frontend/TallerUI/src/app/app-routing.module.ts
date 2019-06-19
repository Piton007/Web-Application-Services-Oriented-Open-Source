import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import { ClientesListaComponent } from './clientes-lista/clientes-lista.component';
import { CrearClienteComponent } from './crear-cliente/crear-cliente.component';
import {CrearVehiculoComponent} from './crear-vehiculo/crear-vehiculo.component'
import {ListarVehiculoComponent} from './listar-vehiculo/listar-vehiculo.component'
import {ServicioListarComponent} from './servicio-listar/servicio-listar.component'
import {ServicioCrearComponent} from './servicio-crear/servicio-crear.component'
import {ServicioBuscarComponent} from './servicio-buscar/servicio-buscar.component'

const routes: Routes = [
    {path:'', redirectTo:'cliente', pathMatch:'full'},
    {path:'listar', component:ClientesListaComponent},
    {path:'nuevo', component:CrearClienteComponent},
    {path:'vehiculo/nuevo', component:CrearVehiculoComponent},
    {path:'vehiculo/listar',component:ListarVehiculoComponent},
    {path:'servicio/listar',component:ServicioListarComponent},
    {path:'servicio/nuevo',component:ServicioCrearComponent},
    {path:'servicio/buscar',component:ServicioBuscarComponent}
	
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule{}