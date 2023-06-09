import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {
constructor(private auth: AuthService, private router: Router) { }

  loginUser: User = new User();

  login(user: User) {
    console.log('Logging in:');
    console.log(user);

    this.auth.login(user.username, user.password).subscribe({

      next: (loggedInUser) => {

        console.log(loggedInUser);
        this.router.navigateByUrl('/profile');
      },
      error: (problem) => {

        console.log(user);
        console.error('Error logging in user:');
        console.error(problem);
      }
    })
  }



}
