import { Component, OnInit, Output,EventEmitter } from '@angular/core';
import { BookService } from '../book/book.service';

@Component({
  selector: 'app-book-search',
  templateUrl: './book-search.component.html',
  styleUrls: ['./book-search.component.css']
})
export class BookSearchComponent implements OnInit {
  book: any;
  filteredBook: any;
  searchBook: string = '';
  @Output() changedBookList:any;
  constructor(private bookService: BookService) {
    this.changedBookList = new EventEmitter;
  }

  ngOnInit() { 
    this.book = this.bookService.getAllMenuItems();
    this.filteredBook = this.book;
  }

  filterData(){
    this.changedBookList.emit(this.searchBook,this.book);
  }

}
