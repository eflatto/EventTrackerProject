import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-nav',
  templateUrl: './nav.component.html',
  styleUrls: ['./nav.component.css']
})
export class NavComponent {

  // constructor(
  //   private auth: AuthService,
  //   private router: Router
  // ){}

  // logout() {
  //   this.auth.logout();
  //   this.router.navigateByUrl('/home');
  // }
}
