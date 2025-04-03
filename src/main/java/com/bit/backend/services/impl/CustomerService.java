package com.bit.backend.services.impl;

import com.bit.backend.dtos.CustomerDto;
import com.bit.backend.entities.CustomerEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.CustomerMapper;
import com.bit.backend.repositories.CustomerRepository;

import com.bit.backend.services.CustomerServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
        try{
            List<CustomerEntity> customerEntityList = customerRepository.findAll();
            List<CustomerDto> customerDtoList =  customerMapper.toCustomerDtoList(customerEntityList);
            return customerDtoList;

        } catch (Exception e){
            throw new AppException("Request failed with error " + 0, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public CustomerDto updateCustomer(long id, CustomerDto customerDto) {
        try{
            Optional<CustomerEntity> optionalCustomerEntity = customerRepository.findById(id);  //error occured here so changed integer to Long in Customer Repository
            if (!optionalCustomerEntity.isPresent()) {
                throw new AppException("Customer Does Not Exist", HttpStatus.BAD_REQUEST);
            }
            CustomerEntity newcustomerEntity =  customerMapper.toCustomerEntity(customerDto);
            CustomerEntity customerEntity =  customerRepository.save(newcustomerEntity);
            CustomerDto responseCustomerDto = customerMapper.toCustomerDto(customerEntity);
            return responseCustomerDto;
        } catch (Exception e){
            throw new AppException("Request failed with error " + 0, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public CustomerDto deleteCustomer(long id) {
        try {
            Optional<CustomerEntity> optionalCustomerEntity = customerRepository.findById(id);
            if (!optionalCustomerEntity.isPresent()) {
                throw new AppException("Customer Does Not Exist", HttpStatus.BAD_REQUEST);
            }
            customerRepository.deleteById(id);
            return customerMapper.toCustomerDto(optionalCustomerEntity.get());
        } catch (Exception e) {
            throw new AppException("Request failed with error " + 0, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
