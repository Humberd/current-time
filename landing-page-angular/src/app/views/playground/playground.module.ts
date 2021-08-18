import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PlaygroundRoutingModule } from './playground-routing.module';
import { PlaygroundComponent } from './playground.component';
import { NavigationModule } from '../../modules/navigation/navigation.module';


@NgModule({
  declarations: [
    PlaygroundComponent
  ],
  imports: [
    CommonModule,
    PlaygroundRoutingModule,
    NavigationModule
  ]
})
export class PlaygroundModule { }
