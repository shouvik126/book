import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { UserService } from '../user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {
  myForm: FormGroup;
  status: number = 0;
  error: any = '';
  passwordError : boolean;
 
  constructor(private userService: UserService, private router: Router) { 
    this.myForm = new FormGroup({
      'userName' : new FormControl('',[Validators.required]),
      'firstName' : new FormControl('',[Validators.required]),
      'lastName' : new FormControl('',[Validators.required]),
      'password' : new FormControl('',[Validators.required]),
      'confirmPassword' : new FormControl('',[Validators.required])
    })
  }

  ngOnInit() {
  }
  addUser(myForm){
    this.passwordError = false;
    if(myForm.value.password != myForm.value.confirmPassword){
      this.passwordError = true;
    }
    else{
    this.userService.addUser(myForm.value).subscribe((response)=>{
      this.router.navigate(['/login']);
    },
    (error)=>{
      this.error = error.error.errorMessage;
    });
  }
}
}
