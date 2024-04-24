import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {TreesComponent} from "./trees/trees.component";
import {ArrondissementsComponent} from "./arrondissements/arrondissements.component";
import {AppComponent} from "./app.component";

export const routes: Routes = [
  { path: 'trees', component: TreesComponent },
  { path: 'arrondissements', component: ArrondissementsComponent },
  { path: '', redirectTo: '/trees', pathMatch: 'full' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
