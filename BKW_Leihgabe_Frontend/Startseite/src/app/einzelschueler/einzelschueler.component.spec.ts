import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EinzelschuelerComponent } from './einzelschueler.component';

describe('EinzelschuelerComponent', () => {
  let component: EinzelschuelerComponent;
  let fixture: ComponentFixture<EinzelschuelerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EinzelschuelerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EinzelschuelerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
