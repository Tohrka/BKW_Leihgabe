import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SchuelerComponent } from './schueler.component';

describe('SchuelerComponent', () => {
  let component: SchuelerComponent;
  let fixture: ComponentFixture<SchuelerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SchuelerComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SchuelerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
