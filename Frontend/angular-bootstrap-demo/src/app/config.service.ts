import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class ConfigService {
  // this service not yet used in example

  constructor(private http: HttpClient) { }
  configUrl = '://api.npms.io/v2/search?q=scope:angular';
  totalAngularPackages;



  getConfig() {
    return this.http.get<any>(this.configUrl);
  }



}
