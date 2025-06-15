package com.bit.backend.mappers;


import com.bit.backend.dtos.SupplierDto;
import com.bit.backend.entities.SupplierEntity;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", builder = @Builder(disableBuilder = true))
public interface SupplierMapper {
    SupplierDto toSupplierDto(SupplierEntity supplierEntity);
    SupplierEntity toSupplierEntity(SupplierDto supplierDto);
    List<SupplierDto> toSupplierDtoList(List<SupplierEntity> supplierEntityList);
}