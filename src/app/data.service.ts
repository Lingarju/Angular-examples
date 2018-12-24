import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '../../node_modules/@angular/common/http';
import { Observable } from '../../node_modules/rxjs';
import { Student } from '../Student';

@Injectable({
  providedIn: 'root'
})
export class DataService {
  private studentUrl = 'http://localhost:8086/student';
  private headers = new HttpHeaders({'Content-Type': 'application/json'});
  constructor(private http: HttpClient) { }
  getAllStudents(): Observable<any> {
    return this.http.get<any>(`${this.studentUrl}/getstudents`);
  }
  registerStudent(): Observable<any> {

    return this.http
      .post(`${this.studentUrl}/insert`, JSON.stringify(Student), {headers: this.headers});
  }
}
