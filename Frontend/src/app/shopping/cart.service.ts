import { Injectable } from '@angular/core';
import { Cart } from './cart';
import { AuthenticationService } from '../authentication.service';
import { HttpHeaders, HttpClient } from '@angular/common/http';
import { LoginService } from '../login.service';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  cart: Cart[];
  user: any;
  food: any;
  menuItemId: number;
  total: number = 0;
  constructor(private authenticationService: AuthenticationService,private login: LoginService, private httpService: HttpClient,private loginService: LoginService) {
    
  }
  
  getAllCartItems() {
    let token = 'Bearer '+ this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': "application/json",
        "Authorization": token
      })  
    };
    this.user = this.login.getName();
    return this.httpService.get(environment.baseUrl+"cart-items/"+this.user,httpOptions);
  }
  
  removeFromCart(id) {
    let token = 'Bearer '+ this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': "application/json",
        "Authorization": token
      })  
    };
    this.user = this.login.getName();
    return this.httpService.delete(environment.baseUrl+"cart-items/"+this.user+"/"+id,httpOptions);
  }
  
  addCartItem(cartId) {
    let token = 'Bearer '+ this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': "application/json",
        "Authorization": token
      })
    };
    this.menuItemId = cartId;
    this.user = this.loginService.getName();
    return this.httpService.post(environment.baseUrl+"cart-items/"+this.user+"/"+this.menuItemId,{},httpOptions);

  }
}
