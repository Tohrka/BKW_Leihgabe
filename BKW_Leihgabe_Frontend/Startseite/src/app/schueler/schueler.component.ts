import { Component, OnInit } from '@angular/core';
import {Schueler} from "../model/schueler.model";
import {SchuelerService} from "../services/schueler.service";
import {HttpClient, HttpHandler} from "@angular/common/http";
import {Observable} from "rxjs";
import {MatTableDataSource} from "@angular/material/table";

@Component({
  selector: 'app-schueler',
  templateUrl: './schueler.component.html',
  styleUrls: ['./schueler.component.css']
})

export class SchuelerComponent implements OnInit {
  schueler: Schueler[] = [];


  constructor(private schuelerservice: SchuelerService) {
    this.getSchueler();
  }

  ngOnInit(): void {


    }

    async getSchueler() {
    this.schuelerservice.getSchueler().subscribe(data => {this.schueler = data;});


  }
  show(id: number) {
    //reroute to einzelschueler
    window.location.href = "http://localhost:4200/einzelschueler?schuelerid=" + id;
  }

}
