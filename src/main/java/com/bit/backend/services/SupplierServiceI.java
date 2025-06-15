package com.bit.backend.services;

import com.bit.backend.dtos.SupplierDto;
import java.util.List;

public interface SupplierServiceI {
    SupplierDto addSupplierEntity(SupplierDto supplierDto);
    List<SupplierDto> getData();
    SupplierDto updateSupplier(long id, SupplierDto supplierDto);
    SupplierDto deleteSupplier(long id);
}