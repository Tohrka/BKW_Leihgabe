import {Component, OnInit} from '@angular/core';
import {Schueler} from "../model/schueler.model";
import {SchuelerService} from "../services/schueler.service";
import {HttpClient, HttpHandler} from "@angular/common/http";
import {Observable} from "rxjs";
import {Gereat} from "../model/gereat.model";
import {GereatService} from "../services/gereat.service";
import {Ausgabe} from "../model/ausgabe.model";
import {AusgabeService} from "../services/ausgabe.service";
import {Klasse} from "../model/klasse.model";
import {KlassenService} from "../services/klassen.Service";

@Component({
  selector: 'app-einzelschueler',
  templateUrl: './einzelschueler.component.html',
  styleUrls: ['./einzelschueler.component.css']
})
export class EinzelschuelerComponent implements OnInit {
  schueler: Schueler | undefined;
  gereat: Gereat[] = [];
  ausgabe: Ausgabe[] = [];
  klasse: Klasse | undefined;
  id: number = 0;

  constructor(private schuelerservice: SchuelerService, private gereatservice: GereatService, private ausgabeservice: AusgabeService, private klassenservice: KlassenService) {
    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    this.id = Number(urlParams.get('schuelerid'));

    this.getInfo();
  }

  ngOnInit(): void {
  }

  async getInfo() {
   await this.getSchueler();
   await this.getAusgabe();


  }

  async getKlassenName(klassenid: number): Promise<string> {
    this.klassenservice.getKlassebyId(klassenid).subscribe(data => {
      this.klasse = data;
      console.log(data);
      console.log(this.klasse);
    });
    if (this.klasse != undefined) {
      return this.klasse.klassenname;
    } else {
      return "";
    }
  }

  async getSchueler(): Promise<number> {
    this.schuelerservice.getSchuelerById(this.id).subscribe(data => {
      this.schueler = data;
      if (this.schueler != undefined) {
        this.getKlassenName(this.schueler.schueler_id);
      }
    });
    if (this.schueler != undefined) {
      return this.schueler.schueler_id
    } else {
      return 0;
    }
  }

  async getAusgabe(): Promise<Ausgabe[]> {
    this.ausgabeservice.getAusgabeBySchueler(this.id).subscribe(data => {
      this.ausgabe = data;
      if (this.ausgabe != undefined) {
        this.getGereat(this.ausgabe);
      }
    });
    if (this.ausgabe != undefined) {
      return this.ausgabe;
    } else {
      return [];
    }

  }

  async getGereat(ausgabe: Ausgabe[]): Promise<Gereat[]> {
    ausgabe.forEach(ausgabe => {
      console.log(ausgabe);
      this.gereatservice.getGereatById(ausgabe.seriennummer).subscribe(data => {
        this.gereat = this.gereat.concat(data);
      });

    });
    if (this.gereat != undefined) {
      return this.gereat;
    } else {
      return [];
    }
  }
}
