import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginPageComponent } from './login-page/login-page.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HttpClientModule} from "@angular/common/http";
import { MainPageComponent } from './main-page/main-page.component';
import { GereateComponent } from './gereate/gereate.component';
import { KlassenComponent } from './klassen/klassen.component';
import { SchuelerComponent } from './schueler/schueler.component';
import { EinzelschuelerComponent } from './einzelschueler/einzelschueler.component';
import { EinzelklasseComponent } from './einzelklasse/einzelklasse.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginPageComponent,
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
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
