import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '',
    pathMatch: 'full',
    loadChildren: () => import('./views/home/home.module').then(m => m.HomeModule),
  }, {
    path: 'pricing',
    loadChildren: () => import('./views/pricing/pricing.module').then(m => m.PricingModule),
  }, {
    path: 'playground',
    loadChildren: () => import('./views/playground/playground.module').then(m => m.PlaygroundModule),
  }
  ];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {
}
