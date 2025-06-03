package com.bit.backend.services.impl;

import com.bit.backend.dtos.ItemRegistrationDto;
import com.bit.backend.entities.ItemRegistrationEntity;
import com.bit.backend.exceptions.AppException;
import com.bit.backend.mappers.ItemRegistrationMapper;
import com.bit.backend.repositories.ItemRegistrationRepository;
import com.bit.backend.services.ItemRegistrationServiceI;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemRegistrationService implements ItemRegistrationServiceI {

    private final ItemRegistrationRepository itemRegistrationRepository;
    private final ItemRegistrationMapper itemRegistrationMapper;

    public ItemRegistrationService(ItemRegistrationRepository itemRegistrationRepository,
                                   ItemRegistrationMapper itemRegistrationMapper) {
        this.itemRegistrationRepository = itemRegistrationRepository;
        this.itemRegistrationMapper = itemRegistrationMapper;
    }

    @Override
    public ItemRegistrationDto addItemRegistrationEntity(ItemRegistrationDto itemRegistrationDto) {
        try {
            System.out.println("*******In Backend*******");
            ItemRegistrationEntity entity = itemRegistrationMapper.toItemRegistrationEntity(itemRegistrationDto);
            ItemRegistrationEntity saved = itemRegistrationRepository.save(entity);
            return itemRegistrationMapper.toItemRegistrationDto(saved);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<ItemRegistrationDto> getData() {
        try {
            List<ItemRegistrationEntity> entityList = itemRegistrationRepository.findAll();
            return itemRegistrationMapper.toItemRegistrationDtoList(entityList);
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ItemRegistrationDto updateItemRegistration(long id, ItemRegistrationDto itemRegistrationDto) {
        try {
            Optional<ItemRegistrationEntity> optional = itemRegistrationRepository.findById(id);
            if (!optional.isPresent()) {
                throw new AppException("Item does not exist", HttpStatus.BAD_REQUEST);
            }

            ItemRegistrationEntity updatedEntity = itemRegistrationMapper.toItemRegistrationEntity(itemRegistrationDto);
            updatedEntity.setId(id); // ensure correct id for update
            ItemRegistrationEntity saved = itemRegistrationRepository.save(updatedEntity);
            return itemRegistrationMapper.toItemRegistrationDto(saved);

        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ItemRegistrationDto deleteItemRegistration(long id) {
        try {
            Optional<ItemRegistrationEntity> optional = itemRegistrationRepository.findById(id);
            if (!optional.isPresent()) {
                throw new AppException("Item does not exist", HttpStatus.BAD_REQUEST);
            }
            itemRegistrationRepository.deleteById(id);
            return itemRegistrationMapper.toItemRegistrationDto(optional.get());
        } catch (Exception e) {
            throw new AppException("Request failed with error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
