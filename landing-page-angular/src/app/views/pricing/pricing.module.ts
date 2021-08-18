import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { PricingRoutingModule } from './pricing-routing.module';
import { PricingComponent } from './pricing.component';
import { NavigationModule } from '../../modules/navigation/navigation.module';


@NgModule({
  declarations: [
    PricingComponent
  ],
  imports: [
    CommonModule,
    PricingRoutingModule,
    NavigationModule
  ]
})
export class PricingModule { }
