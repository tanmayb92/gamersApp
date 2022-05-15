import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpErrorResponse, HttpParams } from '@angular/common/http';
import { Observable, throwError } from 'rxjs';
import { catchError, map } from 'rxjs/operators';



@Injectable({
  providedIn: 'root'
})
export class DataService {
 
  private countries = 'http://localhost:8080/getCountries';
  private levels = 'http://localhost:8080/getSkills';
  private games = 'http://localhost:8080/getGames';
  private getGamerBySkill = 'http://localhost:8080/getGamerBySkill/';

  constructor(private httpClient: HttpClient) { }

  public getCountries(){
    return this.httpClient.get(this.countries);
  }

  public getLevels(){
    return this.httpClient.get(this.levels);
  }

  public getGames(){
    return this.httpClient.get(this.games);
  }

  public findGameBySkills(skillID:any){
    return this.httpClient.get(this.getGamerBySkill+skillID);
  }
}
