package com.bit.backend.controllers;
import com.bit.backend.dtos.ItemRegistrationDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.ItemRegistrationServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
@RestController
public class ItemRegistrationController {

    private final ItemRegistrationServiceI itemRegistrationServiceI;

    public ItemRegistrationController(ItemRegistrationServiceI itemRegistrationServiceI) {
        this.itemRegistrationServiceI = itemRegistrationServiceI;
    }

    @PostMapping("/item")
    public ResponseEntity<ItemRegistrationDto> addForm(@RequestBody ItemRegistrationDto itemRegistrationDto) {
        try {
            ItemRegistrationDto itemRegistrationResponse = itemRegistrationServiceI.addItemRegistrationEntity(itemRegistrationDto);
            return ResponseEntity.created(URI.create("/item" + itemRegistrationResponse.getItemName())).body(itemRegistrationResponse);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/item")
    public ResponseEntity<List<ItemRegistrationDto>> getData() {
        try {
            List<ItemRegistrationDto> itemRegistrationDtoList = itemRegistrationServiceI.getData();
            return ResponseEntity.ok(itemRegistrationDtoList);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/item/{id}")
    public ResponseEntity<ItemRegistrationDto> updateItemRegistration(@PathVariable long id, @RequestBody ItemRegistrationDto itemRegistrationDto) {
        try {
            ItemRegistrationDto responseItemRegistrationDto = itemRegistrationServiceI.updateItemRegistration(id, itemRegistrationDto);
            return ResponseEntity.ok(responseItemRegistrationDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/item/{id}")
    public ResponseEntity<ItemRegistrationDto> deleteItemRegistration(@PathVariable long id) {
        try {
            ItemRegistrationDto itemRegistrationDto = itemRegistrationServiceI.deleteItemRegistration(id);
            return ResponseEntity.ok(itemRegistrationDto);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
