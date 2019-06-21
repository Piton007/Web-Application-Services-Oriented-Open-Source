import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { CrearClienteComponent } from './crear-cliente/crear-cliente.component';
import { ClientesListaComponent } from './clientes-lista/clientes-lista.component';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { ClienteDetalleComponent } from './cliente-detalle/cliente-detalle.component';
import { CrearVehiculoComponent } from './crear-vehiculo/crear-vehiculo.component';
import { ListarVehiculoComponent } from './listar-vehiculo/listar-vehiculo.component';
import { ServicioListarComponent } from './servicio-listar/servicio-listar.component';
import { ServicioBuscarComponent } from './servicio-buscar/servicio-buscar.component';
import { ServicioCrearComponent } from './servicio-crear/servicio-crear.component';
import { RegistrarRepuestoComponent } from './registrar-repuesto/registrar-repuesto.component';
import { ListarRepuestoComponent } from './listar-repuesto/listar-repuesto.component';

@NgModule({
  declarations: [
    AppComponent,
    CrearClienteComponent,
    ClientesListaComponent,
    ClienteDetalleComponent,
    CrearVehiculoComponent,
    ListarVehiculoComponent,
    ServicioListarComponent,
    ServicioBuscarComponent,
    ServicioCrearComponent,
    RegistrarRepuestoComponent,
    ListarRepuestoComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
