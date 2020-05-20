import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { CartComponent } from './shopping/cart/cart.component';
import { BookMenuComponent } from './book/book-menu/book-menu.component';
import { BookItemEditComponent } from './book/book-item-edit/book-item-edit.component';
import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { LoginGuard } from './login.guard';
import { BookEditSuccessComponent } from './book-edit-success/book-edit-success.component';

const routes: Routes = [
  { path:'', component: BookMenuComponent},
  { path:'book-menu', component: BookMenuComponent, canActivate:[LoginGuard]},
  { path:'cart', component: CartComponent,canActivate:[LoginGuard]},
  { path:'book-item-edit/:bookId', component: BookItemEditComponent,canActivate:[LoginGuard]},
  { path: 'login', component: LoginComponent},
  { path:'signup', component: SignupComponent},
  { path: 'book-edit-success', component: BookEditSuccessComponent, canActivate:[LoginGuard]}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { 
  
}
