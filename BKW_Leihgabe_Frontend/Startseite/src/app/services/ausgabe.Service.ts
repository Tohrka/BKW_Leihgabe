import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Schueler} from "../model/schueler.model";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root',
})
export class AusgabeService {

  constructor(private http: HttpClient) {
  }

  getAusgabe(): Observable<any> {


    return this.http.get("http://localhost:8080/gereat");
  }

  getAusgabeBySchueler(id: number): Observable<any> {
    return this.http.get("http://localhost:8080/ausgabe/schueler/" + id);
  }


}
