import { TestBed } from '@angular/core/testing';

import { MovEstoqueService } from './movEstoque.service';

describe('MovEstoqueService', () => {
  let service: MovEstoqueService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MovEstoqueService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
