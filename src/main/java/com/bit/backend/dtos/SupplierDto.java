package com.bit.backend.dtos;

public class SupplierDto {
    private Long id;
    private String supplierName;
    private String nic;
    private String address;
    private String phoneNumber;
    private String businessType;
    private String email;

    public SupplierDto(Long id, String supplierName, String nic, String address, String phoneNumber, String businessType, String email) {
        this.id = id;
        this.supplierName = supplierName;
        this.nic = nic;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.businessType = businessType;
        this.email = email;
    }

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getSupplierName() {return supplierName;}

    public void setSupplierName(String supplierName) {this.supplierName = supplierName;}

    public String getNic() {return nic;}

    public void setNic(String nic) {this.nic = nic;}

    public String getAddress() {return address;}

    public void setAddress(String address) {this.address = address;}

    public String getPhoneNumber() {return phoneNumber;}

    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

    public String getBusinessType() {return businessType;}

    public void setBusinessType(String businessType) {this.businessType = businessType;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}





}
