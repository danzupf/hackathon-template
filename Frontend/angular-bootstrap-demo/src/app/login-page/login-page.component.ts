import { Component, OnInit } from '@angular/core';
import {UserService} from "../Services/user.service";
import CurrentUser = gapi.auth2.CurrentUser;
import GoogleUser = gapi.auth2.GoogleUser;
import GoogleAuth = gapi.auth2.GoogleAuth;
import {Router} from "@angular/router";

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  public auth: GoogleAuth;
  public user: GoogleUser;
  constructor(private userService: UserService,
              private router: Router) { }

  ngOnInit(): void {
    this.userService.getAuth().subscribe((auth) => {
        this.auth = auth;
        this.user = this.auth.currentUser.get();
    });
  }

  public login(): void {
    this.userService.signIn();
    this.userService.getAuth().subscribe((auth) => {
      this.auth = auth;
      this.user = this.auth.currentUser.get();
      this.router.navigateByUrl('home');
    });
  }
}
