import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  userType: string = 'anonymous';
  userName: string = 'anonymous';
  constructor() { }
  loggedIn: boolean = false;
  logIn(type,name){
    this.userType = type;
    this.userName = name;
    this.loggedIn = true;
  }
  logOut(){
    this.userType = "anonymous";
    this.userName = "anonymous";
    this.loggedIn = false;
  }
  logStatus(){
    return this.loggedIn;
  }
  getName(){
    return this.userName;
  }
  getType(){
    return this.userType;
  }
}
