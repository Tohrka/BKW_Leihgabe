import { Component, OnInit } from '@angular/core';
import {Gereat} from "../model/gereat.model";
import {GereatService} from "../services/gereat.service";

@Component({
  selector: 'app-gereate',
  templateUrl: './gereate.component.html',
  styleUrls: ['./gereate.component.css']
})
export class GereateComponent implements OnInit {
  gereat: Gereat[] = [];
  constructor(private gereateservice: GereatService) {
    this.gereateservice.getGereat().subscribe(data => {
      this.gereat = data;
    });
  }

  ngOnInit(): void {
  }

}
