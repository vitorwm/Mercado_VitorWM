import { ComponentFixture, TestBed } from '@angular/core/testing';
import { ListarPorTipoComponent } from './listar-por-tipo.component';

describe('ListarPorTipoComponent', () => {
  let component: ListarPorTipoComponent;
  let fixture: ComponentFixture<ListarPorTipoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListarPorTipoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListarPorTipoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
