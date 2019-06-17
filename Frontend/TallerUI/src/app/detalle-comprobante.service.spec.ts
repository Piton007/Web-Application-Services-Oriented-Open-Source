import { TestBed } from '@angular/core/testing';

import { DetalleComprobanteService } from './detalle-comprobante.service';

describe('DetalleComprobanteService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: DetalleComprobanteService = TestBed.get(DetalleComprobanteService);
    expect(service).toBeTruthy();
  });
});
