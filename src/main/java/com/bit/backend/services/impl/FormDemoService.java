package com.bit.backend.services.impl;

import com.bit.backend.dtos.FormDemoDto;
import com.bit.backend.entities.FormDemoEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.FormDemoMapper;
import com.bit.backend.repositories.FormDemoRepository;
import com.bit.backend.services.FormDemoServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FormDemoService implements FormDemoServiceI {

    private final FormDemoRepository formDemoRepository;
    private final FormDemoMapper formDemoMapper;


    // Constructor for dependency injection
    public FormDemoService(FormDemoRepository formDemoRepository, FormDemoMapper formDemoMapper) {
        this.formDemoRepository = formDemoRepository;
        this.formDemoMapper = formDemoMapper;

    }

    @Override
    public FormDemoDto addFormDemoEntity(FormDemoDto formDemoDto) {
        try{
            System.out.println("*******In Backend*******");
            // Convert DTO to Entity
            FormDemoEntity formDemoEntity = formDemoMapper.toFormDemoEntity(formDemoDto);
            // Save entity to repository
            FormDemoEntity savedItem = formDemoRepository.save(formDemoEntity);
            // Convert Entity back to DTO
            return formDemoMapper.toFormDemoDto(savedItem);
        } catch (Exception e){
       throw new AppException("Request failed with error " + 0, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @Override
    public List<FormDemoDto> getData() {
    // db operations and send data
        try{
            List<FormDemoEntity> formDemoEntityList = formDemoRepository.findAll();
            List<FormDemoDto> formDemoDtoList =  formDemoMapper.toFormDemoDtoList(formDemoEntityList);
            return formDemoDtoList;

        } catch (Exception e){
            throw new AppException("Request failed with error " + 0, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    @Override
    public FormDemoDto updateFormDemo(long id, FormDemoDto formDemoDto) {

        try{
            Optional<FormDemoEntity> optionalFormDemoEntity = formDemoRepository.findById(id);

            if (!optionalFormDemoEntity.isPresent()) {
                throw new AppException("Form Demo Does Not Exist", HttpStatus.BAD_REQUEST);
            }
            FormDemoEntity newformDemoEntity =  formDemoMapper.toFormDemoEntity(formDemoDto);

            FormDemoEntity formDemoEntity =  formDemoRepository.save(newformDemoEntity);

            FormDemoDto responseFormDemoDto = formDemoMapper.toFormDemoDto(formDemoEntity);
            return responseFormDemoDto;

        } catch (Exception e){
      //  FormDemoDto newFormDemoDto = new FormDemoDto();
        throw new AppException("Request failed with error " + 0, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @Override
    public FormDemoDto deleteFormDemo(long id) {
            try {
                Optional<FormDemoEntity> optionalFormDemoEntity = formDemoRepository.findById(id);

                if (!optionalFormDemoEntity.isPresent()) {
                    throw new AppException("Form Demo Does Not Exist", HttpStatus.BAD_REQUEST);
                }

                formDemoRepository.deleteById(id);
                return formDemoMapper.toFormDemoDto(optionalFormDemoEntity.get());

            } catch (Exception e) {
                throw new AppException("Request failed with error " + 0, HttpStatus.INTERNAL_SERVER_ERROR);

            }
        }}
