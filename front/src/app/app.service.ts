import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class AppService {


  constructor(private httpClient: HttpClient) { }

  public getAllTrees(){
    return this.httpClient.get(`http://localhost:8081/all`);
  }

  public getAllTreesGenreWithReps(){
    return this.httpClient.get(`http://localhost:8081/AllTreesGenreWithReps`)
  }

  public getsorteddatabyarrondissement(){
    return this.httpClient.get('http://localhost:8081/sorteddatabyarrondissement')
  }
}
