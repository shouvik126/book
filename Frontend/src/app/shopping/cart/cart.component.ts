import { Component, OnInit } from '@angular/core';
import { CartService } from '../cart.service';
import { Cart } from '../cart';
import { LoginService } from 'src/app/login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {
  cart: Cart[];
  total: number;
  status: number = 0;
  error: String;
  constructor(private cartService: CartService,private login: LoginService,private router: Router) {}
 
  ngOnInit() {
    this.total = 0;
    this.error = '';
    this.cartService.getAllCartItems().subscribe((response)=>{
      this.cart = response['bookDetailsList'];
      this.total = response['total'];
    });
    

  }
  
  deleteCartItem(cartId){
    this.total = 0;
    this.cartService.removeFromCart(cartId).subscribe((response)=>{
      this.status = 0;
      this.status++;
      this.cartService.getAllCartItems().subscribe(
        (response)=>{
          this.cart = response['bookDetailsList'];
          this.total = response['total'];
        },(error)=>{
          this.error = error.error.errorDescription;
        }
      )
    });
  }
  logOut(){
    this.login.logOut();
    this.router.navigate(['book-menu']);
  }
}
