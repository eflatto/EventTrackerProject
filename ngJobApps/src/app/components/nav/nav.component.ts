import { User } from './../../models/user';
import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent {

  constructor(
    private auth: AuthService,
    private router: Router
  ){}
    loggedInUser :User = new User();
  // logout() {
  //   this.auth.logout();
  //   this.router.navigateByUrl('/home');
  // }

  ngOnInIt():void{
    this.verifyUser();
  }
  isAdmin(): boolean {
    return this.loggedInUser && this.loggedInUser.username === 'admin';
  }

  loggedIn():boolean{
    return this.auth.checkLogin();

  }
  verifyUser(): void{
    this.auth.getLoggedInUser().subscribe({
      next: (user: User) => {
        this.loggedInUser = user;
      },
      error: (nojoy) => {
        console.log(nojoy);
      }

     });
    }

}
