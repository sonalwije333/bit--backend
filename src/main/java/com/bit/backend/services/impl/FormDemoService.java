package com.bit.backend.services.impl;

import com.bit.backend.dtos.FormDemoDto;
import com.bit.backend.entities.FormDemoEntity;
import com.bit.backend.mappers.FormDemoMapper;
import com.bit.backend.repositories.FormDemoRepository;
import com.bit.backend.services.FormDemoServiceI;
import org.springframework.stereotype.Service;

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
        System.out.println("*******In Backend*******");

        // Convert DTO to Entity
        FormDemoEntity formDemoEntity = formDemoMapper.toFormDemoEntity(formDemoDto);

        // Save entity to repository
        FormDemoEntity savedItem = formDemoRepository.save(formDemoEntity);

        // Convert Entity back to DTO
        return formDemoMapper.toFormDemoDto(savedItem);
    }
}
