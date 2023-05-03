import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { JobApp } from '../models/job-app';
import { environment } from 'src/environments/environment';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class JobAppService {

  // private baseUrl = 'http://localhost:8085/';
  private url = environment.baseUrl + 'api/jobapplications'
  private urlUser = environment.baseUrl + 'api/users'
  constructor(
    private http:HttpClient,
    private auth:AuthService
  ) { }
  getHttpOptions() {
    let options = {
      headers: {
        Authorization: 'Basic ' + this.auth.getCredentials(),
        'X-Requested-With': 'XMLHttpRequest',
      },
    };
    return options;
  }

  index(): Observable<JobApp[]> {
    return this.http.get<JobApp[]>(this.url, this.getHttpOptions()).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('JobApp.index(): error retrieving jobs: ' + err)
        );
      })
    );
  }
  getJobsByUser(): Observable<JobApp[]> {
    return this.http.get<JobApp[]>(this.urlUser+"/apps", this.getHttpOptions()).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('JobApp.index(): error retrieving jobs: ' + err)
        );
      })
    );
  }

   create(jobApp: JobApp): Observable<JobApp> {
    // todo.completed = false;
    // todo.description = '';
    return this.http.post<JobApp>(this.url, jobApp,this.getHttpOptions()).pipe(
      catchError((err: any) => {
        console.error(err);
        return throwError(
          () =>
            new Error('JobAppService.create(): error creating job: ' + err)
        );
      })
    );
  }



  update(jobApp: JobApp): Observable<JobApp> {
    // if(jobApp.completed){
    //   jobApp.completeDate=this.datePipe.transform(Date.now()),'shortDate';
    // }
    return this.http.put<JobApp>(this.url +"/"+ jobApp.id, jobApp).pipe(
      catchError((err: any) => {
        console.error(err);
        return throwError(
          () =>
            new Error('JJobAppService.create(): error updating job: ' + err)
        );
      })
    );

  }
  show(todoId:number): Observable<JobApp> {

    return this.http.get<JobApp>(this.url + "/" +todoId ).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('JobAppService.index(): error retrieving job: ' + err)
        );
      })
    );
  }
  destroy(todoId: number) : Observable<void>{

   return this.http.delete<void>(this.url+"/"+todoId).pipe(
      catchError((err: any) => {
        console.error(err);
        return throwError(
          () =>
            new Error('JobAppService.destroy(): error destroying job: ' + err)
        );
      })
    );

  }


}
