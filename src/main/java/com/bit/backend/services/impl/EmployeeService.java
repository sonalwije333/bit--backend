package com.bit.backend.services.impl;
import com.bit.backend.dtos.EmployeeDto;
import com.bit.backend.entities.EmployeeEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.EmployeeMapper;
import com.bit.backend.repositories.EmployeeRepository;
import com.bit.backend.services.EmployeeServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements EmployeeServiceI {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeService(EmployeeRepository employeeRepository, EmployeeMapper employeeMapper) {
        this.employeeRepository = employeeRepository;
        this.employeeMapper = employeeMapper;
    }


    @Override
    public EmployeeDto addEmployeeEntity(EmployeeDto employeeDto) {
        try {
            System.out.println("*******In Backend*******");
            // Convert DTO to Entity
            EmployeeEntity employeeEntity = employeeMapper.toEmployeeEntity(employeeDto);
            // Save entity to repository
            EmployeeEntity savedItem = employeeRepository.save(employeeEntity);
            // Convert Entity back to DTO
            return employeeMapper.toEmployeeDto(savedItem);
        } catch (Exception e) {
            throw new AppException("Request failed with error " + 0, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<EmployeeDto> getData() {
        try {
            List<EmployeeEntity> employeeEntityList = employeeRepository.findAll();
            List<EmployeeDto> employeeDtoList = employeeMapper.toEmployeeDtoList(employeeEntityList);
            return employeeDtoList;

        } catch (Exception e) {
            throw new AppException("Request failed with error " + 0, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public EmployeeDto updateEmployee(long id, EmployeeDto employeeDto) {
        try {
            Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findById(id);
            if (!optionalEmployeeEntity.isPresent()) {
                throw new AppException("Employee does not exist", HttpStatus.BAD_REQUEST);
            }
            EmployeeEntity newemployeeEntity = employeeMapper.toEmployeeEntity(employeeDto);
            EmployeeEntity employeeEntity = employeeRepository.save(newemployeeEntity);
            EmployeeDto responseEmployeeDto = employeeMapper.toEmployeeDto(employeeEntity);
            return responseEmployeeDto;
        } catch (Exception e) {
            throw new AppException("Request failed with error " + 0, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public EmployeeDto deleteEmployee(long id) {
        try {
            Optional<EmployeeEntity> optionalEmployeeEntity = employeeRepository.findById(id);
            if (!optionalEmployeeEntity.isPresent()) {
                throw new AppException("Employee Does Not Exist", HttpStatus.BAD_REQUEST);
            }
            employeeRepository.deleteById(id);
            return employeeMapper.toEmployeeDto(optionalEmployeeEntity.get());
        } catch (Exception e) {
            throw new AppException("Request failed with error " + 0, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}