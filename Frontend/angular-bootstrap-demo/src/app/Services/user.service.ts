import GoogleUser = gapi.auth2.GoogleUser;
import {GoogleAuthService} from 'ng-gapi';
import {Injectable} from '@angular/core';
import CurrentUser = gapi.auth2.CurrentUser;
import {Observable} from "rxjs";

@Injectable()
export class UserService {
  public static SESSION_STORAGE_KEY = 'accessToken';
  private user: GoogleUser;


  constructor(private googleAuth: GoogleAuthService){
  }

  public getToken(): string {
    const token: string = sessionStorage.getItem(UserService.SESSION_STORAGE_KEY);
    if (!token) {
      throw new Error('no token set , authentication required');
    }
    return sessionStorage.getItem(UserService.SESSION_STORAGE_KEY);
  }

  public signIn(): void {
    this.googleAuth.getAuth()
      .subscribe((auth) => {
        auth.signIn().then(res => this.signInSuccessHandler(res));
      });
  }

  public getAuth(): Observable<gapi.auth2.GoogleAuth>{

    return this.googleAuth.getAuth();

  }

  // tslint:disable-next-line:typedef
  private signInSuccessHandler(res: GoogleUser) {
    this.user = res;
    sessionStorage.setItem(
      UserService.SESSION_STORAGE_KEY, res.getAuthResponse().access_token
    );
  }

  logout() {

  }
}
