import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ContactListComponent } from './contact-list/contact-list.component';
import { ContactCreateComponent } from './contact-create/contact-create.component';
import { HomeComponent } from './home/home.component';
import {LoginPageComponent} from './login-page/login-page.component';
import {MyWorldComponent} from './my-world/my-world.component';
import {AddTripComponent} from './add-trip/add-trip.component';

const routes: Routes = [
  {path:  '', pathMatch:  'full', redirectTo:  'login'},
  {path: 'login', component: LoginPageComponent},
  {path: 'home', component: HomeComponent},
  {path: 'my-world', component: MyWorldComponent},
  {path: 'add-trip', component: AddTripComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
