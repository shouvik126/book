import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl } from '@angular/forms';
import { Router } from '@angular/router';
import { LoginService } from '../login.service';
import { AuthenticationService } from '../authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  login: any;
  myForm: FormGroup;
  value: boolean=false;
  status: number;
  userType:string;
  userName:string;
  authSource:string=null;
  constructor(private router: Router,private authService: AuthenticationService,private loginStatus: LoginService) { }

  ngOnInit() {
    this.authSource=this.authService.authSource;
   this.myForm = new FormGroup({
    'login': new FormControl(),
    'password': new FormControl()
   })
  }
  validate(myForm){
    this.authService.authenticate(myForm.value.login, myForm.value.password).subscribe((response)=>{
      if(myForm.value.login == 'admin'){
        this.status = this.status + 1;
        this.userType = 'admin';
      }
      else{
        this.userType = 'customer';
      }
      this.authService.setToken(response.token);
      this.loginStatus.logIn(this.userType,myForm.value.login);
      this.router.navigate(['book-menu']);
    },
    (error)=>{
      this.status = 5;
      error = "Invalid UserName/Password";
      console.log(error);
    });
    
  }
}
