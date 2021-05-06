import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  text;
  constructor(private http: HttpClient, private router: Router) { }

  public ngOnInit(): void {
    // this.http.get<SearchResults>('http://localhost:8080/employee/getTreeCount/1').subscribe(data => {
     // this.text = data;
   // });
  }

  public addTrip()
  {
    this.router.navigateByUrl('/add-trip');
  }

}
