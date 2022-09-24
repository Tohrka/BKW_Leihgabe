import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Schueler} from "../model/schueler.model";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root',
})
export class SchuelerService {

  constructor(private http: HttpClient) {
  }

  getSchueler(): Observable<any> {


    return this.http.get<Schueler[]>("http://localhost:8080/schueler");
  }

  getSchuelerById(id: number): Observable<any> {
    return this.http.get("http://localhost:8080/schueler/" + id);
  }
  getSchuelerByKlasse(id: number): Observable<any> {
    return this.http.get("http://localhost:8080/schueler/klasse/" + id);
  }

}
