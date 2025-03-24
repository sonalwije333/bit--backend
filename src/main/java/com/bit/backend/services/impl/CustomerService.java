package com.bit.backend.services.impl;

import com.bit.backend.dtos.CustomerDto;
import com.bit.backend.entities.CustomerEntity;
import com.bit.backend.entities.FormDemoEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.CustomerMapper;
import com.bit.backend.mappers.FormDemoMapper;
import com.bit.backend.repositories.CustomerRepository;

import com.bit.backend.services.CustomerServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService  implements CustomerServiceI {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;


    // Constructor for dependency injection
    public CustomerService(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }


    @Override
    public CustomerDto addCustomerEntity(CustomerDto customerDto) {
        try{
            System.out.println("*******In Backend*******");
            // Convert DTO to Entity
            CustomerEntity customerEntity = customerMapper.toCustomerEntity(customerDto);
            // Save entity to repository
            CustomerEntity savedItem = customerRepository.save(customerEntity);
            // Convert Entity back to DTO
            return customerMapper.toCustomerDto(savedItem);
        } catch (Exception e){
            throw new AppException("Request failed with error " + 0, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @Override
    public List<CustomerDto> getData() {
        return List.of();
    }

    @Override
    public CustomerDto updateCustomerEntity(long id, CustomerDto customerDto) {
        return null;
    }

    @Override
    public CustomerDto deleteCustomer(long id) {
        return null;
    }
}
