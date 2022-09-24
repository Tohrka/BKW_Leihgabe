import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Schueler} from "./model/schueler.model";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor() {}
  title = 'Startseite';

}
