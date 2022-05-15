import { Component, OnInit } from '@angular/core';
import { DataService } from '../data.service';

interface Game {
  id: Number;
  gameGenre: String;
  gameName: String;
  gameType: String;
  releaseYear: String;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'gamersApp';

  resultGame:any =[];
 
  showMatchMakingForm = false;
  linkForm = false;
  searchSkill = false;
  searchGame = false;
  games : any;
  skills: any;
  playerBySkillFound = false;
 
  selectedSkill :any;
  selectedGame :any;

  constructor(private dataService: DataService) { }
  ngOnInit() {
    this.dataService.getCountries().subscribe((data) => {
      console.log(data);
     
    })
    this.dataService.getLevels().subscribe((data) => {
      this.skills = data;
      console.log(data);
      
    })
    this.dataService.getGames().subscribe((data) => {
      console.log(data);
      this.games = data;
    })

  }

  openMatchMakingForm() {
    this.showMatchMakingForm = true;
    this.linkForm = false;
    this.searchSkill = false;
    this.resultGame = [];
    this.playerBySkillFound = false;
  }

  openLinkForm() {
    this.linkForm = true;
    this.searchSkill = false;
    this.showMatchMakingForm = false;
    this.resultGame = [];
    this.playerBySkillFound = false;
  }

  openSearchSkillsForm() {
    this.searchSkill = true;
    this.linkForm = false;
    this.showMatchMakingForm = false;
  }

  onSkillChange() {
    this.dataService.findGameBySkills(this.selectedSkill.id).subscribe((data) => { 
      this.resultGame = data;
        if(this.resultGame.length > 0)
        {
          this.playerBySkillFound = true;
          
        }
      })
}
onGameChange()
{}

}
