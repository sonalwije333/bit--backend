package com.bit.backend.dtos;

public class ItemRegistrationDto {
    private Long id;
    private String itemName;
    
    private String genericName;
    private String formulation;
    private String type;
    private String consumeType;
    private String description;
    private String packSize;
    private String unitOfMeasure;
    private String batchNumber;
    private String expiryDate;
    private String prescriptionRequired;
    private String reorderLevel;
    private String selectedImageName;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getGenericName() {
        return genericName;
    }

    public void setGenericName(String genericName) {
        this.genericName = genericName;
    }

    public String getFormulation() {
        return formulation;
    }

    public void setFormulation(String formulation) {
        this.formulation = formulation;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getConsumeType() {
        return consumeType;
    }

    public void setConsumeType(String consumeType) {
        this.consumeType = consumeType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPackSize() {
        return packSize;
    }

    public void setPackSize(String packSize) {
        this.packSize = packSize;
    }

    public String getUnitOfMeasure() {
        return unitOfMeasure;
    }

    public void setUnitOfMeasure(String unitOfMeasure) {
        this.unitOfMeasure = unitOfMeasure;
    }

    public String getBatchNumber() {
        return batchNumber;
    }

    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getPrescriptionRequired() {
        return prescriptionRequired;
    }

    public void setPrescriptionRequired(String prescriptionRequired) {
        this.prescriptionRequired = prescriptionRequired;
    }

    public String getReorderLevel() {
        return reorderLevel;
    }

    public void setReorderLevel(String reorderLevel) {
        this.reorderLevel = reorderLevel;
    }

    public String getSelectedImageName() {
        return selectedImageName;
    }

    public void setSelectedImageName(String selectedImageName) {
        this.selectedImageName = selectedImageName;
    }



    public ItemRegistrationDto(Long id, String itemName, String genericName, String formulation, String type, String consumetype, String description, String packSize, String unitOfMeasure, String batchNumber, String expiryDate, String prescriptionRequired, String reorderlevel, String selectedImageName) {
        this.id = id;
        this.itemName = itemName;
        this.genericName = genericName;
        this.formulation = formulation;
        this.type = type;
        this.consumeType = consumeType;
        this.description = description;
        this.packSize = packSize;
        this.unitOfMeasure = unitOfMeasure;
        this.batchNumber = batchNumber;
        this.expiryDate = expiryDate;
        this.prescriptionRequired = prescriptionRequired;
        this.reorderLevel = reorderLevel;
        this.selectedImageName = selectedImageName;
    }








}
