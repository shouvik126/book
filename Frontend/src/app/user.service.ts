import { Injectable } from '@angular/core';
import { User } from './user';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  user: User[];
  constructor(private httpService: HttpClient) { 
    this.user = [
      {userName:'asd',firstName:'asd',lastName:'asd',password:'asd'}
    ]
  }
  getUser(){
    return this.user;
  }
  addUser(form: User){ 
    let user = {
      userName: form.userName,
      firstName: form.firstName,
      lastName: form.lastName,
      password: form.password
    }
    return this.httpService.post(environment.baseUrl+"users",user);
  }
}
