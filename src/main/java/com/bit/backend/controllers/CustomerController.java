package com.bit.backend.controllers;

import com.bit.backend.dtos.CustomerDto;
import com.bit.backend.dtos.FormDemoDto;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.services.CustomerServiceI;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class CustomerController {
    private final CustomerServiceI customerServiceI;

    public CustomerController(CustomerServiceI customerServiceI) {
        this.customerServiceI = customerServiceI;
    }
    @PostMapping("/customer")
    public ResponseEntity<CustomerDto> addForm(@RequestBody CustomerDto customerDto) {

        try {
            CustomerDto customerDtoResponse = customerServiceI.addCustomerEntity(customerDto);
            return ResponseEntity.created(URI.create("/customer" + customerDtoResponse.getFirstName())).body(customerDtoResponse);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + 0, HttpStatus.INTERNAL_SERVER_ERROR );
        }
    }

    @GetMapping("/customer")
    public ResponseEntity<List<CustomerDto>> getData(){
        /* controlller -> service (interface) -> repository*/
        /* DTO , Entity , Mapper */

        try{
            List<CustomerDto>  customerDtoList = customerServiceI.getData();
            return ResponseEntity.ok(customerDtoList);
        } catch (Exception e){
            throw new AppException("Request failed with error: " + 0, HttpStatus.INTERNAL_SERVER_ERROR );
        }
    }

    @PutMapping("/customer/{id}")
    public ResponseEntity <CustomerDto> updateCustomer( @PathVariable long id , @RequestBody  CustomerDto customerDto) {

        try{
            CustomerDto responseCustomerDto  =  customerServiceI.updateCustomer(id,customerDto);
            return ResponseEntity.ok(responseCustomerDto);

        } catch (Exception e){

            throw new AppException("Request failed with error: " + 0, HttpStatus.INTERNAL_SERVER_ERROR );
        }}

    @DeleteMapping("/customer/{id}")
    public ResponseEntity<CustomerDto> deleteCustomer(@PathVariable long id) {

        try{
            CustomerDto customerDto = customerServiceI.deleteCustomer(id);
            return ResponseEntity.ok(customerDto); // Ensure a proper response is returned

        } catch (Exception e) {
            throw new AppException("Request failed with error: " + 0, HttpStatus.INTERNAL_SERVER_ERROR);

        }}




}
