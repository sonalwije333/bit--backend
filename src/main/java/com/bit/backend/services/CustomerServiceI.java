package com.bit.backend.services;

import com.bit.backend.dtos.CustomerDto;


import java.util.List;

public interface CustomerServiceI {
    CustomerDto  addCustomerEntity(CustomerDto customerDto);
    List<CustomerDto> getData();
    CustomerDto updateCustomerEntity(long id, CustomerDto customerDto);
    CustomerDto deleteCustomer(long id);


}
