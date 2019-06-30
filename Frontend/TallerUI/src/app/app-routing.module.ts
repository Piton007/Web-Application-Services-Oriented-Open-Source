import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import { ClientesListaComponent } from './clientes-lista/clientes-lista.component';
import { CrearClienteComponent } from './crear-cliente/crear-cliente.component';
import {CrearVehiculoComponent} from './crear-vehiculo/crear-vehiculo.component';
import {ListarVehiculoComponent} from './listar-vehiculo/listar-vehiculo.component';
import {ServicioListarComponent} from './servicio-listar/servicio-listar.component';
import {ServicioCrearComponent} from './servicio-crear/servicio-crear.component';
import {RegistrarRepuestoComponent} from './registrar-repuesto/registrar-repuesto.component';
import {ListarRepuestoComponent} from './listar-repuesto/listar-repuesto.component';
import {CrearCitaComponent} from './crear-cita/crear-cita.component'
import {CitaListaComponent} from './cita-lista/cita-lista.component'
import {DetaServListarComponent} from './deta-serv-listar/deta-serv-listar.component';
import {DetaServCrearComponent} from './deta-serv-crear/deta-serv-crear.component';
import {ActualizarRepuestoComponent} from './actualizar-repuesto/actualizar-repuesto.component'
import { LoginComponent } from './login/login.component'
import { LogoutComponent } from './logout/logout.component'



const routes: Routes = [
    {path:'', redirectTo:'/login', pathMatch:'full'},
    {path:'listar', component:ClientesListaComponent },
    {path:'nuevo', component:CrearClienteComponent},
    {path:'vehiculo/nuevo', component:CrearVehiculoComponent},
    {path:'vehiculo/listar',component:ListarVehiculoComponent},
    {path:'servicio',component:ServicioListarComponent},
    {path:'servicio/nuevo',component:ServicioCrearComponent},
    {path:'repuestos/nuevo',component:RegistrarRepuestoComponent},
    {path:'repuestos',component:ListarRepuestoComponent},
    {path:'citas/nuevo',component:CrearCitaComponent},
    {path:'citas',component:CitaListaComponent},
    {path:'detalleServ/nuevo',component:DetaServCrearComponent},
    {path:'detalleServ/listar',component:DetaServListarComponent},
    {path:'repuestos/actualizar',component:ActualizarRepuestoComponent},
    {path: 'login', component: LoginComponent },
    {path: 'logout', component: LogoutComponent}


	
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule{}