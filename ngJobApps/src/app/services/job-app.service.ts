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
}
