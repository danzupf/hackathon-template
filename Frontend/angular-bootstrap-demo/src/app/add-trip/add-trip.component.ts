import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import GoogleAuth = gapi.auth2.GoogleAuth;
import GoogleUser = gapi.auth2.GoogleUser;
import {UserService} from '../Services/user.service';

@Component({
  selector: 'app-add-trip',
  templateUrl: './add-trip.component.html',
  styleUrls: ['./add-trip.component.css']
})
export class AddTripComponent implements OnInit {

  public auth: GoogleAuth;
  public user: GoogleUser;
  public transportMode: string;

  public tranportModes = ['Auto', 'Fahrgemeinschaft', 'Bus', 'Flugzeug', 'Boot', 'Zug', 'CO²-Neutral'];
  public distance: number;
  constructor(private router: Router, private userService: UserService) { }

  ngOnInit(): void {
    this.userService.getAuth().subscribe((auth) => {
      this.auth = auth;
      this.user = this.auth.currentUser.get();
    });
  }

  public addTrip(): void {
      const email = this.user.getBasicProfile().getEmail();
      console.log(email + ': ' + this.distance + ' mit ' + this.transportMode);
      this.router.navigateByUrl('home');
  }

}
