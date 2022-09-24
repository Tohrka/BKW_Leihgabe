import { ComponentFixture, TestBed } from '@angular/core/testing';

import { KlassenComponent } from './klassen.component';

describe('KlassenComponent', () => {
  let component: KlassenComponent;
  let fixture: ComponentFixture<KlassenComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ KlassenComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(KlassenComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
