import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from '@angular/common/http';
import {Schueler} from "../model/schueler.model";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root',
})
export class GereatService {

  constructor(private http: HttpClient) {
  }

  getGereat(): Observable<any> {


    return this.http.get<Schueler[]>("http://localhost:8080/gereat");
  }

  getGereatById(id: number): Observable<any> {
    return this.http.get("http://localhost:8080/gereat/" + id);
  }


}
