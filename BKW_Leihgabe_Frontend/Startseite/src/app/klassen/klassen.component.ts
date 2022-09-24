import { Component, OnInit } from '@angular/core';
import {Klasse} from "../model/klasse.model";
import {KlassenService} from "../services/klassen.Service";

@Component({
  selector: 'app-klassen',
  templateUrl: './klassen.component.html',
  styleUrls: ['./klassen.component.css']
})
export class KlassenComponent implements OnInit {
  klassen: Klasse[] = [];

  constructor(private klassenservice: KlassenService) {
    this.klassenservice.getKlasse().subscribe(data => {
      this.klassen = data;
    });
  }

  ngOnInit(): void {
  }
  show(id: number) {
    window.location.href = "http://localhost:4200/einzelklasse?klassenid=" + id;
  }

}
