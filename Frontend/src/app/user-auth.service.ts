import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthenticationService } from './authentication.service';

@Injectable({
  providedIn: 'root'
})
export class UserAuthService {

  constructor(private httpService: HttpClient, private authenticationService: AuthenticationService) { }

/*  getAllStudents(){
    let token = 'Bearer '+this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': "application/json",
        "Authorization": token
      })
    }
    return this.httpService.get<any>('http://localhost:8090/book/menu-items',httpOptions);
  }
  getaStudent(){
    let token = 'Bearer '+this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': "application/json",
        "Authorization": token
      })
    }
    return this.httpService.get<any>('http://localhost:8090/book/menu-items/{id}',httpOptions);
  }
  update(studentUpdate: any){
    let token = 'Bearer '+this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': "application/json",
        "Authorization": token
      })
    }
    return this.httpService.put<any>('http://localhost:8090/api/students',studentUpdate,httpOptions);
  }*/
}
