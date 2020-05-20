import { Component, OnInit } from '@angular/core';
import { LoginService } from '../login.service';
import { CartService } from '../shopping/cart.service';
import { Router } from '@angular/router';
import { AuthenticationService } from '../authentication.service';

@Component({
  selector: 'app-book-header',
  templateUrl: './book-header.component.html',
  styleUrls: ['./book-header.component.css']
})
export class BookHeaderComponent implements OnInit {
  userType: any;
  userName: any;
  total: any;
  constructor(private login: LoginService,private cart: CartService, private router: Router,private authService: AuthenticationService) { }

  ngOnInit() {
  }
  logOut(){
    this.login.logOut();
    this.authService.setToken('');
    this.userType=this.login.getType();
    this.userName = this.login.getName();
    this.router.navigate(['']);
  }
  getUserType(){
    return this.login.getType();
  }
  getUserName(){
    return this.login.getName();
  }
}
