import { Component, OnInit } from '@angular/core';
import { BookService } from '../book.service';
import { Router, ActivatedRoute } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { DatePipe } from '@angular/common';
import { LoginService } from 'src/app/login.service';

@Component({
  selector: 'app-book-item-edit',
  templateUrl: './book-item-edit.component.html',
  styleUrls: ['./book-item-edit.component.css']
})
export class BookItemEditComponent implements OnInit {
  book: any;
  myForm: FormGroup;
  date: string;
  filteredBook: any;
  userType: String;
  userName: String;
  constructor(private bookService: BookService, private router: Router, private routers: ActivatedRoute,private datePipe: DatePipe,private loginService: LoginService) { 
    this.myForm = new FormGroup({
      'id': new FormControl(''),
      'name': new FormControl(
        '', [Validators.required, Validators.minLength(2), Validators.maxLength(20)]),
      'price': new FormControl(
        '', [Validators.required]),
      'dateOfPublication': new FormControl(
        '', [Validators.pattern("^(1[0-2]|0[1-9])/(3[01]"+ "|[12][0-9]|0[1-9])/[0-9]{4}$"),Validators.required]),
      'available': new FormControl(
        '', [Validators.required]),
      'delivery': new FormControl(
          '', [Validators.required]),
      'category': new FormControl('', [Validators.required])
      //'image': new FormControl('')
    })
  }

  ngOnInit() {
    this. userType = this.loginService.getType();
    this.userName = this.loginService.getName();
    this.routers.paramMap.subscribe(params => {
      
      this.bookService.getMenuItem(params.get('bookId')).subscribe((response)=>{
        this.book = response;
        this.date = this.datePipe.transform(this.book.dateOfPublication,'yyyy-MM-dd');
        this.myForm = new FormGroup({
          'id': new FormControl(this.book.id),
          'name': new FormControl(
            this.book.name, [Validators.required, Validators.minLength(2), Validators.maxLength(20)]),
          'price': new FormControl(
            this.book.price, [Validators.required]),
          'dateOfPublication': new FormControl(
            this.date, [Validators.required]),
          'available': new FormControl(
            this.book.available, [Validators.required]),
          'delivery': new FormControl(
              this.book.freeDelivery, [Validators.required]),
          'category': new FormControl(this.book.category, [Validators.required])
          //'image': new FormControl(this.book.image)
        })
    });
    })
  }
  onsend(myForm: any) {
    this.bookService.editBookItem(myForm).subscribe((response)=>this.book = response);
    this.router.navigate(['book-edit-success']);
  }
}
