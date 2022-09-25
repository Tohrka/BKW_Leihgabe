import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent} from "./login-page/login-page.component";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule} from "@angular/common/http";
import { MainPageComponent } from './main-page/main-page.component';
import { GereateComponent } from './gereate/gereate.component';
import { KlassenComponent } from './klassen/klassen.component';
import { SchuelerComponent } from './schueler/schueler.component';
import { EinzelschuelerComponent } from './einzelschueler/einzelschueler.component';
import { EinzelklasseComponent } from './einzelklasse/einzelklasse.component';
import {ReactiveFormsModule} from "@angular/forms";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatInputModule} from "@angular/material/input";
import {MatButtonModule} from "@angular/material/button";
import {MatRippleModule} from "@angular/material/core";


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    MainPageComponent,
    GereateComponent,
    KlassenComponent,
    SchuelerComponent,
    EinzelschuelerComponent,
    EinzelklasseComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    ReactiveFormsModule,
    MatFormFieldModule,
    MatInputModule,
    MatButtonModule,
    MatRippleModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
