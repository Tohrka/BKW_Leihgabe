import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EinzelklasseComponent } from './einzelklasse.component';

describe('EinzelklasseComponent', () => {
  let component: EinzelklasseComponent;
  let fixture: ComponentFixture<EinzelklasseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EinzelklasseComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EinzelklasseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
