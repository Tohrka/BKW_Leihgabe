import { Component, OnInit } from '@angular/core';
import {Schueler} from "../model/schueler.model";
import {SchuelerService} from "../services/schueler.service";
import {Klasse} from "../model/klasse.model";
import {KlassenService} from "../services/klassen.Service";

@Component({
  selector: 'app-einzelklasse',
  templateUrl: './einzelklasse.component.html',
  styleUrls: ['./einzelklasse.component.css']
})
export class EinzelklasseComponent implements OnInit {
  klasse: Klasse | undefined;
  schueler: Schueler[] = [];
  id: number = 0;

  constructor(private klassenservice: KlassenService, private schuelerservice: SchuelerService) {
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    this.id = Number(urlParams.get('klassenid'));
    this.getInfo();
  }

  ngOnInit(): void {
  }

  async getInfo() {
    await this.getKlasse();
  }
  async getKlasse() {
    this.klassenservice.getKlassebyId(this.id).subscribe(data => {
      this.klasse = data;
      this.getSchueler();
    });
  }
  async getSchueler() {
    this.schuelerservice.getSchuelerByKlasse(this.id).subscribe(data => {
      this.schueler = data;
    });
  }
  show(id: number) {
    window.location.href = "http://localhost:4200/einzelschueler?schuelerid=" + id;
  }
}
