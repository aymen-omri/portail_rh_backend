import { TestBed } from '@angular/core/testing';

import { NewCompteService } from './new-compte.service';

describe('NewCompteService', () => {
  let service: NewCompteService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(NewCompteService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
