import {Component, OnInit} from '@angular/core';
import {AppService} from "../app.service";
import {NgForOf} from "@angular/common";

@Component({
  selector: 'app-arrondissements',
  standalone: true,
  imports: [
    NgForOf
  ],
  templateUrl: './arrondissements.component.html',
  styleUrl: './arrondissements.component.css'
})
export class ArrondissementsComponent implements OnInit{
  protected arrondissements: any;
  constructor(private AppService: AppService) { }

  ngOnInit(): void {
    this.AppService.getsorteddatabyarrondissement().subscribe((arrondissements)=>{
      console.log(arrondissements);
      this.arrondissements = arrondissements;
    });
  }

  protected Object = Object;

}
