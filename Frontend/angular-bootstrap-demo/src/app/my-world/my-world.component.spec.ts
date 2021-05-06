import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MyWorldComponent } from './my-world.component';

describe('MyWorldComponent', () => {
  let component: MyWorldComponent;
  let fixture: ComponentFixture<MyWorldComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MyWorldComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MyWorldComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
