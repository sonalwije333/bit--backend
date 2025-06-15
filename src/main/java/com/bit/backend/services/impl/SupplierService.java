package com.bit.backend.services.impl;
import com.bit.backend.dtos.SupplierDto;
import com.bit.backend.entities.SupplierEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.SupplierMapper;
import com.bit.backend.repositories.SupplierRepository;
import com.bit.backend.services.SupplierServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService implements SupplierServiceI {

    private final SupplierRepository supplierRepository;
    private final SupplierMapper supplierMapper;

    public SupplierService(SupplierRepository supplierRepository, SupplierMapper supplierMapper) {
        this.supplierRepository = supplierRepository;
        this.supplierMapper = supplierMapper;
    }

    @Override
    public SupplierDto addSupplierEntity(SupplierDto supplierDto) {
        try {
            SupplierEntity supplierEntity = supplierMapper.toSupplierEntity(supplierDto);
            SupplierEntity savedSupplier = supplierRepository.save(supplierEntity);
            return supplierMapper.toSupplierDto(savedSupplier);
        } catch (Exception e) {
            throw new AppException("Failed to add supplier", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<SupplierDto> getData() {
        try {
            List<SupplierEntity> supplierEntityList = supplierRepository.findAll();
            List<SupplierDto> supplierDtoList = supplierMapper.toSupplierDtoList(supplierEntityList);
            return supplierDtoList;
        } catch (Exception e) {
            throw new AppException("Failed to retrieve suppliers", HttpStatus.INTERNAL_SERVER_ERROR);
        }}

    @Override
    public SupplierDto updateSupplier(long id, SupplierDto supplierDto) {
        try {
            Optional<SupplierEntity> optionalSupplierEntity = supplierRepository.findById(id);
            if (!optionalSupplierEntity.isPresent()) {
                throw new AppException("Supplier does not exist", HttpStatus.BAD_REQUEST);
            }
            SupplierEntity newsupplierEntity = supplierMapper.toSupplierEntity(supplierDto);
            SupplierEntity supplierEntity = supplierRepository.save(newsupplierEntity);
            SupplierDto responseSupplierDto = supplierMapper.toSupplierDto(supplierEntity);
            return responseSupplierDto;
        } catch (Exception e) {
            throw new AppException("Failed to update supplier", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Override
    public SupplierDto deleteSupplier(long id) {
        try {
            Optional<SupplierEntity> optionalSupplier = supplierRepository.findById(id);
            if (!optionalSupplier.isPresent()) {
                throw new AppException("Supplier does not exist", HttpStatus.BAD_REQUEST);
            }
            supplierRepository.deleteById(id);
            return supplierMapper.toSupplierDto(optionalSupplier.get());
        } catch (Exception e) {
            throw new AppException("Failed to delete supplier", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
