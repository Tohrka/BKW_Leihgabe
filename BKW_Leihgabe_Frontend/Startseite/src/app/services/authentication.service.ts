import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Router } from '@angular/router';
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root',
})
export class AuthenticationService {

  constructor(private http: HttpClient) { }

  getAuthentication(username: string, password: string): Observable<any> {
    return this.http.get("http://localhost:8080/Checklogin/" + username + "/" + password);
  }



}
