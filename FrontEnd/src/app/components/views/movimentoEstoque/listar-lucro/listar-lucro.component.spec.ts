import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListarLucroComponent } from './listar-lucro.component';

describe('ListarLucroComponent', () => {
  let component: ListarLucroComponent;
  let fixture: ComponentFixture<ListarLucroComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListarLucroComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarLucroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
