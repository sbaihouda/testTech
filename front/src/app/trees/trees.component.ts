import {Component, inject, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {AppService} from "../app.service";
import {NgForOf, NgIf} from "@angular/common";


@Component({
  selector: 'app-trees',
  standalone: true,
  imports: [
    NgForOf,
    NgIf
  ],
  templateUrl: './trees.component.html',
  styleUrl: './trees.component.css'
})
export class TreesComponent implements OnInit{
  protected trees: any;
  constructor(private arbresService: AppService) { }

  ngOnInit() {
    this.arbresService.getAllTreesGenreWithReps().subscribe((data)=>{
      console.log(data);
      this.trees = data;
    });
  }

  protected Object = Object;
}
