import { Component } from '@angular/core';
import {RouterLink, RouterOutlet} from '@angular/router';
import {TreesComponent} from "./trees/trees.component";
import {ArrondissementsComponent} from "./arrondissements/arrondissements.component";

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, TreesComponent, ArrondissementsComponent, RouterLink],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'front';
  isComponent1Visible: boolean = false;
  isComponent2Visible: boolean = false;

  showComponent1() {
    this.isComponent1Visible = true;
    this.isComponent2Visible = false;
  }

  showComponent2() {
    this.isComponent1Visible = false;
    this.isComponent2Visible = true;
  }
}
