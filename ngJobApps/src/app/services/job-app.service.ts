import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { JobApp } from '../models/job-app';

@Injectable({
  providedIn: 'root'
})
export class JobAppService {
  private baseUrl = 'http://localhost:8085/';
  private url = this.baseUrl + 'api/jobapplications'
  constructor(
    private http:HttpClient
  ) { }

  index(): Observable<JobApp[]> {
    return this.http.get<JobApp[]>(this.url).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('JobApp.index(): error retrieving pokemon: ' + err)
        );
      })
    );
  }

  public create(jobApp: JobApp): Observable<JobApp> {
    // todo.completed = false;
    // todo.description = '';
    return this.http.post<JobApp>(this.url, jobApp).pipe(
      catchError((err: any) => {
        console.error(err);
        return throwError(
          () =>
            new Error('JobAppService.create(): error creating Product: ' + err)
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
            new Error('TodoService.create(): error creating Product: ' + err)
        );
      })
    );

  }
  show(todoId:number): Observable<JobApp> {

    return this.http.get<JobApp>(this.url + "/" +todoId ).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('TodoService.index(): error retrieving Todos: ' + err)
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
            new Error('TodoService.destroy(): error destroying todo: ' + err)
        );
      })
    );

  }


}
