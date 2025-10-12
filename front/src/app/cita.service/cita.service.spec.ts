import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CitaService } from './cita.service';

describe('CitaService', () => {
  let component: CitaService;
  let fixture: ComponentFixture<CitaService>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CitaService]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CitaService);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
