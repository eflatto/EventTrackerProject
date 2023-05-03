import { JobApp } from 'src/app/models/job-app';
import { JobAppService } from './../../services/job-app.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent {
  constructor(private jobappService:JobAppService){

  }
  jobApps: JobApp[]= [];
  selected: JobApp | null = null;
  newJobApp: JobApp = new JobApp();
  editJobApp: JobApp | null = null;
  showComplete: boolean = false;
  ngOnInit(): void {
    this.reload();
  }

  reload(){
    this.jobappService.getJobsByUser().subscribe({
      next: (data) => {
        this.jobApps = data;
      },
      error:(fail)=>{
        console.log(fail);

      }
     })
  }
  setSelectedJobApp(jobApp: JobApp) {
    this.editJobApp = jobApp;

  }

  updateJobApp(todo: JobApp, goToDetail = true) {
    console.log(todo);
    this.jobappService.update(todo).subscribe({
      next: (updatedTodo) => {
        this.editJobApp = null;
          this.selected = updatedTodo;
        this.reload();
      },
      error: (kaboom) => {
        console.error('Error updating Todo');
        console.error(kaboom);
      },
    });
  }
  addJobApp(jobApp: JobApp) {
    this.jobappService.create(jobApp).subscribe({
      next: (createdTodo) => {
        console.log(createdTodo);
        this.newJobApp = new JobApp();
        // this.selected = createdTodo;
        this.reload();
      },
      error: (fail) => {
        console.error('Error creating todo');
        console.error(fail);
      },
    });

    console.log('todoService.create() called.');
  }



  deleteJobApp(id: number) {
    this.jobappService.destroy(id).subscribe({
      next: () => {
        this.reload();
      },
      error: (myBad) => {
        console.error('Error deleting Todo');
        console.error(myBad);
      },
    });
  }
}
