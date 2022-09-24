import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Schueler} from "../model/schueler.model";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root',
})
export class KlassenService {

  constructor(private http: HttpClient) {
  }

  getKlasse(): Observable<any> {


    return this.http.get("http://localhost:8080/klasse");
  }

  getKlassebyId(id: number | undefined): Observable<any> {


    return this.http.get("http://localhost:8080/klasse/" + id);

  }


}
