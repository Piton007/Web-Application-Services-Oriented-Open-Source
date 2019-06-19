import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { CrearClienteComponent } from './crear-cliente/crear-cliente.component';
import { ClientesListaComponent } from './clientes-lista/clientes-lista.component';
import { AppRoutingModule } from './app-routing.module';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { ClienteDetalleComponent } from './cliente-detalle/cliente-detalle.component';

@NgModule({
  declarations: [
    AppComponent,
    CrearClienteComponent,
    ClientesListaComponent,
    ClienteDetalleComponent
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
