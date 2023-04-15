import { JobApp } from 'src/app/models/job-app';
import { JobAppService } from './../../services/job-app.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  jobApps: JobApp[]= [];

  constructor(
    private jobappService:JobAppService
  ){


  }
  ngOnInit(): void {
    this.reload();
  }

  reload(){
    this.jobappService.index().subscribe({
      next: (data) => {
        this.jobApps = data;
      },
      error:(fail)=>{
        console.log(fail);

      }
     })
  }

}
