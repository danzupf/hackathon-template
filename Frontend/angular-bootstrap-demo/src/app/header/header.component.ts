import { Component, OnInit } from '@angular/core';
import {UserService} from '../Services/user.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private userService: UserService, private router: Router) { }

  ngOnInit(): void {

  }

  public logout(): void {
    this.userService.getAuth().subscribe(auth => {
      auth.signOut();
      this.router.navigateByUrl('/');
    });
  }
}
