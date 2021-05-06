import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { ContactCreateComponent } from './contact-create/contact-create.component';
import { ContactListComponent } from './contact-list/contact-list.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import {GoogleApiModule, NG_GAPI_CONFIG, NgGapiClientConfig} from 'ng-gapi';
import {environment} from '../environments/environment';
import { LoginPageComponent } from './login-page/login-page.component';
import {UserService} from './Services/user.service';
import { AddTripComponent } from './add-trip/add-trip.component';
import { MyWorldComponent } from './my-world/my-world.component';

const gapiClientConfig: NgGapiClientConfig = {
  client_id: environment.client_id,
  discoveryDocs: ['https://analyticsreporting.googleapis.com/$discovery/rest?version=v4'],
  scope: [
    'https://www.googleapis.com/auth/analytics.readonly',
    'https://www.googleapis.com/auth/analytics'
  ].join(' ')
};

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    ContactCreateComponent,
    ContactListComponent,
    HeaderComponent,
    FooterComponent,
    LoginPageComponent,
    AddTripComponent,
    MyWorldComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    GoogleApiModule.forRoot({
      provide: NG_GAPI_CONFIG,
      useValue: gapiClientConfig
    }),
  ],
  providers: [UserService],
  bootstrap: [AppComponent]
})
export class AppModule { }
