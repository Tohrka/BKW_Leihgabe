
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {LoginPageComponent} from "./login-page/login-page.component";
import {MainPageComponent} from "./main-page/main-page.component";
import {GereateComponent} from "./gereate/gereate.component";
import {KlassenComponent} from "./klassen/klassen.component";
import {SchuelerComponent} from "./schueler/schueler.component";
import {EinzelschuelerComponent} from "./einzelschueler/einzelschueler.component";
import {EinzelklasseComponent} from "./einzelklasse/einzelklasse.component";


const routes: Routes = [
  {path: 'login', component: LoginPageComponent},
  {path: 'main', component: MainPageComponent},
  {path: 'gereate', component: GereateComponent},
  {path: 'klassen', component: KlassenComponent},
  {path: 'schueler', component: SchuelerComponent},
  {path: 'einzelschueler', component: EinzelschuelerComponent},
  {path: 'einzelklasse', component: EinzelklasseComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
