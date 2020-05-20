import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ReactiveFormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BookItemComponent } from './book/book-item/book-item.component';
import { BookMenuComponent } from './book/book-menu/book-menu.component';
import { BookSearchComponent } from './book-search/book-search.component';
import { CartComponent } from './shopping/cart/cart.component';
import { BookItemEditComponent } from './book/book-item-edit/book-item-edit.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { BookHeaderComponent } from './book-header/book-header.component';
import { BookEditSuccessComponent } from './book-edit-success/book-edit-success.component';
import { DatePipe } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    BookItemComponent,
    BookMenuComponent,
    BookSearchComponent,
    CartComponent,
    BookItemEditComponent,
    LoginComponent,
    SignupComponent,
    BookHeaderComponent,
    BookEditSuccessComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [DatePipe],
  bootstrap: [AppComponent]
})
export class AppModule { }
