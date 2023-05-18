import { TestBed } from '@angular/core/testing';

import { GetCongeService } from './get-conge.service';

describe('GetCongeService', () => {
  let service: GetCongeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GetCongeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
