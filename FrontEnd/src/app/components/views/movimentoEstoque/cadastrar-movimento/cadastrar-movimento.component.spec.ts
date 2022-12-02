import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CadastrarMovimentoComponent } from './cadastrar-movimento.component';

describe('CadastrarMovimentoComponent', () => {
  let component: CadastrarMovimentoComponent;
  let fixture: ComponentFixture<CadastrarMovimentoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CadastrarMovimentoComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CadastrarMovimentoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
