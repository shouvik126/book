import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthenticationService } from '../authentication.service';
import { ActivatedRoute } from '@angular/router';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class BookService {
  book: any;
  category: any;
  filteredBook: any;

  constructor(private httpService: HttpClient, private authenticationService: AuthenticationService, private routers: ActivatedRoute) {
  }
  getAllMenuItems(){
    let token = 'Bearer '+ this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': "application/json",
        "Authorization": token
      })
    }
    return this.httpService.get<any>(environment.baseUrl+'menu-items',httpOptions);
  }
  getMenuItem(id){
    let token = 'Bearer '+ this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': "application/json",
        "Authorization": token
      })
    }
    return this.httpService.get<any>(environment.baseUrl+'menu-items/'+id,httpOptions);
  }
  editBookItem(myForm){
    let token = 'Bearer '+ this.authenticationService.getToken();
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': "application/json",
        "Authorization": token
      })  
    };
    let edit = {
      id:myForm.value.id,
      name:myForm.value.name,
      price:myForm.value.price,
      available:myForm.value.available,
      category:myForm.value.category,
      dateOfPublication:new Date(myForm.value.dateOfPublication),
      freeDelivery:myForm.value.delivery
      //image:myForm.value.image
    }
    return this.httpService.put<any>(environment.baseUrl+'menu-items/',edit,httpOptions);
  }
  getFilteredBook(searchString,bookItems){
    let filter = searchString.toLocaleLowerCase();
    this.filteredBook = bookItems.filter(
      (bookItems: any)=> bookItems.name.toLocaleLowerCase().indexOf(filter) != -1
    );
    return this.filteredBook;
  }
}
