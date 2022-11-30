import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PacientesRoutingModule } from './pacientes-routing.module';
import { ListaPacientesComponent } from './lista-pacientes/lista-pacientes.component';


@NgModule({
  declarations: [
    ListaPacientesComponent
  ],
  imports: [
    CommonModule,
    PacientesRoutingModule
  ]
})
export class PacientesModule { }
