import { Component, OnInit, Input, Output,EventEmitter } from '@angular/core';
import { LoginService } from 'src/app/login.service';
import { AuthenticationService } from 'src/app/authentication.service';


@Component({
  selector: 'app-book-item',
  templateUrl: './book-item.component.html',
  styleUrls: ['./book-item.component.css']
})
export class BookItemComponent implements OnInit {
  @Input() menuItem: any;
  @Output() editBookItem: any;
  @Output() addEvent:any;
  @Output() addAnonymous: any;
  userType:string;
  userName:string;
  id: any;
  constructor(private login: LoginService,private authService: AuthenticationService) {
    this.addEvent = new EventEmitter;
    this.editBookItem = new EventEmitter();
    this.addAnonymous = new EventEmitter();
  }
  getUserType(){
    this.userType=this.login.getType();
    return this.userType;
  }
  ngOnInit() {
  }
  addCart(id){
    let status = this.login.logStatus();
    if(status){
      this.id = id;
      this.addEvent.emit(id);
    }
    else{
      this.authService.authSource='cart';
      this.addAnonymous.emit();
    }
  }
  editBook(id){
    this.editBookItem.emit(id);
  }

}
