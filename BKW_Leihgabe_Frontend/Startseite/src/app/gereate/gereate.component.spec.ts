import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GereateComponent } from './gereate.component';

describe('GereateComponent', () => {
  let component: GereateComponent;
  let fixture: ComponentFixture<GereateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GereateComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GereateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
