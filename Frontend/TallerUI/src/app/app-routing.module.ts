import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import { ClientesListaComponent } from './clientes-lista/clientes-lista.component';
import { CrearClienteComponent } from './crear-cliente/crear-cliente.component';


const routes: Routes = [
    {path:'', redirectTo:'cliente', pathMatch:'full'},
    {path:'listar', component:ClientesListaComponent},
    {path:'nuevo', component:CrearClienteComponent}
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
})

export class AppRoutingModule{}