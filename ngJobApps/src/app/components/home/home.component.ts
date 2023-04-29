import { JobApp } from 'src/app/models/job-app';
import { JobAppService } from './../../services/job-app.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  //////////// FIELDS/PROPERTIES //////////////////

  // title: String = 'ngTodo';
  jobApps: JobApp[]= [];
 selected: JobApp | null = null;
 newJobApp: JobApp = new JobApp();
 editJobApp: JobApp | null = null;
 showComplete: boolean = false;
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




  // getTodoCount(): number {
  //   return this.incompletePipe.transform(this.todos, false).length;
  // }

  // getTodoStyle(): string {
  //   let count = this.getTodoCount();
  //   if (count >= 10) {
  //     return 'bg bg-danger';
  //   } else if (count >= 5) {
  //     return 'bg bg-warning';
  //   } else {
  //     return 'bg bg-success';
  //   }
  // }
  setSelectedJobApp(jobApp: JobApp) {
    this.editJobApp = jobApp;

  }

  displayTable(): void {
    this.selected = null;
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
