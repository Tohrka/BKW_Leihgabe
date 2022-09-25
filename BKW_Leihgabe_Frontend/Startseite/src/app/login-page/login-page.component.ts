
import {HttpClient} from "@angular/common/http";
import {Component, OnInit, ViewEncapsulation} from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Route, Router } from '@angular/router';
import {AuthenticationService} from "../services/authentication.service";

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css'],
  encapsulation: ViewEncapsulation.None
})
export class LoginComponent implements OnInit {
  validator: boolean = false;
  loginForm: FormGroup | any;
  title = 'material-login';
  constructor(
    private http: HttpClient,
    private router:Router,
    private authenticationService: AuthenticationService
  ) {
    this.loginForm = new FormGroup({
      username: new FormControl('', [Validators.required]),
      password: new FormControl('', [Validators.required])
    });
  }
  ngOnInit(): void {
  }
  onSubmit(){
    if(!this.loginForm.valid){
      return;
    }
    this.authenticationService.getAuthentication(this.loginForm.value.username, this.loginForm.value.password).subscribe(data => {
      this.validator = data;
      if(this.validator){
        this.router.navigate(['/main']);
      }
    });
    }
}
