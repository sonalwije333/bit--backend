package com.bit.backend.controllers;

import com.bit.backend.dtos.SupplierDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.SupplierServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class SupplierController {
    private final SupplierServiceI supplierServiceI;

    public SupplierController(SupplierServiceI supplierServiceI) {
        this.supplierServiceI = supplierServiceI;
    }

    @PostMapping("/supplier")
    public ResponseEntity<SupplierDto> addForm(@RequestBody SupplierDto supplierDto) {
        try {
            SupplierDto supplierResponse = supplierServiceI.addSupplierEntity(supplierDto);
            return ResponseEntity.created(URI.create("/supplier" + supplierResponse.getSupplierName())).body(supplierResponse);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/supplier")
    public ResponseEntity<List<SupplierDto>> getData() {
        try {
            List<SupplierDto> supplierDtoList = supplierServiceI.getData();
            return ResponseEntity.ok(supplierDtoList);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/supplier/{id}")
    public ResponseEntity<SupplierDto> updateSupplier(@PathVariable long id, @RequestBody SupplierDto supplierDto) {
        try {
            SupplierDto responseSupplierDto = supplierServiceI.updateSupplier(id, supplierDto);
            return ResponseEntity.ok(responseSupplierDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/supplier/{id}")
    public ResponseEntity<SupplierDto> deleteSupplier(@PathVariable long id) {
        try {
            SupplierDto supplierDto = supplierServiceI.deleteSupplier(id);
            return ResponseEntity.ok(supplierDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
