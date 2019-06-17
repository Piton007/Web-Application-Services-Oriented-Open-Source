import { TestBed } from '@angular/core/testing';

import { RepuestoProvAlmService } from './repuesto-prov-alm.service';

describe('RepuestoProvAlmService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: RepuestoProvAlmService = TestBed.get(RepuestoProvAlmService);
    expect(service).toBeTruthy();
  });
});
