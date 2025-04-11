package com.bit.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "employee")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "imageUpload")
    private String imageUpload;

    @Column(name = "employeeNumber")
    private String employeeNumber;

    @Column(name = "fullName")
    private String fullName;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "nic")
    private String nic;

    @Column(name = "role")
    private String role;

    @Column(name = "age")
    private int age;

    @Column(name = "gender")
    private String gender;

    @Column(name = "address")
    private String address;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "emergencyPhoneNumber")
    private String emergencyPhoneNumber;

    public EmployeeEntity(Long id, String imageUpload, String employeeNumber, String fullName, String firstName, String lastName, String nic, String role, int age, String gender, String address, String phoneNumber, String email, String emergencyPhoneNumber) {
        this.id = id;
        this.imageUpload = imageUpload;
        this.employeeNumber = employeeNumber;
        this.fullName = fullName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.nic = nic;
        this.role = role;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.emergencyPhoneNumber = emergencyPhoneNumber;
    }

    public EmployeeEntity() {}

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getImageUpload() {return imageUpload;}

    public void setImageUpload(String imageUpload) {this.imageUpload = imageUpload;}

    public String getEmployeeNumber() {return employeeNumber;}

    public void setEmployeeNumber(String employeeNumber) {this.employeeNumber = employeeNumber;}

    public String getFullName() {return fullName;}

    public void setFullName(String fullName) {this.fullName = fullName;}

    public String getFirstName() {return firstName;}

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getNic() {return nic;}

    public void setNic(String nic) {this.nic = nic;}

    public String getRole() {return role;}

    public void setRole(String role) {this.role = role;}

    public int getAge() {return age;}

    public void setAge(int age) {this.age = age;}

    public String getGender() {return gender;}

    public void setGender(String gender) {this.gender = gender;}

    public String getAddress() {return address;}

    public void setAddress(String address) {this.address = address;}

    public String getPhoneNumber() {return phoneNumber;}

    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public String getEmergencyPhoneNumber() {return emergencyPhoneNumber;}

    public void setEmergencyPhoneNumber(String emergencyPhoneNumber) {this.emergencyPhoneNumber = emergencyPhoneNumber;}
}
