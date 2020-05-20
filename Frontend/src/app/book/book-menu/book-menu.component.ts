import { Component, OnInit } from '@angular/core';
import { BookService } from '../book.service';
import { CartService } from 'src/app/shopping/cart.service';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/login.service';

@Component({
  selector: 'app-book-menu',
  templateUrl: './book-menu.component.html',
  styleUrls: ['./book-menu.component.css']
})
export class BookMenuComponent implements OnInit {
  book:any;
  category:any;
  userType: string;
  userName: string;
  total:number;
  now: any;
  constructor(private bookItem: BookService, private cart: CartService, private router: Router,private login: LoginService) { }
  filteredBook: any;

  ngOnInit() {
    this.userType=this.login.getType();
    this.userName = this.login.getName();
    this.now = new Date(2019,12,12);
    this.bookItem.getAllMenuItems().subscribe((response)=>{this.book = response;
      this.filteredBook = this.book;
    });
    
  }
  searchBook($event){
    this.filteredBook = this.bookItem.getFilteredBook($event,this.book);
  }
  addEvent($event){
      this.cart.addCartItem($event).subscribe((response)=>{this.book = response;
    });
  }
  addAnonymous(){
    this.router.navigate(['login']);
  }
  editBook($event){
    this.router.navigate(['book-item-edit',$event]);
  }
}
