import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BookEditSuccessComponent } from './book-edit-success.component';

describe('BookEditSuccessComponent', () => {
  let component: BookEditSuccessComponent;
  let fixture: ComponentFixture<BookEditSuccessComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BookEditSuccessComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BookEditSuccessComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
