import { Component, OnInit } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  text;
  constructor(private http: HttpClient) { }

  ngOnInit() {
    this.http.get<SearchResults>('http://localhost:8080/employee/getTreeCount/1').subscribe(data => {
      this.text = data;
    });
  }


}

interface SearchResults {
  total: number;
  results: Array<object>;
}
