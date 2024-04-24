import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {HttpClient, HttpClientModule, provideHttpClient} from '@angular/common/http';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {TreesComponent} from "./trees/trees.component";
import {ArrondissementsComponent} from "./arrondissements/arrondissements.component";
import {AppRoutingModule} from "./app.routes";

@NgModule({
  declarations: [
    AppComponent,
    TreesComponent,
    ArrondissementsComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule
  ],
  providers: [
    HttpClientModule,
    HttpClient,
    provideHttpClient()],
  bootstrap: [AppComponent]
})
export class AppModule { }
